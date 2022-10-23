package ru.denis.shop.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.denis.shop.payload.request.CathedraCreateRequest;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Cathedra {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    public String name;
    public String shortName;
    @Lob
    @Column(name = "description", columnDefinition="TEXT")
    public String description;

    @OneToMany
    public List<User> teachers = new ArrayList<>();

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "zavcathedra_id")
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    public User zavCathedra;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "faculty_id")
    public Faculty faculty;

    @OneToMany(cascade = CascadeType.ALL)
    public List<Speciality> specialityList = new ArrayList<>();

    public Cathedra (CathedraCreateRequest cathedraCreateRequest,
                     User zavCathedra,
                     Faculty faculty,
                     List<User> teachers) {
        this.name = cathedraCreateRequest.name;
        this.shortName = cathedraCreateRequest.shortName;
        this.description = cathedraCreateRequest.description;
        this.teachers = teachers;
        this.zavCathedra = zavCathedra;
        this.faculty = faculty;
    }
}
