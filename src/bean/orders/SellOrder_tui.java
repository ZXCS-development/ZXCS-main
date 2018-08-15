package bean.orders;

import bean.AOrder;
import bean.Admin;
import bean.Customer;
import bean.Depot;
import bean.Employee;
import bean.PayWay;

/**
 * �����˻�������	XT
 * 	�����ֶ�		�ͻ�
 */
public class SellOrder_tui extends AOrder {

	public final static String ORDERNAME = "XT";

	private Customer customer;

	/*
	 * �ṩ�޲ι�����
	 */
	public SellOrder_tui() {
		super();
	}
	/*
	 * �ṩ��С������
	 */
	public SellOrder_tui(String id, String odate, Admin operator) {
		super(id, odate, operator);
	}
	/*
	 * ȫ������
	 */
	public SellOrder_tui(String id, String odate, Depot depot, double wantMoney, double payMoney, Employee agent,
			Admin operator, String bz, PayWay payWay, Customer customer) {
		super(id, odate, depot, wantMoney, payMoney, agent, operator, bz, payWay);
		this.customer = customer;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
}
