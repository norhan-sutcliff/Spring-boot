package com.spring.boot.repository;

import com.spring.boot.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    @Query("SELECT e FROM Employee e WHERE e.name LIKE :namePattern")
    List<Employee> findByNameLike(@Param("namePattern") String namePattern);

    @Query(value = "SELECT * FROM employee WHERE name LIKE :namePattern", nativeQuery = true)
    List<Employee> searchByNameNative(@Param("namePattern") String namePattern);
}
