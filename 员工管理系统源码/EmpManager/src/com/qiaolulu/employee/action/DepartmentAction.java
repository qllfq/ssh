package com.qiaolulu.employee.action;

import com.qiaolulu.employee.domain.Department;
import com.qiaolulu.employee.domain.PageBean;
import com.qiaolulu.employee.service.DepartmentService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
/**
 * ���Ź����Action����
 * ��������Ҫ���з�ҳ
 */
public class DepartmentAction extends ActionSupport implements ModelDriven<Department>{

	//ģ������
	private Department department = new Department();
	@Override
	public Department getModel() {
		return department;
	}
	//ע��ҵ���
	private DepartmentService departmentService;
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	
	private Integer currPage = 1;//��ǰҳ��Ĭ��Ϊ1��Ϊ��ҳ
	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;//�ṩһ��set��������ע��
	}

	/**
	 * �ṩһ����ѯ�ķ���-->���з�ҳ
	 */
	public String findAll(){
		System.out.println("findAll");
		PageBean<Department> pageBean = departmentService.findByPage(currPage);
		//��pageBean���뵽ֵջ��
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}
	
	/**
	 * ��ת����Ӳ��ŵ�ҳ��ķ���
	 */
	public String saveUI(){
		System.out.println("saveUI");
		return "saveUI";
	}
	/**
	 * ������Ӳ��ŵ����ݷ���
	 */
	public String save(){
		System.out.println("save");
		departmentService.save(department);
		return "saveSuccess";
	}
	/**
	 * �༭���ŵ�ִ�з���
	 */
	public String edit(){
		System.out.println("edit");
		//���ݲ���id��ѯ������Ϣ
		department = departmentService.findById(department.getDid());
		return "editSuccess";
	}
	/**
	 * �޸Ĳ��ŵ�ִ�з���
	 */
	public String update(){
		System.out.println("update");
		departmentService.update(department);
		return "updateSuccess";
	}
	/**
	 * ɾ�����ŵ�ִ�з���
	 */
	public String delete(){
		System.out.println("delete");
		department = departmentService.findById(department.getDid());
		departmentService.delete(department);//���ֲ�������ʵ�ּ���ɾ��
		return "deleteSuccess";
	}
	
}
