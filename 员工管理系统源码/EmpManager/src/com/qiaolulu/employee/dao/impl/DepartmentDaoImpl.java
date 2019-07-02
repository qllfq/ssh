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
 * 部门管理的DAO层实现类
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
	 * 分页查询部门
	 */
	public List<Department> findByPage(int begin, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Department.class);
		List<Department> list = (List<Department>) this.getHibernateTemplate().findByCriteria(criteria,begin,pageSize);
		return list; 
	}

	@Override
	/**
	 * 在DAO层中进行添加部门
	 */
	public void save(Department department) {
		this.getHibernateTemplate().save(department);
	}

	@Override
	/**
	 * 在DAO层根据ID进行查询部门的方法
	 */
	public Department findById(Integer did) {
		return this.getHibernateTemplate().get(Department.class, did);
	}

	@Override
	/**
	 * 在DAO层更新部门信息
	 */
	public void upate(Department department) {
		this.getHibernateTemplate().update(department);
	}

	@Override

	/**
	 * 在DAO层删除部门
	 */
	public void delete(Department department) {
		this.getHibernateTemplate().delete(department);
	}

	@Override
	/**
	 * 在DAO层查询所有部门信息
	 */
	public List<Department> findAll() {
		return (List<Department>) this.getHibernateTemplate().find("from Department");
	}
	
}
