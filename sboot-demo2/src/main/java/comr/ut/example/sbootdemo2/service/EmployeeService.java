package comr.ut.example.sbootdemo2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;


import comr.ut.example.sbootdemo2.dao.EmployeeDao;
import comr.ut.example.sbootdemo2.entity.Employee;
import comr.ut.example.sbootdemo2.util.ResponseStructure;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeDao employeeDao;
	
	public ResponseEntity<ResponseStructure<Employee>> saveEmployee(Employee employee)
	{
		employeeDao.saveEmployee(employee);
		ResponseStructure<Employee> structure=new ResponseStructure<>();
		structure.setStatusCode(HttpStatus.CREATED.value());
		structure.setMessage("data saved");
		structure.setData(employee);
		return new ResponseEntity<ResponseStructure<Employee>>(structure,HttpStatus.CREATED);
		
	}
	
	public ResponseEntity<ResponseStructure<List<Employee>>> getAllEmployee()
	{
		List<Employee>  list=employeeDao.getAllEmployee();
		ResponseStructure<List<Employee>> structure=new ResponseStructure<>();
		structure.setStatusCode(HttpStatus.CREATED.value());
		structure.setMessage("Retrived all data");
		structure.setData(list);
		return new ResponseEntity<ResponseStructure<List<Employee>>>(structure,HttpStatus.CREATED);	
	}
	
	public ResponseEntity<ResponseStructure<Employee>> getById(@PathVariable int id)
	{
		Optional<Employee> op=employeeDao.getById(id);
		ResponseStructure<Employee> structure=new ResponseStructure<>();
		if(op.isPresent())
		{
			structure.setStatusCode(HttpStatus.CREATED.value());
			structure.setMessage("Employee found");
			structure.setData(op.get());
			return new ResponseEntity<ResponseStructure<Employee>>(structure,HttpStatus.CREATED);
		}
		else
		{
			structure.setStatusCode(HttpStatus.NOT_FOUND.value());
			structure.setMessage("employee not found");
			structure.setData(null);
			return new ResponseEntity<ResponseStructure<Employee>>(structure,HttpStatus.NOT_FOUND);
		}
			
	}
	
	public ResponseEntity<ResponseStructure<List<Employee>>> getByName(@PathVariable String name)
	{
		List<Employee> list=employeeDao.getByName(name);
		ResponseStructure<List<Employee>> structure=new ResponseStructure<>();
		if(list.isEmpty())
		{
			structure.setStatusCode(HttpStatus.NOT_FOUND.value());
			structure.setMessage("data  not found by name");
			structure.setData(list);
			return new ResponseEntity<ResponseStructure<List<Employee>>> (structure,HttpStatus.NOT_FOUND);
		}
		else
		{
		structure.setStatusCode(HttpStatus.ACCEPTED.value());
		structure.setMessage("data found by name");
		structure.setData(list);
		return new ResponseEntity<ResponseStructure<List<Employee>>> (structure,HttpStatus.ACCEPTED);
	}
	}
	
	public ResponseEntity<ResponseStructure<Employee>> updateEmployee(Employee employee)
	{
		employeeDao.updateEmployee(employee);
		ResponseStructure<Employee> structure=new ResponseStructure<>();
		structure.setStatusCode(HttpStatus.CREATED.value());
		structure.setMessage("data updated");
		structure.setData(employee);
		return new ResponseEntity<ResponseStructure<Employee>> (structure,HttpStatus.CREATED);	
	}
	
	public ResponseEntity<ResponseStructure<Employee>> deleteEmployee(int id,Employee employee)
	{
		employeeDao.deleteEmployee(id,employee);
		ResponseStructure<Employee> structure=new  ResponseStructure<>();
		structure.setStatusCode(HttpStatus.CREATED.value());
		structure.setMessage("Data is deleted");
		structure.setData(null);
		return new ResponseEntity<ResponseStructure<Employee>> (structure,HttpStatus.CREATED);
		
	}
}

