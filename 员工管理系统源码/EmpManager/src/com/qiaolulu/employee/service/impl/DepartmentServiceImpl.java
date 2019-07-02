package com.qiaolulu.employee.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.qiaolulu.employee.dao.DepartmentDao;
import com.qiaolulu.employee.domain.Department;
import com.qiaolulu.employee.domain.PageBean;
import com.qiaolulu.employee.service.DepartmentService;
/**
 * 部门管理的业务层实现类
 */
@Transactional
public class DepartmentServiceImpl implements DepartmentService{
	//注入部门管理的DAO
	private DepartmentDao departmentDao;
	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}
	
	@Override
	/**
	 * 分页查询部分的方法
	 * @param currPage 当前页
	 * @return
	 */
	public PageBean<Department> findByPage(Integer currPage) {
		PageBean<Department> pageBean = new PageBean<Department>();
		//封装当前页数
		pageBean.setCurrPage(currPage);
		//封装每页显示记录数
		int pageSize = 6;
		pageBean.setPageSize(pageSize);
		//封装总记录数
		int totalCount = departmentDao.findCount();
		pageBean.setTotalCount(totalCount);
		//封装总页数
		
		int totalPage = totalCount%pageSize == 0?
				totalCount/pageSize:(totalCount/pageSize+1);
		pageBean.setTotalPage(totalPage);
		//封装每页显示的数据
		int begin = (currPage - 1)*pageSize;
		List<Department> list = departmentDao.findByPage(begin,pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	/**
	 * 业务层部门的添加
	 */
	public void save(Department department) {
		departmentDao.save(department);
	}

	@Override
	/**
	 * 在业务层中根据部门id查询部门信息
	 */
	public Department findById(Integer did ) {
		return departmentDao.findById(did);
	}

	@Override
	/**
	 * 在业务层中更新部门信息
	 */
	public void update(Department department) {
		departmentDao.upate(department);
	}

	@Override
	/**
	 * 在业务层删除部门
	 */
	public void delete(Department department) {
		departmentDao.delete(department);
	}

	@Override
	/**
	 * 查询所有部门信息
	 */
	public List<Department> findAll() {
		
		return departmentDao.findAll();
	}
	
}
