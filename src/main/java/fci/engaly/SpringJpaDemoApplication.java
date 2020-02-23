package fci.engaly;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fci.engaly.many2many.crud.M2MCRUD;
import fci.engaly.one2many.crud.O2MCRUD;

@SpringBootApplication
public class SpringJpaDemoApplication implements CommandLineRunner {

	// @Autowired
	// O2MCRUD crud;

	@Autowired
	M2MCRUD m2mCRUD;

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// operate with one 2 many association
		// crud.insert();
		// crud.findById(1l);
		// crud.findAll();

		// operate with many 2 many association
//		m2mCRUD.insert();
//		m2mCRUD.findStudentAndCourses(1l);

	}
}
