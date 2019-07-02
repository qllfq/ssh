package com.qiaolulu.employee.dao;

import java.util.List;

import com.qiaolulu.employee.domain.Employee;

/**
 * 员工管理的DAO的接口
 */
public interface EmployeeDao {

	Employee findByUsernameAndPassword(Employee employee);
	//统计员工个数
	int fintCount();
	//获取员工集合信息
	List<Employee> findByPage(int begin, int pageSize);
	//添加员工
	void save(Employee employee);
	//根据员工编号查询员工信息
	Employee finById(Integer eid);
	//更新员工信息
	void update(Employee employee);
	//根据员工id删除员工
	void delete(Employee employee);

}
