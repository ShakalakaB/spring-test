package aldora.spring.reactivetest.bootstrap;

import aldora.spring.reactivetest.model.Post;
import aldora.spring.reactivetest.model.User;
import aldora.spring.reactivetest.repositories.PostRepository;
import aldora.spring.reactivetest.repositories.UserRepository;
import aldora.spring.reactivetest.repositories.reactive.PostReactiveRepository;
import aldora.spring.reactivetest.repositories.reactive.UserReactiveRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DataBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private final PostReactiveRepository postReactiveRepository;
    private final UserReactiveRepository userReactiveRepository;
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public DataBootstrap(PostReactiveRepository postReactiveRepository, UserReactiveRepository userReactiveRepository, PostRepository postRepository, UserRepository userRepository) {
        this.postReactiveRepository = postReactiveRepository;
        this.userReactiveRepository = userReactiveRepository;
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        reactiveBootstrap();
//        blockingBootstrap();

        System.out.println("#########");
        System.out.println("insert post");
    }

    private void reactiveBootstrap() {
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
    }

    private void blockingBootstrap() {
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

        User fetched = userReactiveRepository.findById(user.getId()).block();
    }
}
