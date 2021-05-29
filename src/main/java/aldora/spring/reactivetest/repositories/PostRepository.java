package aldora.spring.reactivetest.repositories;

import aldora.spring.reactivetest.model.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, String> {
}
