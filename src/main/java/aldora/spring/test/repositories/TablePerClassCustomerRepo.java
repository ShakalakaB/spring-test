package aldora.spring.test.repositories;

import aldora.spring.test.model.tablePerClass.TablePerClassCustomer;
import org.springframework.data.repository.CrudRepository;

public interface TablePerClassCustomerRepo extends CrudRepository<TablePerClassCustomer, Long> {
}
