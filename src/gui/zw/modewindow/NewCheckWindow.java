package gui.zw.modewindow;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class NewCheckWindow  extends JDialog{
	
	JPanel jp_top,jp_center,jp_center_right_top,
	jp_center_left,jp_center_right,jp_center_left_top;
	JPanel jp_top1,jp_top2,jp_top3;
	
	JButton btn1,btn2,btn3,btn4;
	JTextField tf1,tf2,tf3,tf4;
	
	JTable table,table1;
	DefaultTableModel model,model1;
	Vector<Vector> rowData=new Vector<Vector>();	
	Vector columnNames=new Vector();
	
	Vector<Vector> rowData1=new Vector<Vector>();	
	Vector columnNames1=new Vector();
	public NewCheckWindow (){
		//��߱��
		columnNames.add("��Ʒ���");
		columnNames.add("��Ʒ����");
		columnNames.add("��λ");
		columnNames.add("�������");
		//columnNames.add("��Ʒ����");
		//columnNames.add("��Ʒ����");
		//columnNames.add("��ע");
		model=new DefaultTableModel(rowData, columnNames);
		table=new JTable(model);
		//�ұ߱��
		columnNames1.add("��Ʒ���");
		columnNames1.add("��Ʒ����");
		columnNames1.add("��λ");
		columnNames1.add("�������");
		columnNames1.add("�̵������");
		//columnNames1.add("��Ʒ����");
		//columnNames1.add("��ע");
		model1=new DefaultTableModel(rowData1, columnNames1);
		table1=new JTable(model1);
		
		jp_top=new JPanel();
		jp_center_left=new JPanel();
		jp_center_right=new JPanel();
		jp_center_right_top=new JPanel();
		jp_center_left_top=new JPanel();
		jp_center=new JPanel();
		jp_top1=new JPanel();
		jp_top2=new JPanel();
		jp_top3=new JPanel();
		
		btn1=new JButton("ȷ��");
		btn2=new JButton("�޸�");
		btn3=new JButton("ɾ��");
		btn4=new JButton("�˳�");
		
		tf1=new JTextField(8);
		tf2=new JTextField(8);
		tf3=new JTextField(50);
		tf4=new JTextField(8);
		
		//top��
		jp_top.setBorder(BorderFactory.createTitledBorder("�̵���Ϣ"));
		jp_top1.add(new JLabel("�̵㵥�ţ�"));
		jp_top1.add(tf1);
		jp_top1.add(new JLabel("ѡ���̵�ֿ⣺"));
		jp_top1.add(tf2);
		jp_top.add(jp_top1);		
		jp_top2.add(new JLabel("��ע"));
		jp_top2.add(tf3);
		jp_top.add(jp_top2);		
		jp_top3.add(new JLabel("��ʾ���̵�ʱ���ܸ����ֿ������"));
		jp_top.add(jp_top3);
				
		jp_center_left.setBorder(BorderFactory.createTitledBorder("�����Ʒ"));
		jp_center_right.setBorder(BorderFactory.createTitledBorder("������Ʒ"));
		
		jp_center_left_top.add(new JLabel("��Ʒ���"));
		jp_center_left_top.add(tf4);
		jp_center_left_top.add(btn1);
		
		jp_center_right_top.add(btn2);
		jp_center_right_top.add(btn3);
		jp_center_right_top.add(btn4);
		
						
		jp_top.setLayout(new GridLayout(3,1));
		jp_top.add(jp_top1);
		jp_top.add(jp_top2);
		jp_top.add(jp_top3);
		
		//��߱��
		jp_center.setLayout(new GridLayout(1,2));
		jp_center.add(jp_center_left);
		jp_center_left.setLayout(new BorderLayout());
		jp_center_left.add(jp_center_left_top,BorderLayout.NORTH);				
		jp_center_left.add(new JScrollPane(table),BorderLayout.CENTER);
		
		//�ұ߱��
		jp_center.add(jp_center_right);					
		jp_center_right.setLayout(new BorderLayout());	
		jp_center_right.add(jp_center_right_top,BorderLayout.NORTH);
		jp_center_right.add(new JScrollPane(table1),BorderLayout.CENTER);
		
		this.setLayout(new BorderLayout());	
		this.add(jp_top,BorderLayout.NORTH);
		this.add(jp_center,BorderLayout.CENTER);		
		this.setTitle("¼���̵���Ʒ");
		this.setBounds(100, 100, 1000, 600);
		//this.setLocationRelativeTo(null);
		this.setModal(true);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new NewCheckWindow();
	}

}
