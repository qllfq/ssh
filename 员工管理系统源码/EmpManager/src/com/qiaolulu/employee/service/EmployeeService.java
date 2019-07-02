package com.qiaolulu.employee.service;

import com.qiaolulu.employee.domain.Employee;
import com.qiaolulu.employee.domain.PageBean;

/**
 * 员工管理的业务层的接口
 */
public interface EmployeeService {

	Employee login(Employee employee);
	//分页查询
	PageBean<Employee> findAll(Integer currPage);
	//添加员工
	void save(Employee employee);
	//根据员工编号查询员工信息
	Employee findById(Integer eid);
	//更新员工信息
	void update(Employee employee);
	//根据员工id删除员工
	void delete(Employee employee);
	
}
