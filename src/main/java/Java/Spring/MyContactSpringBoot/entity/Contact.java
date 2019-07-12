package Java.Spring.MyContactSpringBoot.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "contact")
@Data
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotEmpty
    @Column(name = "name", nullable = false)
    private String name;

    @Email
    @NotEmpty
    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;


}