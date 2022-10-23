package ru.denis.shop.payload.request;

import ru.denis.shop.models.User;

import javax.persistence.ElementCollection;
import java.util.List;

public class EventCreateRequest {
    public String title;
    public String shortText;
    public String fullText;
    public List<String> tagList;
    public Long authorId;
}
