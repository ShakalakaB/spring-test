package aldora.spring.mongotest.bootstrap;

import aldora.spring.mongotest.model.Post;
import aldora.spring.mongotest.model.User;
import aldora.spring.mongotest.repositories.PostRepository;
import aldora.spring.mongotest.repositories.UserRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DataBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public DataBootstrap(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        Post post1 = new Post();
        post1.setContent("Santa, Santa");
        Post savedPost1 = postRepository.save(post1);

        Post post2 = new Post();
        post2.setContent("House");
        Post savedPost2 = postRepository.save(post2);

        User user = new User();
        user.setName("Tika");
        user.getPosts().add(savedPost1);
        user.getPosts().add(savedPost2);
        userRepository.save(user);

        System.out.println("#########");
        System.out.println("insert post");
    }
}
