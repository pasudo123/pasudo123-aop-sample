package edu.pasudo123.aop.app.repository;

import edu.pasudo123.aop.app.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by pasudo123 on 2019-10-21
 * Blog: https://pasudo123.tistory.com/
 * Email: oraedoa@gmail.com
 **/
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
