package fci.engaly.dao;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import fci.engaly.model.Employee;

import java.util.List;

public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {

    @Query("SELECT DISTINCT e.dept FROM Employee e")
    List<String> findAllDepartments(Sort sort);
}