package aldora.spring.test.repositories;

import aldora.spring.test.model.singleTable.SingleTableCustomer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface SingleTableCustomerRepo extends CrudRepository<SingleTableCustomer, Long> {
}
