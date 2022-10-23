package ru.denis.shop.models.users;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.denis.shop.models.User;

import javax.persistence.*;

//@Table(name = "employee")
@Entity
@Data
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id")
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    public User employee;

    public Integer salary = 0;
}
