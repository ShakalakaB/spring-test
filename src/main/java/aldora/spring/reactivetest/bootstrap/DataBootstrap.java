package aldora.spring.reactivetest.bootstrap;

import aldora.spring.reactivetest.model.Post;
import aldora.spring.reactivetest.model.User;
import aldora.spring.reactivetest.repositories.reactive.PostReactiveRepository;
import aldora.spring.reactivetest.repositories.reactive.UserReactiveRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DataBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private PostReactiveRepository postReactiveRepository;
    private UserReactiveRepository userReactiveRepository;

    public DataBootstrap(PostReactiveRepository postReactiveRepository, UserReactiveRepository userReactiveRepository) {
        this.postReactiveRepository = postReactiveRepository;
        this.userReactiveRepository = userReactiveRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        Post post1 = new Post();
        post1.setContent("Santa, Santa");
        Post savedPost1 = postReactiveRepository.save(post1).block();

        Post post2 = new Post();
        post2.setContent("House");
        Post savedPost2 = postReactiveRepository.save(post2).block();

        User user = new User();
        user.setName("Tika");
        user.getPosts().add(savedPost1);
        user.getPosts().add(savedPost2);
        userReactiveRepository.save(user).block();

        User fetched = userReactiveRepository.findById(user.getId()).block();

        System.out.println("#########");
        System.out.println("insert post");
    }
}
