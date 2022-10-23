package ru.denis.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.denis.shop.models.users.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
