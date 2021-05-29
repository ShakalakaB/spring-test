package aldora.spring.reactivetest.repositories.reactive;

import aldora.spring.reactivetest.model.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface UserReactiveRepository extends ReactiveMongoRepository<User, String> {
}
