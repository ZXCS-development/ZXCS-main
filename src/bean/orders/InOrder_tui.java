package bean.orders;

import bean.AOrder;
import bean.Admin;
import bean.Depot;
import bean.Employee;
import bean.PayWay;
import bean.Supplier;

/**
 * �����˻�������	JT
 * 	�����ֶ�		������
 */
public class InOrder_tui extends AOrder {
	
	public final static String ORDERNAME = "CT";
	
	private Supplier supplier;

	/*
	 * �ṩ�޲ι�����
	 */
	public InOrder_tui(){
		super();
	}
	/*
	 * ��С������
	 */
	public InOrder_tui(String id, String odate, Admin operator) {
		super(id, odate, operator);
	}
	/*
	 * ȫ������
	 */
	public InOrder_tui(String id, String odate, Depot depot, double wantMoney, double payMoney, Employee agent,
			Admin operator, String bz, PayWay payWay, Supplier supplier ) {
		super(id, odate, depot, wantMoney, payMoney, agent, operator, bz, payWay);
		this.supplier = supplier;
	}

	public Supplier getSupplier() {
		return supplier;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
}
