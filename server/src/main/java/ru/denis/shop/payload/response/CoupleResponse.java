package ru.denis.shop.payload.response;

import ru.denis.shop.models.Couple;

import java.time.LocalDateTime;

public class CoupleResponse {
    public Long id;
    public Long subjectId;
    public Long academicGroupId;
    public Long teacherId;
    public LocalDateTime performedAt;

    public CoupleResponse(Couple couple) {
        id = couple.id;
        subjectId = couple.getSubject().getId();
        academicGroupId = couple.getAcademicGroup().getId();
        teacherId = couple.getTeacher().getId();
        performedAt = couple.getPerformedAt();
    }
}
