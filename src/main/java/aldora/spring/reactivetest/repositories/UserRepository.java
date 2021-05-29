package aldora.spring.reactivetest.repositories;

import aldora.spring.reactivetest.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {
}
