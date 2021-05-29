package aldora.spring.reactivetest.repositories.reactive;

import aldora.spring.reactivetest.model.Post;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface PostReactiveRepository extends ReactiveMongoRepository<Post, String> {
}
