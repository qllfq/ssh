package com.qiaolulu.employee.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.qiaolulu.employee.domain.Department;
import com.qiaolulu.employee.domain.Employee;
import com.qiaolulu.employee.domain.PageBean;
import com.qiaolulu.employee.service.DepartmentService;
import com.qiaolulu.employee.service.EmployeeService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * Ա�������Action��
 */
public class EmployeeAction extends ActionSupport implements ModelDriven<Employee>{
	
	//ģ��������Ҫʹ�õĶ���
	private Employee employee = new Employee();
	@Override
	public Employee getModel() {
		return employee;
	}
	//ע��ҵ����ࣺ
	private EmployeeService employeeService;
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	private DepartmentService departmentService;
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	
	/**
	 * ��¼ִ�еķ�����
	 * @return
	 */
	public String login(){
		System.out.println("loginִ���ˡ�������");

		//����ҵ������
		Employee existEmployee = employeeService.login(employee);
		if(existEmployee == null){
			
			this.addActionError("�û������������");
			return INPUT;
		}else{
			//��¼�ɹ�
			ActionContext.getContext().getSession().put("existEmployee", existEmployee);
			return SUCCESS;
		}
	}
	
	/**
	 * ��ҳ��ѯԱ����ִ�з���
	 */
	private Integer currPage = 1;
	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}
	public String findAll(){
		System.out.println("findAll");
		PageBean<Employee> pageBean = employeeService.findAll(currPage);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}
	
	/**
	 * ��ת�����Ա��ҳ��ִ�еķ���
	 */
	public String saveUI(){
		System.out.println("saveUI");
		List<Department> list = departmentService.findAll();//��ѯ���в�����Ϣ
		//����ѯ�õ��Ĳ�����Ϣ���ϴ���ֵջ�У�����ʹ��push����������ʹ��set����
		ActionContext.getContext().getValueStack().set("list", list);
		return "saveUI";
	}
	/**
	 * ���Ա����ִ�з���
	 */
	public String save(){
		System.out.println("save");
		employeeService.save(employee);
		return "saveSuccess";
	}
	/**
	 * �༭Ա����ִ�еķ���
	 */
	public String edit(){
		System.out.println("edit");
		//����Ա��ID��ѯԱ��
		employee = employeeService.findById(employee.getEid());
		//��ѯ���еĲ���
		List<Department> list = departmentService.findAll();
		ActionContext.getContext().getValueStack().set("list", list);
		return "editSuccess";
	}
	/**
	 * ����Ա����Ϣ��ִ�з���
	 */
	public String update(){
		System.out.println("update");
		employeeService.update(employee);
		return "updateSuccess";
	}
	/**
	 * ����Ա��idɾ��Ա��
	 */
	public String delete(){
		System.out.println("delete");
		employee = employeeService.findById(employee.getEid());
		employeeService.delete(employee);
		return "deleteSuccess";
	}
	
}
