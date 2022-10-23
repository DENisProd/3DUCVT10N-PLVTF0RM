package ru.denis.shop.payload.response;

import ru.denis.shop.models.users.Teacher;

public class TeacherResponse {

    public Long id;
    public UserResponse user;
    public String education;
    public String degree;

    public TeacherResponse(Teacher teacher) {
        this.id = teacher.getId();
        this.user = new UserResponse(teacher.teacherId);
        this.education = teacher.getEducation();
        this.degree = teacher.getEducation();
    }
}
