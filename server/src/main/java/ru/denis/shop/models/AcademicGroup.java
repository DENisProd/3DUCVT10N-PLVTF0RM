package ru.denis.shop.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class AcademicGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    public String name;
    @ManyToOne
    public Faculty faculty;
    @ManyToOne
    public Cathedra cathedra;
    public Integer kurs = 1;

    public AcademicGroup(String name, Cathedra cathedra, Integer kurs) {
        this.name = name;
        faculty = cathedra.getFaculty();
        this.cathedra = cathedra;
        this.kurs = kurs;
    }
}
