package ru.denis.shop.payload.request;

import java.util.List;

public class FacultyCreateRequest {
    public String name;
    public String shortName;
    public String description;
    public String location;
    public String contacts;

    public Long deanId;
    public List<Long> subDeanList;
    public List<Long> cathedraList;
}
