package aldora.spring.reactivetest.bootstrap;

import aldora.spring.reactivetest.model.Post;
import aldora.spring.reactivetest.model.User;
import aldora.spring.reactivetest.repositories.PostRepository;
import aldora.spring.reactivetest.repositories.UserRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DataBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private PostRepository postRepository;
    private UserRepository userRepository;

    public DataBootstrap(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        Post post1 = new Post();
        post1.setContent("Santa, Santa");
        Post savedPost1 = postRepository.save(post1).block();

        Post post2 = new Post();
        post2.setContent("House");
        Post savedPost2 = postRepository.save(post2).block();

        User user = new User();
        user.setName("Tika");
        user.getPosts().add(savedPost1);
        user.getPosts().add(savedPost2);
        userRepository.save(user).block();

        User fetched = userRepository.findById(user.getId()).block();

        System.out.println("#########");
        System.out.println("insert post");
    }
}