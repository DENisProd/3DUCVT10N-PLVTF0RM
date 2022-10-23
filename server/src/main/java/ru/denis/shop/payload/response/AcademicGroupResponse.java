package ru.denis.shop.payload.response;

import ru.denis.shop.models.AcademicGroup;
import ru.denis.shop.models.Cathedra;
import ru.denis.shop.models.Faculty;

import javax.persistence.ManyToOne;

public class AcademicGroupResponse {
    public Long id;
    public String name;
    public Long facultyId;
    public String facultyName;
    public Long cathedraId;
    public String cathedraName;
    public Integer kurs;

    public AcademicGroupResponse(AcademicGroup academicGroup) {
        this.id = academicGroup.getId();
        this.name = academicGroup.getName();
        this.facultyId = academicGroup.getFaculty().getId();
        this.facultyName = academicGroup.getFaculty().getName();
        this.cathedraId = academicGroup.getCathedra().getId();
        this.cathedraName = academicGroup.getCathedra().getName();
        this.kurs = academicGroup.getKurs();
    }
}
