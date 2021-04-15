package stgrupp8.gruppProjekt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import stgrupp8.gruppProjekt.entity.Student;
import stgrupp8.gruppProjekt.repository.StudentRepo;

@Service
public class StudentServiceImp implements StudentService {
	
	private StudentRepo stu_rep;
	
	@Autowired
	public StudentServiceImp(StudentRepo stu_rep) {
		this.stu_rep = stu_rep;
	}
	
	@Override
	public Student createStudent(Student s) {
		return stu_rep.save(s);
	}
	
	@Override
	public List<Student> findAll(){
		return (List<Student>)stu_rep.findAll();
	}
	
	@Override
	public Optional<Student> findStudentById(String sid) {
		return stu_rep.findById(sid);
	}
	
	@Override
	public Student updateStudent(String sid, String name, String last_name, int age, boolean present) {
		Optional<Student> ops = findStudentById(sid);
		if(ops.isPresent()) {
			Student s = ops.get();
			s.setName(name);
			s.setLast_name(last_name);
			s.setAge(age);
			s.setPresent(present);
			return stu_rep.save(s);
		}else {
			return null;
		}
	}
	
	@Override
	public boolean deleteSudent(String sid) {
		Optional<Student> s = findStudentById(sid);
		if(s.isPresent()) {
			stu_rep.delete(s.get());
			return true;
		}else {
			return false;
		}
	}
}
