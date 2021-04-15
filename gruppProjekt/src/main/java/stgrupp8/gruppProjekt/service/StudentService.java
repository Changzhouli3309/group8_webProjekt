package stgrupp8.gruppProjekt.service;

import java.util.List;
import java.util.Optional;

import stgrupp8.gruppProjekt.entity.Student;

public interface StudentService {

	Student createStudent(Student s);

	List<Student> findAll();

	Optional<Student> findStudentById(String sid);

	Student updateStudent(String sid, String name, String last_name, int age, boolean present);

	boolean deleteSudent(String sid);

}