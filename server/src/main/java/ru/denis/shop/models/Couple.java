package ru.denis.shop.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.denis.shop.models.AcademicGroup;
import ru.denis.shop.models.Subject;
import ru.denis.shop.models.User;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class Couple {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @ManyToOne
    public Subject subject;

    @ManyToOne
    public AcademicGroup academicGroup;

    @ManyToOne
    public User teacher;

    public LocalDateTime performedAt;

    public Couple(Subject subject, AcademicGroup academicGroup, User teacher, LocalDateTime performedAt) {
        this.subject = subject;
        this.academicGroup = academicGroup;
        this.teacher = teacher;
        this.performedAt = performedAt;
    }
}
