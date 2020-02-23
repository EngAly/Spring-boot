package fci.engaly.many2many.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fci.engaly.many2many.models.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{

}
