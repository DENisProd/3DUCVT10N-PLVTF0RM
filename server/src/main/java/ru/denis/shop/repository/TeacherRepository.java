package ru.denis.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.denis.shop.models.users.Student;
import ru.denis.shop.models.users.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    @Query(value = "SELECT * FROM teacher WHERE teacher_id= :teacher_id", nativeQuery = true)
    Teacher getTeacherByTeacher_Id(@Param("teacher_id") Long teacher_id);
}
