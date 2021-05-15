package aldora.spring.test.repositories;

import aldora.spring.test.model.singleTable.SingleTablePerson;
import org.springframework.data.repository.CrudRepository;

public interface SingleTablePersonRepo extends CrudRepository<SingleTablePerson, Long> {
}
