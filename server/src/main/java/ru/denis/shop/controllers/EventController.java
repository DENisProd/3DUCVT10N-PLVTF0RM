package ru.denis.shop.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import ru.denis.shop.payload.request.EventCreateRequest;
import ru.denis.shop.services.EventService;
import ru.denis.shop.services.UserDetailsImpl;

import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/event")
@AllArgsConstructor
public class EventController {

    private final EventService eventService;

    @PostMapping("/")
    @PreAuthorize("hasRole('PROF_LEADER') or hasRole('STUDSOVET_LEADER') or hasRole('SCIENCE_LEADER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity eventCreate(@RequestBody EventCreateRequest eventCreateRequest) {
        UserDetailsImpl userImp = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return eventService.createEvent(eventCreateRequest, userImp);
    }

    @GetMapping("/")
    public ResponseEntity getAll(@RequestParam("tag") Optional<String> tag) {
        String tagStr = tag.orElse("");
        return eventService.fetchAll(tagStr);
    }

    @GetMapping("/top/")
    public ResponseEntity getTop() {
        return eventService.fetchTop();
    }

    @GetMapping("/{eventId}")
    public ResponseEntity getOne(@PathVariable("eventId") Long eventId) {
        return eventService.fetchOneById(eventId);
    }
}
