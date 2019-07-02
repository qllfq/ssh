package com.qiaolulu.employee.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.qiaolulu.employee.dao.EmployeeDao;
import com.qiaolulu.employee.domain.Employee;
import com.qiaolulu.employee.domain.PageBean;
import com.qiaolulu.employee.service.EmployeeService;
/**
 * Ա�������ҵ���ʵ����
 */
@Transactional
public class EmployeeServiceImpl implements EmployeeService{
	private EmployeeDao employeeDao;
	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	
	@Override
	/**
	 * ҵ���ĵ�¼�ķ���
	 */
	public Employee login(Employee employee) {
		Employee existEmployee = employeeDao.findByUsernameAndPassword(employee);
		return existEmployee;
	}

	@Override
	//��ҳ��ѯ
	public PageBean<Employee> findAll(Integer currPage) {
		PageBean<Employee> pageBean = new PageBean<Employee>();
		//��װ��ǰ��ҳ��
		pageBean.setCurrPage(currPage);
		//��װÿҳ��¼��
		int pageSize = 6;
		pageBean.setPageSize(pageSize);
		//��װ�ܼ�¼��
		int totalCount = employeeDao.fintCount();
		pageBean.setTotalCount(totalCount);
		//��װ��ҳ��
		int totalPage = totalCount%pageSize == 0?totalCount/pageSize:(totalCount/pageSize+1);
		pageBean.setTotalPage(totalPage);
		//��װÿҳ��ʾ������
		int begin = (currPage - 1)*pageSize;
		List<Employee> list = employeeDao.findByPage(begin,pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	//���Ա��
	public void save(Employee employee) {
		employeeDao.save(employee);
	}

	@Override
	//����Ա����Ų�ѯԱ����Ϣ
	public Employee findById(Integer eid) {
		return employeeDao.finById(eid);
	}

	@Override
	//����Ա����Ϣ
	public void update(Employee employee) {
		employeeDao.update(employee);
	}

	@Override
	//����Ա��idɾ��Ա��
	public void delete(Employee employee) {
		employeeDao.delete(employee);
	}
}
