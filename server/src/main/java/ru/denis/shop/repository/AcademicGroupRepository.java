package ru.denis.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.denis.shop.models.AcademicGroup;

@Repository
public interface AcademicGroupRepository extends JpaRepository<AcademicGroup, Long> {
}
