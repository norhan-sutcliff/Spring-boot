package com.spring.boot.repo;

import com.spring.boot.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByIdList(List<Long> ids);

    List<Employee> findByNameList(List<String> names);
}
