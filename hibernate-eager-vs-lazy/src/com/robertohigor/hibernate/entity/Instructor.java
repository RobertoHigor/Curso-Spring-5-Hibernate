package com.robertohigor.hibernate.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Instructor {

	@Id
	@Column
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column
	private String email;
	
	@OneToOne(cascade=CascadeType.ALL) // Relação One to One com Cascade
	@JoinColumn(name="instructor_detail_id") // O nome da chave estrangeira
	private InstructorDetail instructorDetail;
	
	/* EAGER irá carregar o instrutor e os cursos ao mesmo tempo.
	* A lista de cursos já estará na memória, não sendo necessário acessar o 
	* banco de dados novamente
	*/ 
	
	/* LAZY irá carregar os cursos somente sob demanda
	 * 
	 */
	@OneToMany(fetch=FetchType.LAZY, mappedBy="instructor", 
	cascade= {
			CascadeType.MERGE,
			CascadeType.DETACH,
			CascadeType.REFRESH,
			CascadeType.PERSIST
	})
	private List<Course> courses;
	
	public Instructor() {}

	public Instructor(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	/* 
	 * Método para ajudar no relacionamento bi-direcional
	 */	
	public void add(Course tempCourse) {
		if (courses == null) {
			courses = new ArrayList<>();
		}
		
		courses.add(tempCourse);
		tempCourse.setInstructor(this);
	}
	
	
	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public InstructorDetail getInstructorDetail() {
		return instructorDetail;
	}

	public void setInstructorDetail(InstructorDetail instructorDetail) {
		this.instructorDetail = instructorDetail;
	}

	@Override
	public String toString() {
		return "Instructor [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", instructorDetail=" + instructorDetail + "]";
	}
	
	
}
