package aldora.spring.test.model.singleTable;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
public class SingleTableCustomer extends SingleTablePerson {
    private String company;

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
