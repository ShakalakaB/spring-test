package aldora.spring.mongotest.bootstrap;

import aldora.spring.mongotest.model.Post;
import aldora.spring.mongotest.repositories.PostRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DataBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private final PostRepository postRepository;

    public DataBootstrap(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        Post post = new Post();
        post.setContent("Santa, Santa");
        Post savedPost = postRepository.save(post);

        System.out.println("#########");
        System.out.println("insert post");
    }
}
