package gui.yc;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import dao.OrderDao;
import dao.SellOrdersDao;

import util.MyDateChooser;
//���۵��ݲ�ѯ
public class SalesDocumentsCheckModelWindow extends JDialog{
	MyDateChooser dc1,dc2;
	JPanel jp_top,jp_center;			//��Ϊ�������в�
	JPanel jp_top_p1,jp_top_p2;
	JPanel jp_tab_p1,jp_tab_p2,jp_tab_p3;
	JPanel jp_tab_p1_1,jp_tab_p1_2,jp_tab_p2_1,jp_tab_p2_2;	//�в������������
	JTabbedPane tabbed_center;
	JButton btn_top1,btn_top2,btn_top3,btn_top4,btn_top5,btn_top6,btn_top7;
	JTextField tf_name,tf_check,tf_order;
	Vector<Vector> date1,date2,date3,date4,date5;
	Vector columnNames1,columnNames2,columnNames3,columnNames4,columnNames5;
	DefaultTableModel table1model,table2model,table3model,table4model,table5model;
	JTable table1,table2,table3,table4,table5;
	String[] arr1={"����","��������","�ͻ�����","�ֿ�����","Ӧ�ս��","ʵ�ս��","Ƿ����","������","����Ա"};		
	String[] arr2={"��Ʒ���","��Ʒ����","��λ","����","����","�ܽ��","����ͺ�","��ɫ"};
	String[] arr3={"��Ʒ���","��Ʒ����","��λ","��������","�����ܽ��","�������","����ͺ�","��ɫ","��������","��ע"};
	String[] arr4={"�ͻ�����","���ݺ�","��������","��λ","����","����","�ܽ��","����ͺ�","��ɫ"};
	String[] arr5={"��������","���ݺ�","��Ʒ���","��Ʒ����","����","����","�ܽ��","����","������","��λ","����ͺ�","�ֿ�","������","�ͻ�����","��������","ԭʼ����"};
	
	
	public SalesDocumentsCheckModelWindow(){
		dc1=MyDateChooser.getInstance("yyyy-MM-dd");
		dc2=MyDateChooser.getInstance("yyyy-MM-dd");
		jp_top=new JPanel();
		jp_top_p1=new JPanel();
		jp_top_p2=new JPanel();
		btn_top1=new JButton("��ϸ����");
		btn_top2=new JButton("�鿴����");
		btn_top3=new JButton("�����˻�");
		btn_top4=new JButton("����");
		btn_top5=new JButton("��ӡ");
		btn_top6=new JButton("�˳�");
		btn_top7=new JButton("��ѯ");
		tf_name=new JTextField(10);
		tf_check=new JTextField(10);
		tf_order=new JTextField(10);
		/**
		 * ����
		 * @author yc
		 */
		jp_top.setLayout(new GridLayout(2,1));
		jp_top_p1.setLayout(new GridLayout(1,8));
		jp_top_p1.setBorder(BorderFactory.createTitledBorder(""));
		jp_top_p1.add(btn_top1);
		jp_top_p1.add(btn_top2);
		jp_top_p1.add(btn_top3);
		jp_top_p1.add(btn_top4);
		jp_top_p1.add(btn_top5);
		jp_top_p1.add(btn_top6);
		jp_top_p1.add(new JLabel());
		jp_top_p1.add(new JLabel());
		jp_top.add(jp_top_p1);
		jp_top_p2.add(new JLabel("��ѯ���ڣ�"));
		tf_name.setText(dc1.getStrDate());
		dc1.register(tf_name);
		jp_top_p2.add(tf_name);
		jp_top_p2.add(new JLabel("��"));
		tf_check.setText(dc2.getStrDate());
		dc2.register(tf_check);
		jp_top_p2.add(tf_check);
		jp_top_p2.add(new JLabel("���ͻ�/���ݺŲ�ѯ��"));
		jp_top_p2.add(tf_order);
		jp_top_p2.add(btn_top7);
		jp_top.add(jp_top_p2);
		/**
		 * �в�
		 * @author yc
		 */
		jp_center=new JPanel();
		tabbed_center=new JTabbedPane();
		jp_tab_p1=new JPanel();
		jp_tab_p2=new JPanel();
		jp_tab_p3=new JPanel();
		jp_tab_p1_1=new JPanel();
		jp_tab_p1_2=new JPanel();
		jp_tab_p2_1=new JPanel();
		jp_tab_p2_2=new JPanel();
		columnNames1=new Vector();
		columnNames2=new Vector();
		columnNames3=new Vector();
		columnNames4=new Vector();
		columnNames5=new Vector();
		for (String str:arr1) {
			columnNames1.add(str);
		}
		for (String str:arr2) {
			columnNames2.add(str);
		}
		for (String str:arr3) {
			columnNames3.add(str);
		}
		for (String str:arr4) {
			columnNames4.add(str);
		}
		for (String str:arr5) {
			columnNames5.add(str);
		}
		date1=new SellOrdersDao().getSellOrdersInfo(tf_name.getText(),tf_check.getText());
		table1model=new DefaultTableModel(date1,columnNames1);
		/**
		 * �ѱ������Ϊ���ɱ༭��
		 * ��дisCellEditable����
		 * @author yc
		 */
		table1=new JTable(table1model)
		{
			public boolean isCellEditable(int row,int clumn){
				return false;
			}
		};
		table2model=new DefaultTableModel(date2,columnNames2);
		table2=new JTable(table2model);
		table3model=new DefaultTableModel(date3,columnNames3);
		table3=new JTable(table3model);
		table4model=new DefaultTableModel(date4,columnNames4);
		table4=new JTable(table4model);
		table5model=new DefaultTableModel(date5,columnNames5);
		table5=new JTable(table5model);
		jp_center.setLayout(new GridLayout(1,1));
		//����ѡ�
		tabbed_center.add("���ݱ�",jp_tab_p1);
		jp_tab_p1.setLayout(new GridLayout(2,1));
		jp_tab_p1.add(jp_tab_p1_1);
		jp_tab_p1_1.setLayout(new GridLayout(1,1));
		jp_tab_p1_1.add(new JScrollPane(table1));
		jp_tab_p1.add(jp_tab_p1_2);
		jp_tab_p1_2.setLayout(new GridLayout(1,1));
		jp_tab_p1_2.add(new JScrollPane(table2));
		//����ѡ�
		tabbed_center.add("���ܱ�",jp_tab_p2);
		jp_tab_p2.setLayout(new GridLayout(2,1));
		jp_tab_p2.add(jp_tab_p2_1);
		jp_tab_p2_1.setLayout(new GridLayout(1,1));
		jp_tab_p2_1.add(new JScrollPane(table3));
		jp_tab_p2.add(jp_tab_p2_2);
		jp_tab_p2_2.setLayout(new GridLayout(1,1));
		jp_tab_p2_2.add(new JScrollPane(table4));
		//��ϸѡ�
		tabbed_center.add("��ϸ��",jp_tab_p3);
		jp_tab_p3.setLayout(new GridLayout(1,1));
		jp_tab_p3.add(new JScrollPane(table5));
		jp_center.add(tabbed_center);
		this.setLayout(new BorderLayout());
		this.add(jp_top,BorderLayout.NORTH);
		this.add(jp_center,BorderLayout.CENTER);
		/**
		 * ��������
		 * @author yc
		 */
		//�˳�
		btn_top6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				SalesDocumentsCheckModelWindow.this.setVisible(false);
			}
		});
		this.setTitle("���۵��ݲ�ѯ");
		this.setLocationRelativeTo(null);
		this.setBounds(300, 100, 880, 580);
		this.setModal(true);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new SalesDocumentsCheckModelWindow();
	}
	
}
