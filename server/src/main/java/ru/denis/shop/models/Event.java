package ru.denis.shop.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.denis.shop.payload.request.EventCreateRequest;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long Id;

    public String title;
    public String shortText;
    @Lob
    @Column(name = "full_text", columnDefinition="TEXT")
    public String fullText;
    @ElementCollection
    public List<String> tagList;
    @OneToMany
    public List<User> likesList = new ArrayList<>();
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    public User author;
    public LocalDateTime createdDate = LocalDateTime.now();
    public Integer views = 0;
    public Boolean isModerated = false;

    public Event(String title, String shortText, String fullText, List<String> tagList, List<User> likesList, User author) {
        this.title = title;
        this.shortText = shortText;
        this.fullText = fullText;
        this.tagList = tagList;
        this.author = author;
    }

    public Event(EventCreateRequest eventCreateRequest, User author) {
        this.title = eventCreateRequest.title;
        this.shortText = eventCreateRequest.shortText;
        this.fullText = eventCreateRequest.fullText;
        this.tagList = eventCreateRequest.tagList;
        this.author = author;
    }
}
