package aldora.spring.reactivetest.repositories;

import aldora.spring.reactivetest.model.Post;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface PostRepository extends ReactiveMongoRepository<Post, String> {
}
