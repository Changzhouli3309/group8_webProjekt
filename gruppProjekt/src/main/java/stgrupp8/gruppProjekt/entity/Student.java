package stgrupp8.gruppProjekt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity(name = "student")
public class Student implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String student_id;

	@Column(nullable = false, length = 20)
	private String name, last_name;

	@Column(nullable = false)
	private int age;

	@Column(nullable = false)
	private boolean present;

	public Student() {
		//for jpa
	}

	public Student(String name, String last_name, int age, boolean present) {
		this.name = name;
		this.last_name = last_name;
		this.age = age;
		this.present = present;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isPresent() {
		return present;
	}

	public void setPresent(boolean present) {
		this.present = present;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getStudent_id() {
		return student_id;
	}
}
