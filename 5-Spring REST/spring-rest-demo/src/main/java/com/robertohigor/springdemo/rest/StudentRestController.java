package com.robertohigor.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
		
		// Checar se o valor passado não está fora do limite
		if ( (studentId >= theStudents.size()) || (studentId < 0) ) {
			throw new StudentNotFoundException("Student id not found - " + studentId);
		}
		return theStudents.get(studentId);
	} 
	
	// Código movido para a classe de Global Exception
	
	/* Exception handler para o studentNotFound
	 * O método é responsável por retornar um objeto HTTP.
	 * Esse é o método específico do StudentNotFoundException
	 */
//	@ExceptionHandler
//	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc) {
//		// Criar o StudentErrorResponse com a mensagem de erro para ser convertida em JSON
//		StudentErrorResponse error = new StudentErrorResponse();
//		
//		error.setStatus(HttpStatus.NOT_FOUND.value());
//		error.setMessage(exc.getMessage());
//		error.setTimeStamp(System.currentTimeMillis());
//		
//		// Retornar body e status code do ResponseEntity	
//		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
//	}
	
	// Exception handler para qualquer tipo de exceção
//	@ExceptionHandler
//	public ResponseEntity<StudentErrorResponse> handleException(Exception exc) {
//		// Criar o StudentErrorResponse com a mensagem de erro para ser convertida em JSON
//		StudentErrorResponse error = new StudentErrorResponse();
//		
//		error.setStatus(HttpStatus.BAD_REQUEST.value());
//		error.setMessage(exc.getMessage());
//		error.setTimeStamp(System.currentTimeMillis());
//		
//		// Retornar body e status code do ResponseEntity	
//		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
//	}
	
}
