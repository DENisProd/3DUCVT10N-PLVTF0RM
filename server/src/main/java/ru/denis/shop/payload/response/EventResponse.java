package ru.denis.shop.payload.response;

import ru.denis.shop.models.Event;
import ru.denis.shop.models.User;

import java.time.LocalDateTime;
import java.util.List;

public class EventResponse {
    public Long id;
    public String title;
    public String shortText;
    public String fullText;
    public List<String> tagList;
    public Long authorId;
    public Integer views;
    public List<Long> likesList;
    public LocalDateTime createdDate;
    public Boolean isModerated;

    public EventResponse(Event event) {
        this.id = event.getId();
        this.title = event.getTitle();
        this.shortText = event.getShortText();
        this.fullText = event.getFullText();
        this.tagList = event.getTagList();
        this.authorId = event.getAuthor().getId();
        this.views = event.getViews();
        this.isModerated = event.getIsModerated();

        for (User user: event.getLikesList())
            likesList.add(user.getId());

        this.createdDate = event.getCreatedDate();
    }
}
