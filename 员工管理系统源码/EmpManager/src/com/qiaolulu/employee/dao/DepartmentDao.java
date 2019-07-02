package com.qiaolulu.employee.dao;

import java.util.List;

import com.qiaolulu.employee.domain.Department;

/**
 * ���Ź����DAO��ӿ���
 */
public interface DepartmentDao {
	//��ѯ�ܼ�¼��
	int findCount();
	//��ѯ����Ա���ܼ���
	List<Department> findByPage(int begin, int pageSize);
	//��Ӳ���
	void save(Department department);
	//�༭����
	Department findById(Integer did);
	//���²���
	void upate(Department department);
	//ɾ������
	void delete(Department department);
	//��ѯ���в�����Ϣ
	List<Department> findAll();

}
