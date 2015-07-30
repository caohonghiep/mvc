package website.livemarketing.dao;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import website.livemarketing.model.Employee;

@Repository("employeeDao")
public class EmployeeDao extends SuperDao<Employee,Integer> {	
	public void deleteEmployeeBySsn(String ssn) {
		Query query = getSession().createSQLQuery("delete from Employee where ssn = :ssn");
		query.setString("ssn", ssn);
		query.executeUpdate();
	}
}