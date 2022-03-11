package net.proselyte.jwtappdemo.model;

import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;



@Entity
@Table(name = "roles")
@Data
public class Role extends BaseEntity {
//сущность с таблицей roles


    @Column(name = "name")
    private String name;

    // для организации связи в User
    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    private List<User> users;

    @Override
    public String toString() {
        return "Role{" +
                "id: " + super.getId() + ", " +
                "name: " + name + "}";
    }
}
