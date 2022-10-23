package ru.denis.shop.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.denis.shop.payload.request.AcademicGroupRequest;
import ru.denis.shop.payload.request.SubjectCreateRequest;
import ru.denis.shop.services.StudyDepartmentService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/study_department")
@AllArgsConstructor
public class StudyDepartmentController {

    public final StudyDepartmentService studyDepartmentService;

    @PostMapping("/group/")
    @PreAuthorize("hasRole('ADMIN') or hasRole('ROLE_UCHEB_OTDEL')")
    public ResponseEntity createGroup(@RequestBody AcademicGroupRequest academicGroupRequest) {
        return studyDepartmentService.createAcademicGroup(academicGroupRequest);
    }

    @PostMapping("/subject/")
    @PreAuthorize("hasRole('ADMIN') or hasRole('ROLE_UCHEB_OTDEL')")
    public ResponseEntity createSubject(@RequestBody SubjectCreateRequest subjectCreateRequest) {
        return studyDepartmentService.createSubject(subjectCreateRequest);
    }

}
