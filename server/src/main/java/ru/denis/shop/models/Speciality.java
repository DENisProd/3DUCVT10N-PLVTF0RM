package ru.denis.shop.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.denis.shop.payload.request.SpecialityCreateRequest;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Speciality {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    public String name;
    public String academGroup;
    @Lob
    @Column(name = "description", columnDefinition="TEXT")
    public String description;

    @ManyToOne
    public Cathedra cathedra;

    public Speciality(SpecialityCreateRequest specialityCreateRequest, Cathedra cathedra) {
        this.name = specialityCreateRequest.name;
        this.academGroup = specialityCreateRequest.academGroup;
        this.description = specialityCreateRequest.description;
        this.cathedra = cathedra;
    }
}
