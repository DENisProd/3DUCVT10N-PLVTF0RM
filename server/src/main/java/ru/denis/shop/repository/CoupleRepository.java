package ru.denis.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.denis.shop.models.Couple;

import java.util.ArrayList;

@Repository
public interface CoupleRepository extends JpaRepository<Couple, Long> {
    //@Query(value = "SELECT * FROM couple WHERE ", nativeQuery = true)
    //ArrayList<Couple> getAllByAcademicGroup_Cathedra_Id(Long cathedraId);
    //ArrayList<Couple> getAllByAcademicGroup_Faculty_Id(Long facultyId);
    //ArrayList<Couple> getAllByAcademicGroup_Id(Long academicGroupId);
    @Query(value = "SELECT * FROM couple WHERE teacher_id= :teacherId", nativeQuery = true)
    ArrayList<Couple> getAllByTeacher_Id(@Param("teacherId") Long teacherId);

    @Query(value = "SELECT * FROM couple WHERE subject_id= :subjectId", nativeQuery = true)
    ArrayList<Couple> getAllBySubject_Id(@Param("subjectId") Long subjectId);

    @Query(value = "SELECT * FROM couple WHERE academic_group_id= :groupId", nativeQuery = true)
    ArrayList<Couple> getAllByAcademicGroup_Id(@Param("groupId") Long groupId);
}
