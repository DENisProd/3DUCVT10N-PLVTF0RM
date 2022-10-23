package ru.denis.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.denis.shop.models.Speciality;

import java.util.List;

@Repository
public interface SpecialityRepository extends JpaRepository<Speciality, Long> {
    @Query(value = "SELECT * FROM speciality WHERE cathedra_id= :cathedraId", nativeQuery = true)
    List<Speciality> getAllByCathedra_Id(@Param("cathedraId") Long cathedraId);
}
