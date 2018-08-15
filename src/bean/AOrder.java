package bean;

/**
 * ��������
 * 	�������ֵ���
 * @author pcshao
 */
public abstract class AOrder {
	
	private String id;				//���ݺ�
	private String odate;			//��������
	private Depot depot;			//�ֿ�
	private double wantMoney;		//Ӧ�����
	private double payMoney;		//ʵ�����
	private Employee agent;			//������
	private Admin operator;			//����Ա
	private String bz;				//��ע
	private PayWay payWay;			//֧����ʽ
	
	/*
	 * ���ṩ�޲ι�����
	 */
	public AOrder() {
		
	}
	/*
	 * �ṩ��С��������
	 */
	public AOrder(String id, String odate, Admin operator) {
		this.id = id;
		this.odate = odate;
		this.operator = operator;
	}
	/*
	 * �ṩȫ��������������
	 */
	public AOrder(String id, String odate, Depot depot, double wantMoney, double payMoney, Employee agent,
			Admin operator, String bz, PayWay payWay) {
		this.id = id;
		this.odate = odate;
		this.depot = depot;
		this.wantMoney = wantMoney;
		this.payMoney = payMoney;
		this.agent = agent;
		this.operator = operator;
		this.bz = bz;
		this.payWay = payWay;
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
	public Depot getDepot() {
		return depot;
	}
	public void setDepot(Depot depot) {
		this.depot = depot;
	}
	public double getWantMoney() {
		return wantMoney;
	}
	public void setWantMoney(double wantMoney) {
		this.wantMoney = wantMoney;
	}
	public double getPayMoney() {
		return payMoney;
	}
	public void setPayMoney(double payMoney) {
		this.payMoney = payMoney;
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
	public PayWay getPayWay() {
		return payWay;
	}
	public void setPayWay(PayWay payWay) {
		this.payWay = payWay;
	}

}