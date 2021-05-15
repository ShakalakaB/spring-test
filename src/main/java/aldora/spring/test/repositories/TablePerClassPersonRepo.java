package aldora.spring.test.repositories;

import aldora.spring.test.model.tablePerClass.TablePerClassPerson;
import org.springframework.data.repository.CrudRepository;

public interface TablePerClassPersonRepo extends CrudRepository<TablePerClassPerson, Long> {
}
