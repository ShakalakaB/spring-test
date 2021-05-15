package aldora.spring.test.repositories;

import aldora.spring.test.model.mappedSuperclass.MappedSuperclassCustomer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface MappedSuperCustomerRepo extends CrudRepository<MappedSuperclassCustomer, Long> {
}
