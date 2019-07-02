package com.qiaolulu.employee.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.qiaolulu.employee.dao.EmployeeDao;
import com.qiaolulu.employee.domain.Employee;
import com.qiaolulu.employee.domain.PageBean;
import com.qiaolulu.employee.service.EmployeeService;
/**
 * 员工管理的业务层实现类
 */
@Transactional
public class EmployeeServiceImpl implements EmployeeService{
	private EmployeeDao employeeDao;
	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	
	@Override
	/**
	 * 业务层的登录的方法
	 */
	public Employee login(Employee employee) {
		Employee existEmployee = employeeDao.findByUsernameAndPassword(employee);
		return existEmployee;
	}

	@Override
	//分页查询
	public PageBean<Employee> findAll(Integer currPage) {
		PageBean<Employee> pageBean = new PageBean<Employee>();
		//封装当前的页数
		pageBean.setCurrPage(currPage);
		//封装每页记录数
		int pageSize = 6;
		pageBean.setPageSize(pageSize);
		//封装总记录数
		int totalCount = employeeDao.fintCount();
		pageBean.setTotalCount(totalCount);
		//封装总页数
		int totalPage = totalCount%pageSize == 0?totalCount/pageSize:(totalCount/pageSize+1);
		pageBean.setTotalPage(totalPage);
		//封装每页显示的数据
		int begin = (currPage - 1)*pageSize;
		List<Employee> list = employeeDao.findByPage(begin,pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	//添加员工
	public void save(Employee employee) {
		employeeDao.save(employee);
	}

	@Override
	//根据员工编号查询员工信息
	public Employee findById(Integer eid) {
		return employeeDao.finById(eid);
	}

	@Override
	//更新员工信息
	public void update(Employee employee) {
		employeeDao.update(employee);
	}

	@Override
	//根据员工id删除员工
	public void delete(Employee employee) {
		employeeDao.delete(employee);
	}
}
