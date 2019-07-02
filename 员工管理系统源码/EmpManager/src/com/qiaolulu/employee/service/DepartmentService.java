package com.qiaolulu.employee.service;

import java.util.List;

import com.qiaolulu.employee.domain.Department;
import com.qiaolulu.employee.domain.PageBean;

/**
 * 部门管理的业务层接口类
 */
public interface DepartmentService {
	
	// 分页查询部分的方法
	PageBean<Department> findByPage(Integer currPage);
	// 进行部门的添加
	void save(Department department);
	//编辑部门信息
	Department findById(Integer did);
	//在业务层接口中更新部门信息
	void update(Department department);
	//删除部门
	void delete(Department department);
	//查询所有部门信息
	List<Department> findAll();

}
