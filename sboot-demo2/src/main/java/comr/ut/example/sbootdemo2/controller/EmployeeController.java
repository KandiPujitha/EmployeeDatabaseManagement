package comr.ut.example.sbootdemo2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import comr.ut.example.sbootdemo2.entity.Employee;
import comr.ut.example.sbootdemo2.service.EmployeeService;
import comr.ut.example.sbootdemo2.util.ResponseStructure;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class EmployeeController {
	
	@Autowired
	 private EmployeeService employeeService;
	
	
	@Operation(description = "save employee", summary="to save employee")
	@ApiResponses(value= {@ApiResponse(description = "Success",responseCode = "200"),
	@ApiResponse(description = "Failure",responseCode = "404")})
	@GetMapping("/save")
	public ResponseEntity<ResponseStructure<Employee>> saveEmployee(@RequestBody Employee employee)
	{
		return employeeService.saveEmployee(employee);
	}
	
	
	@Operation(description = "Getall employee", summary="to getall employee")
	@ApiResponses(value= {@ApiResponse(description = "Success",responseCode = "200"),
	@ApiResponse(description = "Failure",responseCode = "404")})
	@GetMapping("/getall")
	public ResponseEntity<ResponseStructure<List<Employee>>> getAllEmployee()
	{
		return employeeService.getAllEmployee();
	}
	
	
	@Operation(description = "GetById employee", summary="to getbyid employee")
	@ApiResponses(value= {@ApiResponse(description = "Success",responseCode = "200"),
	@ApiResponse(description = "Failure",responseCode = "404")})
	@GetMapping("/getbyid/{id}")
	public ResponseEntity<ResponseStructure<Employee>> getById(@PathVariable int id)
	{
		return employeeService.getById(id);
	}
	
	@Operation(description = "retrive employee", summary="to retrive employee")
	@ApiResponses(value= {@ApiResponse(description = "Success",responseCode = "200"),
	@ApiResponse(description = "Failure",responseCode = "404")})
	@GetMapping("/getbyname/{name}")
	public ResponseEntity<ResponseStructure<List<Employee>>> getByName(@PathVariable String name)
	{
		return employeeService.getByName(name);
	}
	
	@Operation(description = "update employee", summary="to update employee")
	@ApiResponses(value= {@ApiResponse(description = "Success",responseCode = "200"),
	@ApiResponse(description = "Failure",responseCode = "404")})
	@PostMapping("/update")
	public ResponseEntity<ResponseStructure<Employee>> updateEmployee(@RequestBody Employee employee)
	{
		return employeeService.updateEmployee(employee);
	}
	
	@Operation(description = "delete employee", summary="to delete employee")
	@ApiResponses(value= {@ApiResponse(description = "Success",responseCode = "200"),
	@ApiResponse(description = "Failure",responseCode = "404")})
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ResponseStructure<Employee>> deleteEmployee(@PathVariable int id,Employee employee)
	{
		return employeeService.deleteEmployee(id, employee);
	}

}
