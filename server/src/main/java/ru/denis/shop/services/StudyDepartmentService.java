package ru.denis.shop.services;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.denis.shop.models.*;
import ru.denis.shop.payload.request.AcademicGroupRequest;
import ru.denis.shop.payload.request.CoupleCreateRequest;
import ru.denis.shop.payload.request.SubjectCreateRequest;
import ru.denis.shop.payload.response.AcademicGroupResponse;
import ru.denis.shop.payload.response.CoupleResponse;
import ru.denis.shop.repository.*;

@Service
@AllArgsConstructor
public class StudyDepartmentService {
    public final CoupleRepository coupleRepository;
    public final SubjectRepository subjectRepository;
    public final UserRepository userRepository;
    public final CathedraRepository cathedraRepository;
    public final AcademicGroupRepository academicGroupRepository;

    public ResponseEntity createSubject(SubjectCreateRequest subjectCreateRequest) {
        ESubject passType;
        switch (subjectCreateRequest.passType) {
            case "exam":
                passType = ESubject.TYPE_EXAM;
                break;
            case "diffoffset":
                passType = ESubject.TYPE_DIFFOFFSET;
            default:
                passType = ESubject.TYPE_OFFSET;
        }

        Subject subject = new Subject(subjectCreateRequest.name, passType);
        subjectRepository.save(subject);

        return new ResponseEntity<>(subject, HttpStatus.CREATED);
    }

    public ResponseEntity createAcademicGroup(AcademicGroupRequest academicGroupRequest) {
        Cathedra cathedra = cathedraRepository.findById(academicGroupRequest.cathedra).get();

        AcademicGroup academicGroup = new AcademicGroup(academicGroupRequest.name, cathedra, academicGroupRequest.kurs);
        academicGroupRepository.save(academicGroup);

        return new ResponseEntity<>(new AcademicGroupResponse(academicGroup), HttpStatus.CREATED);
    }

    public ResponseEntity createCouple(CoupleCreateRequest coupleCreateRequest) {
        User user = userRepository.findById(coupleCreateRequest.teacherId).get();
        Subject subject = subjectRepository.findById(coupleCreateRequest.subjectId).get();
        AcademicGroup academicGroup = academicGroupRepository.findById(coupleCreateRequest.academicGroupId).get();

        Couple couple = new Couple(subject, academicGroup, user, coupleCreateRequest.performedAt);
        coupleRepository.save(couple);

        return new ResponseEntity<>(new CoupleResponse(couple), HttpStatus.CREATED);
    }


}
