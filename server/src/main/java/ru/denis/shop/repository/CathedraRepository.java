package ru.denis.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.denis.shop.models.Cathedra;

import java.util.List;

@Repository
public interface CathedraRepository extends JpaRepository<Cathedra, Long> {
    Cathedra findCathedraByName(Long cathedraName);

    @Query(value = "SELECT * FROM cathedra WHERE faculty_id= :facultyId", nativeQuery = true)
    List<Cathedra> findCathedraByFac(@Param("facultyId") Long facultyId);
}
