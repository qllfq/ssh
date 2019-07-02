package com.qiaolulu.employee.service;

import com.qiaolulu.employee.domain.Employee;
import com.qiaolulu.employee.domain.PageBean;

/**
 * Ա�������ҵ���Ľӿ�
 */
public interface EmployeeService {

	Employee login(Employee employee);
	//��ҳ��ѯ
	PageBean<Employee> findAll(Integer currPage);
	//���Ա��
	void save(Employee employee);
	//����Ա����Ų�ѯԱ����Ϣ
	Employee findById(Integer eid);
	//����Ա����Ϣ
	void update(Employee employee);
	//����Ա��idɾ��Ա��
	void delete(Employee employee);
	
}
