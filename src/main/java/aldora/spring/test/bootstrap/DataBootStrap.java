package aldora.spring.test.bootstrap;

import aldora.spring.test.model.joinedTable.JoinTableCustomer;
import aldora.spring.test.model.mappedSuperclass.MappedSuperclassCustomer;
import aldora.spring.test.model.singleTable.SingleTableCustomer;
import aldora.spring.test.model.tablePerClass.TablePerClassCustomer;
import aldora.spring.test.model.tablePerClass.TablePerClassPerson;
import aldora.spring.test.repositories.*;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DataBootStrap implements ApplicationListener<ContextRefreshedEvent> {
    private final MappedSuperCustomerRepo mappedSuperCustomerRepo;
    private final SingleTablePersonRepo singleTablePersonRepo;
    private final JoinedCustomerRepo joindCustomerRepo;
    private final TablePerClassCustomerRepo tablePerClassCustomerRepo;
    private final TablePerClassPersonRepo tablePerClassPersonRepo;

    public DataBootStrap(MappedSuperCustomerRepo mappedSuperCustomer,
                         SingleTablePersonRepo singleTablePersonRepo,
                         JoinedCustomerRepo joindCustomerRepo,
                         TablePerClassCustomerRepo tablePerClassCustomerRepo,
                         TablePerClassPersonRepo tablePerClassPersonRepo) {
        this.mappedSuperCustomerRepo = mappedSuperCustomer;
        this.singleTablePersonRepo = singleTablePersonRepo;
        this.joindCustomerRepo = joindCustomerRepo;
        this.tablePerClassCustomerRepo = tablePerClassCustomerRepo;
        this.tablePerClassPersonRepo = tablePerClassPersonRepo;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        System.out.println("------mappedSuperclass");
        MappedSuperclassCustomer mappedSuperclassCustomer = new MappedSuperclassCustomer();
        mappedSuperclassCustomer.setCompany("A company");
        mappedSuperclassCustomer.setName("customer A");
        mappedSuperCustomerRepo.save(mappedSuperclassCustomer);

        System.out.println("------single table");
        SingleTableCustomer singleTableCustomer = new SingleTableCustomer();
        singleTableCustomer.setCompany("B company");
        singleTableCustomer.setName("customer B");
        singleTablePersonRepo.save(singleTableCustomer);

        System.out.println("------joined table");
        JoinTableCustomer joinTableCustomer = new JoinTableCustomer();
        joinTableCustomer.setCompany("B company");
        joinTableCustomer.setName("customer B");
        joinTableCustomer.setAddress("address B");
        joindCustomerRepo.save(joinTableCustomer);

        System.out.println("------table per class");
        TablePerClassCustomer tablePerClassCustomer = new TablePerClassCustomer();
        tablePerClassCustomer.setCompany("B company");
        tablePerClassCustomer.setName("customer B");
        tablePerClassCustomerRepo.save(tablePerClassCustomer);

        TablePerClassCustomer tablePerClassCustomer2 = new TablePerClassCustomer();
        tablePerClassCustomer2.setCompany("c company");
        tablePerClassCustomer2.setName("customer c");
        tablePerClassCustomerRepo.save(tablePerClassCustomer2);

        TablePerClassPerson tablePerClassPerson = new TablePerClassPerson();
        tablePerClassPerson.setName("person A");
        tablePerClassPersonRepo.save(tablePerClassPerson);
    }
}
