package com.qiaolulu.employee.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.qiaolulu.employee.dao.DepartmentDao;
import com.qiaolulu.employee.domain.Department;
import com.qiaolulu.employee.domain.PageBean;
import com.qiaolulu.employee.service.DepartmentService;
/**
 * ���Ź����ҵ���ʵ����
 */
@Transactional
public class DepartmentServiceImpl implements DepartmentService{
	//ע�벿�Ź����DAO
	private DepartmentDao departmentDao;
	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}
	
	@Override
	/**
	 * ��ҳ��ѯ���ֵķ���
	 * @param currPage ��ǰҳ
	 * @return
	 */
	public PageBean<Department> findByPage(Integer currPage) {
		PageBean<Department> pageBean = new PageBean<Department>();
		//��װ��ǰҳ��
		pageBean.setCurrPage(currPage);
		//��װÿҳ��ʾ��¼��
		int pageSize = 6;
		pageBean.setPageSize(pageSize);
		//��װ�ܼ�¼��
		int totalCount = departmentDao.findCount();
		pageBean.setTotalCount(totalCount);
		//��װ��ҳ��
		
		int totalPage = totalCount%pageSize == 0?
				totalCount/pageSize:(totalCount/pageSize+1);
		pageBean.setTotalPage(totalPage);
		//��װÿҳ��ʾ������
		int begin = (currPage - 1)*pageSize;
		List<Department> list = departmentDao.findByPage(begin,pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	/**
	 * ҵ��㲿�ŵ����
	 */
	public void save(Department department) {
		departmentDao.save(department);
	}

	@Override
	/**
	 * ��ҵ����и��ݲ���id��ѯ������Ϣ
	 */
	public Department findById(Integer did ) {
		return departmentDao.findById(did);
	}

	@Override
	/**
	 * ��ҵ����и��²�����Ϣ
	 */
	public void update(Department department) {
		departmentDao.upate(department);
	}

	@Override
	/**
	 * ��ҵ���ɾ������
	 */
	public void delete(Department department) {
		departmentDao.delete(department);
	}

	@Override
	/**
	 * ��ѯ���в�����Ϣ
	 */
	public List<Department> findAll() {
		
		return departmentDao.findAll();
	}
	
}
