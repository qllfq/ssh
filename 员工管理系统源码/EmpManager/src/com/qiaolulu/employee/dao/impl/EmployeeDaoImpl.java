package com.qiaolulu.employee.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.qiaolulu.employee.dao.EmployeeDao;
import com.qiaolulu.employee.domain.Employee;
/**
 * Ա�������DAO��ʵ����
 */
public class EmployeeDaoImpl extends HibernateDaoSupport implements EmployeeDao{

	@Override
	/**
	 * DAO�и����û����������ѯ�û��ķ���
	 */
	public Employee findByUsernameAndPassword(Employee employee) {
		String hql = "from Employee where username=? and password=?";
		//��������ģ�����������ݿ�Ĳ���
		List<Employee> list = (List<Employee>) this.getHibernateTemplate().find(hql,employee.getUsername(),employee.getPassword());
		//��list���Ͻ����ж�
		if(list.size() > 0){
			return list.get(0);
		}
		return null;
	}

	@Override
	//��ȡԱ���ܼ�¼
	public int fintCount() {
		String hql = "select count(*) from Employee";
		List<Long> list = (List<Long>) this.getHibernateTemplate().find(hql);
		if(list.size() > 0){
			return list.get(0).intValue();
		}
		return 0;
	}

	@Override
	//��ȡԱ��������Ϣ
	public List<Employee> findByPage(int begin, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Employee.class);
		List<Employee> list = (List<Employee>) this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
		return list;
	}

	@Override
	//���Ա��
	public void save(Employee employee) {
		this.getHibernateTemplate().save(employee);
	}

	@Override
	//����Ա����Ų�ѯԱ����Ϣ
	public Employee finById(Integer eid) {
		return this.getHibernateTemplate().get(Employee.class,eid);
	}

	@Override
	//����Ա����Ϣ
	public void update(Employee employee) {
		this.getHibernateTemplate().update(employee);
	}

	@Override
	//����Ա��idɾ��Ա��
	public void delete(Employee employee) {
		this.getHibernateTemplate().delete(employee);
	}
}
