package aldora.spring.reactivetest.repositories;

import aldora.spring.reactivetest.model.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface UserRepository extends ReactiveMongoRepository<User, String> {
}
