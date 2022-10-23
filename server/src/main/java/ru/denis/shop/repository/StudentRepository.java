package ru.denis.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.denis.shop.models.users.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query(value = "SELECT * FROM student WHERE student_id= :studentId", nativeQuery = true)
    Student getStudentByStudent_Id(@Param("studentId") Long studentId);

//    Student getStudentByStudentId_Id(Long studentId);
}
