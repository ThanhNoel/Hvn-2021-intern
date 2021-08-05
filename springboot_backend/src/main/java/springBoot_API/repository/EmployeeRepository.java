package springBoot_API.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springBoot_API.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
