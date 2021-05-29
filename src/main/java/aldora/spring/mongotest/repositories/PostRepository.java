package aldora.spring.mongotest.repositories;

import aldora.spring.mongotest.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String> {
}
