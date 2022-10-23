package ru.denis.shop.models.users;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.denis.shop.models.AcademicGroup;
import ru.denis.shop.models.User;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teacher_id")
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    public User teacherId;
    public String education;
    public String degree;

    public Teacher(User teacher, String education, String degree) {
        this.teacherId = teacher;
        this.education = education;
        this.degree = degree;
    }
}
