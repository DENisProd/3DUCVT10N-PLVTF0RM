package ru.denis.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.denis.shop.models.Faculty;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Long> {
    Faculty findFacultyByName (String name);
}
