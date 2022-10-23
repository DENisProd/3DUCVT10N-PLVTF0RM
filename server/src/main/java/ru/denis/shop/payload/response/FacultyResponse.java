package ru.denis.shop.payload.response;

import ru.denis.shop.models.Cathedra;
import ru.denis.shop.models.Faculty;
import ru.denis.shop.models.User;

import java.util.ArrayList;
import java.util.List;

public class FacultyResponse {
    public Long id;
    public String name;
    public String shortName;
    public String description;
    public String location;
    public String contacts;
    public UserResponse dean;
    public List<User> subDeans;
    public List<CathedraResponse> cathedraList = new ArrayList<>();

    public FacultyResponse(Faculty faculty) {
        this.id = faculty.Id;
        this.name = faculty.getName();
        this.shortName = faculty.getShortName();
        this.description = faculty.getDescription();
        this.location = faculty.getLocation();
        this.contacts = faculty.getContacts();
        this.dean = new UserResponse(faculty.getDean());
        this.subDeans = faculty.getSubDeans();

        for (Cathedra cathedra : faculty.getCathedraList())
            cathedraList.add(new CathedraResponse(cathedra));

    }
}
