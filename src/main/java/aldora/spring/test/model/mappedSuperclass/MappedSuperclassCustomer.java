package aldora.spring.test.model.mappedSuperclass;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
public class MappedSuperclassCustomer extends Person{
    private String company;

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
