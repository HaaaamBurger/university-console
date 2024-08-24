package com.console.university_console.repository;

import com.console.university_console.model.Department;
import com.console.university_console.model.Lector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, String> {
    List<Department> findAllByNameLikeIgnoreCase(String name);
//    @Query("SELECT l FROM Lector l JOIN l.headingDepartment d WHERE d.departmentId = :departmentId")
//    List<Lector> findLectorsByDepartmentId(@Param("departmentId") String departmentId);
}
