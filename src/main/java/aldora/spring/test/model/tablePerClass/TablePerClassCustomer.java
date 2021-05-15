package aldora.spring.test.model.tablePerClass;

import javax.persistence.Entity;

@Entity
public class TablePerClassCustomer extends TablePerClassPerson {
    private String company;

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
