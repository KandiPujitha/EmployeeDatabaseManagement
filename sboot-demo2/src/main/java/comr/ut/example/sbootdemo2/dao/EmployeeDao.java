package comr.ut.example.sbootdemo2.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import comr.ut.example.sbootdemo2.entity.Employee;
import comr.ut.example.sbootdemo2.repository.EmployeeRepository;

@Repository
public class EmployeeDao {
	
	@Autowired
	 private EmployeeRepository employeeRepository;
	
	public Employee saveEmployee(Employee employee)
	{
		return employeeRepository.save(employee);
	}
	
	public List<Employee> getAllEmployee()
	{
		return employeeRepository.findAll();
	}
	
	public Optional<Employee> getById(int id)
	{
		return employeeRepository.findById(id);
	}
	
	public List<Employee> getByName(String name)
	{
		return employeeRepository.getByName(name);
	}

	public Employee updateEmployee(Employee employee)
	{
		return employeeRepository.save(employee);
	}
	
	public String deleteEmployee(int id,Employee employee)
	{
		employeeRepository.delete(employee);
		return "data is deleted";
	}
}
