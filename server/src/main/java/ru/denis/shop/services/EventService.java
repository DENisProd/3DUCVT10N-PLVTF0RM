package ru.denis.shop.services;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.denis.shop.models.Event;
import ru.denis.shop.models.User;
import ru.denis.shop.payload.request.EventCreateRequest;
import ru.denis.shop.payload.response.EventResponse;
import ru.denis.shop.repository.EventRepository;
import ru.denis.shop.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class EventService {

    private final UserRepository userRepository;
    private final EventRepository eventRepository;

    public ResponseEntity createEvent(EventCreateRequest eventCreateRequest, UserDetailsImpl userImpl) {
        User user = userRepository.findById(userImpl.getId()).get();
        Event event = new Event(eventCreateRequest, user);

        eventRepository.save(event);

        return new ResponseEntity<>(new EventResponse(event), HttpStatus.CREATED);
    }

    public ResponseEntity fetchAll(String tag) {
        List<Event> events = eventRepository.findAll();
        if (tag.length()>0) {
            List<Event> filteredEvents = new ArrayList<>();
            for (Event el : events) {
                for (int i = 0; i < el.tagList.size(); i++)
                    if (el.tagList.get(i).contains(tag))
                        filteredEvents.add(el);
            }

            List<EventResponse> eventsWithHiddenInfo = new ArrayList<>();

            for (Event event: filteredEvents)
                eventsWithHiddenInfo.add(new EventResponse(event));

            return new ResponseEntity<>(eventsWithHiddenInfo, HttpStatus.OK);
        }

        List<EventResponse> eventsWithHiddenInfo = new ArrayList<>();

        for (Event event: events)
            eventsWithHiddenInfo.add(new EventResponse(event));

        return new ResponseEntity<>(eventsWithHiddenInfo, HttpStatus.OK);
    }

    public ResponseEntity fetchTop() {
        List<Event> events = eventRepository.findTop10ByOrderByViewsDesc();
        List<EventResponse> eventsWithHiddenInfo = new ArrayList<>();

        for (Event event: events)
            eventsWithHiddenInfo.add(new EventResponse(event));

        return new ResponseEntity<>(eventsWithHiddenInfo, HttpStatus.OK);
    }

    public ResponseEntity fetchOneById(Long eventId) {
        Event event = eventRepository.findById(eventId).get();

        event.views++;
        eventRepository.save(event);

        return new ResponseEntity<>(new EventResponse(event), HttpStatus.OK);
    }

    public ResponseEntity updateInfo(EventCreateRequest eventCreateRequest, UserDetailsImpl userImpl) {
        return new ResponseEntity<>("", HttpStatus.ACCEPTED);
    }
}
