package bean.orders;

import bean.Admin;
import bean.Depot;
import bean.Employee;
import bean.PayWay;

public class DbOrder{
	
	public static final String ORDERNAME="DB";

	private String id;				//���ݺ�
	private String odate;			//��������
	private Depot fromDepot;		//�����ֿ�
	private Depot toDepot;			//����ֿ�
	private Employee agent;			//������
	private Admin operator;			//����Ա
	private String bz;				//��ע
	
	public DbOrder() {
	}
	
	public DbOrder(String id, String odate, Depot fromDepot, Depot toDepot, Employee agent, Admin operator, String bz) {
		this.id = id;
		this.odate = odate;
		this.fromDepot = fromDepot;
		this.toDepot = toDepot;
		this.agent = agent;
		this.operator = operator;
		this.bz = bz;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOdate() {
		return odate;
	}
	public void setOdate(String odate) {
		this.odate = odate;
	}
	public Depot getFromDepot() {
		return fromDepot;
	}
	public void setFromDepot(Depot fromDepot) {
		this.fromDepot = fromDepot;
	}
	public Depot getToDepot() {
		return toDepot;
	}
	public void setToDepot(Depot toDepot) {
		this.toDepot = toDepot;
	}
	public Employee getAgent() {
		return agent;
	}
	public void setAgent(Employee agent) {
		this.agent = agent;
	}
	public Admin getOperator() {
		return operator;
	}
	public void setOperator(Admin operator) {
		this.operator = operator;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	
}
