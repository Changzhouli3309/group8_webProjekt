package stgrupp8.gruppProjekt.repository;

import org.springframework.data.repository.CrudRepository;

import stgrupp8.gruppProjekt.entity.Student;

public interface StudentRepo extends CrudRepository<Student, String>{

}
