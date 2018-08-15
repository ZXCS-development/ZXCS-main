package service;

import java.util.Vector;

import bean.Admin;
import bean.Customer;
import bean.Depot;
import bean.Employee;
import bean.Supplier;
import dao.AdminDao;
import dao.CustomDao;
import dao.DepotsDao;
import dao.EmployeesDao;
import dao.SuppliersDao;
import util.CastUtil;

/**
 * ϵͳ����
 * 	���ֻ�����Ϣ�޸�
 * 	ĳЩ�����������еĻ�ȡ��Ϣ�غ�
 * @author pcshao
 *
 */
public class SystemService {

	/**
	 * ��ȡ�ֿ�������Ϣ
	 * @return
	 */
	public Vector<Vector> getDepots() {
		return new CastUtil().objectToVector(new DepotsDao().getDepots(), new Depot());
	}
	/**
	 * ��ȡԱ��������Ϣ
	 * @return
	 */
	public Vector<Vector> getEmployees() {
		return new CastUtil().objectToVector(new EmployeesDao().getEmployees(), new Employee());
	}
	/**
	 * ��ȡ����Ա������Ϣ
	 * @return
	 */
	public Vector<Vector> getAdmins() {
		return new CastUtil().objectToVector(new AdminDao().getAdmins(), new Admin());
	}
	/**
	 * ��ȡ�ͻ�������Ϣ
	 * @return
	 */
	public Vector<Vector> getCustomers() {
		return new CastUtil().objectToVector(new CustomDao().getCustomers());
	}
	/**
	 * ��ȡ������������Ϣ
	 * @return
	 */
	public Vector<Vector> getSuppliers() {
		return new CastUtil().objectToVector(new SuppliersDao().getSuppliers(), new Supplier());
	}
	/**
	 * ����Ա��
	 */
	public Boolean addEmployee(Employee emp) {
		return new EmployeesDao().addEmployee(emp);
	}
	/**
	 * �����ͻ�
	 */
	public Boolean addCustomer(Customer cus) {
		return new CustomDao().addCustomer(cus);
	}
	/**
	 * ������Ӧ��
	 */
	public Boolean addSupplier(Supplier supplier) {
		return new SuppliersDao().addSupplier(supplier);
	}
	/**
	 * �༭Ա��
	 * @param old
	 * @param new
	 * @return
	 */
	public Boolean editEmployee(Employee empOld, Employee empNew) {
		return new EmployeesDao().editEmployee(empOld, empNew);
	}
	/**
	 * �༭�ͻ�
	 * @param old
	 * @param new
	 * @return
	 */
	public Boolean editCustomer(Customer cusOld, Customer cusNew) {
		return new CustomDao().editCustomer(cusOld, cusNew);
	}
	/**
	 * �༭��Ӧ��
	 * @param old
	 * @param new
	 * @return
	 */
	public Boolean editSupplier(Supplier supplierOld, Supplier supplierNew) {
		return new SuppliersDao().editSupplier(supplierOld, supplierNew);
	}
	/**
	 * ����Ա������content
	 */
	public Vector<Employee> searchEmployee(String content) {
		return new EmployeesDao().searchEmployee(content);
	}
	/**
	 * ���ҿͻ�����content
	 */
	public Vector<Customer> searchCustomer(String content) {
		return new CustomDao().searchCustomer(content);
	}
	/**
	 * ���ҹ�Ӧ�̸���content
	 */
	public Vector<Supplier> searchSupplier(String content) {
		return new SuppliersDao().searchSupplier(content);
	}
	/**
	 * ɾ��Ա�� ����ID
	 */
	public Boolean removeEmployee(int id) {
		return new EmployeesDao().removeEmployee(id);
	}
	/**
	 * ɾ���ͻ� ����ID
	 */
	public Boolean removeCustomer(int id) {
		return new CustomDao().removeCustomer(id);
	}
	/**
	 * ɾ����Ӧ�� ����ID
	 */
	public Boolean removeSupplier(int id) {
		return new SuppliersDao().removeSuppliers(id);
	}
}
