package bean;

/**
 * ֧����ʽ
 */
public class PayWay {

	private int pid;
	private String name;
	
	/*
	 * �ṩ�޲ι�����
	 */
	public PayWay(){
		
	}
	/*
	 * ��С������
	 */
	public PayWay(int pid) {
		this.pid = pid;
	}
	/*
	 * ȫ������
	 */
	public PayWay(int pid, String name) {
		this.pid = pid;
		this.name = name;
	}
	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return name;
	}
	
	
}
