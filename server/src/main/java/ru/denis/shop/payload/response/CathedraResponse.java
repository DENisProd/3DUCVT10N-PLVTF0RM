package ru.denis.shop.payload.response;

import ru.denis.shop.models.Cathedra;
import ru.denis.shop.models.Speciality;
import ru.denis.shop.models.User;

import java.util.ArrayList;
import java.util.List;

public class CathedraResponse {

    public Long id;
    public String name;
    public String shortName;
    public String description;
    public List<UserResponse> teachers;
    public UserResponse zavCathedra;
    public Long facultyId;
    public List<SpecialityResponse> specialityList = new ArrayList<>();

    public CathedraResponse(Cathedra cathedra) {
        this.id = cathedra.getId();
        this.name = cathedra.getName();
        this.shortName = cathedra.getName();
        this.description = cathedra.getDescription();

        for (User user: cathedra.getTeachers())
            teachers.add(new UserResponse(user));

        this.zavCathedra = new UserResponse(cathedra.getZavCathedra());
        this.facultyId = cathedra.getFaculty().getId();

        for (Speciality speciality: cathedra.getSpecialityList())
            specialityList.add(new SpecialityResponse(speciality));
    }


    //this.dean = new UserResponse(faculty.getDean());
}
