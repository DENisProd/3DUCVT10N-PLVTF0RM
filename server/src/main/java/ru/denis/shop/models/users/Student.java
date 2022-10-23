package ru.denis.shop.models.users;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.web.embedded.undertow.UndertowServletWebServer;
import ru.denis.shop.models.AcademicGroup;
import ru.denis.shop.models.User;

import javax.persistence.*;
import java.util.ArrayList;

//@Table(name = "student")
@Entity
@Data
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id")
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    public User studentId;
    public Integer recordNumber = 1000000;
    @ManyToOne
    public AcademicGroup academicGroup;
    public Integer balls = 0;
    //public List<Subject> completedSubjects = new ArrayList<>();

    public Student(User student, Integer recordNumber, AcademicGroup academicGroup) {
        this.studentId = student;
        this.recordNumber = recordNumber;
        this.academicGroup = academicGroup;
    }
}
