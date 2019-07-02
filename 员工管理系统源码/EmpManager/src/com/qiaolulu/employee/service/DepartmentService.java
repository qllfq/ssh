package com.qiaolulu.employee.service;

import java.util.List;

import com.qiaolulu.employee.domain.Department;
import com.qiaolulu.employee.domain.PageBean;

/**
 * ���Ź����ҵ���ӿ���
 */
public interface DepartmentService {
	
	// ��ҳ��ѯ���ֵķ���
	PageBean<Department> findByPage(Integer currPage);
	// ���в��ŵ����
	void save(Department department);
	//�༭������Ϣ
	Department findById(Integer did);
	//��ҵ���ӿ��и��²�����Ϣ
	void update(Department department);
	//ɾ������
	void delete(Department department);
	//��ѯ���в�����Ϣ
	List<Department> findAll();

}
