package ru.denis.shop.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.denis.shop.repository.CathedraRepository;
import ru.denis.shop.services.DeanService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/dean")
@AllArgsConstructor
public class DeanController {

    private final DeanService deanService;

    @GetMapping("/faculty/")
    public ResponseEntity fetchAll() {
        return deanService.fetchAll();
    }

    @GetMapping("/cathedra/")
    public ResponseEntity fetchAllCathedra() {
        return deanService.fetchAllCathedra();
    }

    @GetMapping("/cathedra/{facultyId}")
    public ResponseEntity fetchAllFromFaculty(@PathVariable("facultyId") Long facultyId) {
        return deanService.fetchAllCathedrasByFaculty(facultyId);
    }

    @GetMapping("/speciality/{cathedraId}")
    public ResponseEntity fetchAllSpecialitiesByCathedra(@PathVariable("cathedraId") Long cathedraId) {
        return deanService.fetchAllSpecialitiesByCathedra(cathedraId);
    }

}
