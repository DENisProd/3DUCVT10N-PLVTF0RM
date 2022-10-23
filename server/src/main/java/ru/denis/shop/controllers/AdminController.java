package ru.denis.shop.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.denis.shop.payload.request.*;
import ru.denis.shop.services.AdminService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/admin")
@AllArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @PostMapping("/faculty/")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity createFaculty(@RequestBody FacultyCreateRequest facultyCreateRequest) {
        return adminService.createFaculty(facultyCreateRequest);
    }

    @PostMapping("/cathedra/")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity createCathedra(@RequestBody CathedraCreateRequest cathedraCreateRequest) {
        return adminService.createCathedra(cathedraCreateRequest);
    }

    @PostMapping("/speciality/")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity createSpecialities(@RequestBody SpecialityCreateRequest specialityCreateRequest) {
        return adminService.createSpeciality(specialityCreateRequest);
    }

    @PostMapping("/student/")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity createStudent(@RequestBody StudentCreateRequest studentCreateRequest) {
        return adminService.createStudent(studentCreateRequest);
    }

    @PostMapping("/teacher/")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity createTeacher(@RequestBody TeacherCreateRequest teacherCreateRequest) {
        return adminService.createTeacher(teacherCreateRequest);
    }

    @GetMapping("/users/")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity getAllUsers() {
        return adminService.getAllUsers();
    }

    @PostMapping("/user/")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity updateUser(@RequestBody UserChangeRequest userChangeRequest) {
        return adminService.changeUserInformation(userChangeRequest);
    }

    @PostMapping("/event/{eventId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity moderateEvent(@RequestBody ModerateStateEventRequest state, @PathVariable("eventId") Long eventId) {
        if (state.state==null) return new ResponseEntity<>("state null", HttpStatus.OK);
        return adminService.moderateEvent(state.state, eventId);
    }
}
