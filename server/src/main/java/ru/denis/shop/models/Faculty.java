package ru.denis.shop.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.denis.shop.models.users.Employee;
import ru.denis.shop.payload.request.FacultyCreateRequest;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long Id;

    public String name;
    public String shortName;
    @Lob
    @Column(name = "description", columnDefinition="TEXT")
    public String description;
    public String location;
    public String contacts;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "dean_id")
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    public User dean;

    @OneToMany(cascade = CascadeType.ALL)
    public List<User> subDeans = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    public List<Cathedra> cathedraList = new ArrayList<>();

    public Faculty(FacultyCreateRequest facultyCreateRequest, User dean, List<Cathedra> cathedraList) {
        name = facultyCreateRequest.name;
        this.dean = dean;
        this.shortName = facultyCreateRequest.shortName;
        this.description = facultyCreateRequest.description;;
        this.cathedraList = cathedraList;
        this.location = facultyCreateRequest.location;
        this.contacts = facultyCreateRequest.contacts;
    }
}
