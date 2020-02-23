package fci.engaly.many2many.crud;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fci.engaly.many2many.models.Course;
import fci.engaly.many2many.models.Student;
import fci.engaly.many2many.repositories.CourseRepository;
import fci.engaly.many2many.repositories.StudentRepository;

@Component
public class M2MCRUD {

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	StudentRepository studentRepository;

	/**
	 * create group of records for student and courses and insert courses to
	 * student and insert students to courses
	 */
	public void insert() {
		try {
			// create group of students
			Student aly = new Student("aly ahemd", "123456790");
			Student hossam = new Student("hosam omara", "987654345");
			Student amira = new Student("amira badouin", "987654345");

			Course c1 = new Course("Spring Boot", "302");
			Course c2 = new Course("Spring MCV", "303");

			// add course references to student=>aly
			aly.getCourses().add(c1);
			aly.getCourses().add(c2);

			// add course references to student=>hossam
			hossam.getCourses().add(c1);

			// add course references to student=>aly
			amira.getCourses().add(c2);

			// add student references to courses
			c1.getStudent().add(aly);
			c2.getStudent().add(aly);

			// add student references to courses
			c1.getStudent().add(hossam);

			// add student references to courses
			c2.getStudent().add(amira);

			// create and save course with students
			studentRepository.save(aly);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * get all courses for specific student with its id
	 */
	public void findStudentAndCourses(Long id) {

		Student student = studentRepository.findById(id).get();

		// print student data
		System.out.println(student.toString());

		// get all courses for defined student
		for (Iterator<Course> course = student.getCourses().iterator(); course.hasNext();) {
			System.out.println(course.next().toString());

		}
	}
}
