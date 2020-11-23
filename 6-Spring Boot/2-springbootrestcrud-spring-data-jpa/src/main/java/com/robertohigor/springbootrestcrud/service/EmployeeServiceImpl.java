package com.robertohigor.springbootrestcrud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robertohigor.springbootrestcrud.dao.EmployeeRepository;
import com.robertohigor.springbootrestcrud.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;
	
	/*
	 * A annotation qualifier serve para dizer qual implementação do DAO utilizar.
	 * Lembrando que o argumento é o Bean ID, ou seja, começa com letra minúscula
	 */
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
		employeeRepository = theEmployeeRepository;
	}
	
	@Override
	public List<Employee> findAll() {		
		return employeeRepository.findAll();
	}

	@Override
	public Employee findById(int theId) {
		// O Optional é uma funcionalidade introduzida pelo JpaRepository
		//Aqui está sendo utilizada para retoranr um dado sem checar explicitamente por null.
		Optional<Employee> result = employeeRepository.findById(theId);
		
		Employee theEmployee = null;
		if (result.isPresent()) {
			theEmployee = result.get();
		}else {
			throw new RuntimeException("Não foi possível encontrar o employee id - " + theId);
		}
			
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
		employeeRepository.save(theEmployee);

	}

	@Override
	public void deleteById(int theId) {
		employeeRepository.deleteById(theId);

	}

}
