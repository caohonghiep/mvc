package website.livemarketing.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import website.livemarketing.dao.EmployeeDao;
import website.livemarketing.model.Employee;


@Service("EmployeeService")
@Transactional
public class EmployeeService extends SuperService<EmployeeDao,Employee,Integer>{

	public List<Employee> findAllEmployees() {
		return super.findAll();
	}

	public void saveEmployee(Employee employee) {
		super.insert(employee);
		
	}

	public void deleteEmployeeBySsn(String ssn) {
		dao.deleteEmployeeBySsn(ssn);
		
	}

	

}
