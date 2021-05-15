package aldora.spring.test.repositories;

import aldora.spring.test.model.joinedTable.JoinTableCustomer;
import org.springframework.data.repository.CrudRepository;

public interface JoinedCustomerRepo extends CrudRepository<JoinTableCustomer, Long> {
}
