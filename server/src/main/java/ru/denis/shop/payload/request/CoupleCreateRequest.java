package ru.denis.shop.payload.request;

import ru.denis.shop.models.Couple;

import java.time.LocalDateTime;

public class CoupleCreateRequest {
    public Long subjectId;
    public Long academicGroupId;
    public Long teacherId;
    public LocalDateTime performedAt;
}
