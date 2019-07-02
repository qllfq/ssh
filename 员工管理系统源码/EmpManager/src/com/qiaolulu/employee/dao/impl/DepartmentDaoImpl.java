package com.qiaolulu.employee.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.qiaolulu.employee.dao.DepartmentDao;
import com.qiaolulu.employee.domain.Department;
/**
 * ���Ź����DAO��ʵ����
 */
public class DepartmentDaoImpl extends HibernateDaoSupport implements DepartmentDao{

	@Override
	public int findCount() {
		String hql = "select count(*) from Department";
		SessionFactory sessionFactory = this.getSessionFactory();
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(hql);
		System.out.println(query);
		List<Long> list = query.list();
		if(list.size() > 0){
			return list.get(0).intValue();
		}
		return 0;
	}

	@Override
	/**
	 * ��ҳ��ѯ����
	 */
	public List<Department> findByPage(int begin, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Department.class);
		List<Department> list = (List<Department>) this.getHibernateTemplate().findByCriteria(criteria,begin,pageSize);
		return list; 
	}

	@Override
	/**
	 * ��DAO���н�����Ӳ���
	 */
	public void save(Department department) {
		this.getHibernateTemplate().save(department);
	}

	@Override
	/**
	 * ��DAO�����ID���в�ѯ���ŵķ���
	 */
	public Department findById(Integer did) {
		return this.getHibernateTemplate().get(Department.class, did);
	}

	@Override
	/**
	 * ��DAO����²�����Ϣ
	 */
	public void upate(Department department) {
		this.getHibernateTemplate().update(department);
	}

	@Override

	/**
	 * ��DAO��ɾ������
	 */
	public void delete(Department department) {
		this.getHibernateTemplate().delete(department);
	}

	@Override
	/**
	 * ��DAO���ѯ���в�����Ϣ
	 */
	public List<Department> findAll() {
		return (List<Department>) this.getHibernateTemplate().find("from Department");
	}
	
}
