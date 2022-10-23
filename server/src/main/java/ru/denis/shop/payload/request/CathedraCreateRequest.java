package ru.denis.shop.payload.request;

import ru.denis.shop.models.Faculty;
import ru.denis.shop.models.User;

import java.util.List;

public class CathedraCreateRequest {

    public String name;
    public String shortName;
    public String description;
    public List<Long> teachers;
    public Long zavCathedra;
    public Long faculty;
}
