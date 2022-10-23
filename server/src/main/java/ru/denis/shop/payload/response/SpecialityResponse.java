package ru.denis.shop.payload.response;

import ru.denis.shop.models.Speciality;

import javax.persistence.Column;
import javax.persistence.Lob;

public class SpecialityResponse {
    public Long id;
    public String name;
    public String academGroup;
    public String description;
    public Long cathedraId;

    public SpecialityResponse(Speciality speciality) {
        this.id = speciality.getId();
        this.name = speciality.getName();
        this.academGroup = speciality.getAcademGroup();
        this.description = speciality.getDescription();
        this.cathedraId = speciality.getCathedra().getId();
    }
}
