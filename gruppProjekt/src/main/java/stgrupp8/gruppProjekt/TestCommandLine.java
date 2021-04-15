package stgrupp8.gruppProjekt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import stgrupp8.gruppProjekt.entity.Student;
import stgrupp8.gruppProjekt.service.StudentService;

@Component
@Transactional(rollbackFor = Exception.class)
public class TestCommandLine implements CommandLineRunner {

	private StudentService stu_ser;


	@Autowired
	public TestCommandLine(StudentService stu_ser) {
		this.stu_ser = stu_ser;
	}

	@Override
	public void run(String... args) throws Exception {
		stu_ser.createStudent(new Student("aa","bb", 15 , true));
		stu_ser.createStudent(new Student("ac","ba", 16 , true));
		stu_ser.createStudent(new Student("ar","be", 17 , true));

	}

}
