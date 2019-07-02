package com.qiaolulu.employee.dao;

import java.util.List;

import com.qiaolulu.employee.domain.Employee;

/**
 * Ա�������DAO�Ľӿ�
 */
public interface EmployeeDao {

	Employee findByUsernameAndPassword(Employee employee);
	//ͳ��Ա������
	int fintCount();
	//��ȡԱ��������Ϣ
	List<Employee> findByPage(int begin, int pageSize);
	//���Ա��
	void save(Employee employee);
	//����Ա����Ų�ѯԱ����Ϣ
	Employee finById(Integer eid);
	//����Ա����Ϣ
	void update(Employee employee);
	//����Ա��idɾ��Ա��
	void delete(Employee employee);

}
