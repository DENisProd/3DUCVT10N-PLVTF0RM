package ru.denis.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.denis.shop.models.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {
}
