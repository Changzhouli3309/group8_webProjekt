package stgrupp8.gruppProjekt.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import stgrupp8.gruppProjekt.entity.Student;
import stgrupp8.gruppProjekt.exception.BadRequestException;
import stgrupp8.gruppProjekt.exception.NoContentException;
import stgrupp8.gruppProjekt.exception.NotFoundException;
import stgrupp8.gruppProjekt.model.StudentRequestModel;
import stgrupp8.gruppProjekt.service.StudentService;

@RestController
@RequestMapping("/api") // http://localhost:8080/api/student
@CrossOrigin(origins = "http://localhost:3000")
public class StudentController {

	private StudentService stu_ser;

	@Autowired
	public StudentController(StudentService stu_ser) {
		this.stu_ser = stu_ser;
	}

	@GetMapping("/students")
	public ResponseEntity<List<Student>> getStudents() {
		List<Student> Students = stu_ser.findAll();
		if (Students.isEmpty()) {
			throw new NoContentException("204 No Content");
		} else {
			return ResponseEntity.ok(Students);
		}
	}

	@GetMapping("/student/{id}")
	public ResponseEntity<Student> getStudent(@PathVariable String id) {
		Optional<Student> p = stu_ser.findStudentById(id);
		if (p.isPresent()) {
			return ResponseEntity.ok(p.get());
		} else {
			throw new NotFoundException("404 Not Found");
		}
	}

	@PostMapping("/student")
	public ResponseEntity<Student> createStudent(@Validated @RequestBody StudentRequestModel studMod) {
		if (studMod.getName().equals("") || studMod.getLast_name().equals("") || studMod.getAge() < 0) {
			throw new BadRequestException("400 Bad Request");
		} else {
			Student saved = stu_ser.createStudent(
					new Student(studMod.getName(), studMod.getLast_name(), studMod.getAge(), studMod.isPresent()));

			return ResponseEntity.status(HttpStatus.CREATED).body(saved);
		}

	}

	@PutMapping("/student/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable String id, @RequestBody StudentRequestModel studMod) {
		if (id == null || studMod.getName().equals("") || studMod.getLast_name().equals("") || studMod.getAge() < 0
				|| studMod.getAge() < 0) {
			throw new BadRequestException("400 Bad Request");
		}

		Student s = stu_ser.updateStudent(id, studMod.getName(), studMod.getLast_name(), studMod.getAge(),
				studMod.isPresent());
		if (s.equals(null)) {
			throw new BadRequestException("400 Bad Request");
		}
		return ResponseEntity.ok(s);
	}

	@DeleteMapping("/student/{id}")
	public ResponseEntity<Student> deleteStudent(@PathVariable String id) {
		if (stu_ser.deleteSudent(id)) {
			return ResponseEntity.ok().build();
		} else {
			throw new BadRequestException("400 Bad Request");
		}
	}
}
