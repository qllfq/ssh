package com.qiaolulu.employee.dao;

import java.util.List;

import com.qiaolulu.employee.domain.Department;

/**
 * 部门管理的DAO层接口类
 */
public interface DepartmentDao {
	//查询总记录数
	int findCount();
	//查询部门员工总集合
	List<Department> findByPage(int begin, int pageSize);
	//添加部门
	void save(Department department);
	//编辑部门
	Department findById(Integer did);
	//更新部门
	void upate(Department department);
	//删除部门
	void delete(Department department);
	//查询所有部门信息
	List<Department> findAll();

}
