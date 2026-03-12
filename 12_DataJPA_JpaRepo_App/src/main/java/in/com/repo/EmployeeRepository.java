package in.com.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.com.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	@Query(value = "select * from emp_tbl", nativeQuery = true)
	public List<Employee> getEmps();

}
