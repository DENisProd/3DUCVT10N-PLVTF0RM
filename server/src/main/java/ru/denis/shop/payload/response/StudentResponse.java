package ru.denis.shop.payload.response;

import ru.denis.shop.models.AcademicGroup;
import ru.denis.shop.models.users.Student;

public class StudentResponse {
    public Long id;
    public UserResponse user;
    public Integer recordNumber;
    public AcademicGroupResponse academicGroup;
    public Integer balls;
    //public List<SubjectResponse> completedSubjects;

    public StudentResponse(Student student) {
        this.id = student.studentId.getId();
        this.user = new UserResponse(student.studentId);
        this.recordNumber = student.recordNumber;
        this.academicGroup = new AcademicGroupResponse(student.academicGroup);
        this.balls = student.getBalls();
    }
}
