package com.robertohigor.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.robertohigor.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	private List<Student> theStudents;
	/* Carregar dados na lista com o @PostConstruct.
	 * Nesse caso, a annotation carrega somente uma vez após o bean ser construido.
	 */
	@PostConstruct
	public void loadData() {
		theStudents = new ArrayList<>();
		
		theStudents.add(new Student("Mario", "Rossi"));
		theStudents.add(new Student("Fabio", "Silva"));
		theStudents.add(new Student("Carlos", "Alberto"));
	}

	@GetMapping("/students")
	public List<Student> getStudents() {	
		return theStudents;
	}
	
	@GetMapping("/student/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		return theStudents.get(studentId);
	}
	
}
