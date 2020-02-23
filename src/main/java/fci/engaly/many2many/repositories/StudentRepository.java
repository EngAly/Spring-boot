package fci.engaly.many2many.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fci.engaly.many2many.models.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

}
