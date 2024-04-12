package comr.ut.example.sbootdemo2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import comr.ut.example.sbootdemo2.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	public List<Employee> getByName(String name);

}
