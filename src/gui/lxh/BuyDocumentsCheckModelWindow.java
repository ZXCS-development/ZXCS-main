package gui.lxh;

import gui.lxh.OldGoodsADDModelWindow.MyMouse;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import dao.InOrderDao;

import bean.orders.InOrder;

import util.MyDateChooser;

//���۵��ݲ�ѯ
public class BuyDocumentsCheckModelWindow extends JDialog{
	/**
	 * ����inorder  dao
	 */
	InOrderDao in_order_dao=null;
	JPanel jp_top,jp_center;			//��Ϊ�������в�
	JPanel jp_top_p1,jp_top_p2;
	JPanel jp_tab_p1,jp_tab_p2,jp_tab_p3;
	JPanel jp_tab_p1_1,jp_tab_p1_2,jp_tab_p2_1,jp_tab_p2_2;	//�в������������
	JTabbedPane tabbed_center;
	JButton btn_top1,btn_top2,btn_top3,btn_top4,btn_top5,btn_top6,btn_top7 ,btn_top8;
	JTextField tf_name,tf_check,tf_order;
	Vector columnNames1,columnNames2,columnNames3,columnNames4,columnNames5;
	DefaultTableModel table1model,table2model,table3model,table4model,table5model;
	JTable table1,table2,table3,table4,table5;
	String[] arr1={"���ݺ�","��������","����������","�ֿ�����","Ӧ�����","ʵ�����","������","����Ա","֧����ʽ","��ע"};		
	String[] arr2={"��Ʒ���","��Ʒ����","��λ","����","����","�ܽ��","�������","����ͺ�","��ע"};
	String[] arr3={"��Ʒ���","��Ʒ����","����","��λ","����","�ܽ��","�������","����ͺ�","��ע"};
	String[] arr4={"����������","���ݺ�","��������","��Ʒ���","��Ʒ����","��λ","����ͺ�","����","����","�ܽ��","�ֿ�","������"};
	String[] arr5={"����������","���ݺ�","��������","��Ʒ���","��Ʒ����","��λ","����ͺ�","����","����","�ܽ��","�ֿ�","������"};
	
	MyDateChooser date1,date2;
	public BuyDocumentsCheckModelWindow(){
		/**
		 * ��ʼ��inoreder  dao
		 */
		in_order_dao=new InOrderDao();
		date1=MyDateChooser.getInstance("yyyy-MM-dd");
		date2=MyDateChooser.getInstance("yyyy-MM-dd");
		
		jp_top=new JPanel();
		jp_top_p1=new JPanel();
		jp_top_p2=new JPanel();
		btn_top1=new JButton("��ϸ����");
		btn_top2=new JButton("�鿴����");
		btn_top3=new JButton("�����˻�");
		btn_top4=new JButton(" ��    �� ");
		btn_top5=new JButton(" ��    ӡ ");
		btn_top6=new JButton(" ��    �� ");
		btn_top7=new JButton(" ��    ѯ ");
		btn_top8=new JButton(" ��    ѯ ");
		tf_name=new JTextField(10);
		tf_check=new JTextField(10);
		tf_order=new JTextField(15);
		/**
		 * ����
		 * @author lxh
		 */
		jp_top.setLayout(new GridLayout(2,1));
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
		tf_name.setText(date1.getStrDate());
		date1.register(tf_name);
		jp_top_p2.add(tf_name);
		jp_top_p2.add(new JLabel("��"));
		tf_check.setText(date2.getStrDate());
		date2.register(tf_check);
		jp_top_p2.add(tf_check);
		jp_top_p2.add(btn_top7);
		jp_top_p2.add(new JLabel("��������/���ݺŲ�ѯ��"));
		jp_top_p2.add(tf_order);
		jp_top_p2.add(btn_top8);
		jp_top.add(jp_top_p2);
		/**
		 * �в�
		 * @author lxh
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
		table1model=new DefaultTableModel(in_order_dao.getAllInorder(),columnNames1);
		table1=new JTable(table1model){														//���ñ�񲻿��Ա༭
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table2model=new DefaultTableModel(null,columnNames2);
		table2=new JTable(table2model){														//���ñ�񲻿��Ա༭
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table3model=new DefaultTableModel(in_order_dao.getAlwaysInorder(),columnNames3);
		table3=new JTable(table3model){														//���ñ�񲻿��Ա༭
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table4model=new DefaultTableModel(null,columnNames4);
		table4=new JTable(table4model){														//���ñ�񲻿��Ա༭
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table5model=new DefaultTableModel(in_order_dao.getGoodsInorderInfo(),columnNames5);
		table5=new JTable(table5model){														//���ñ�񲻿��Ա༭
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		jp_center.setLayout(new GridLayout(1,1));
		//����ѡ�
		tabbed_center.add("���ݱ�",jp_tab_p1);
		jp_tab_p1.setLayout(new GridLayout(2,1));
		jp_tab_p1.add(jp_tab_p1_1);
		jp_tab_p1_1.setLayout(new GridLayout(1,1));
		jp_tab_p1_1.add(new JScrollPane(table1));
		jp_tab_p1.add(jp_tab_p1_2);
		jp_tab_p1_2.setBorder(BorderFactory.createTitledBorder("���ݵ���ϸ��Ϣ��"));
		jp_tab_p1_2.setLayout(new GridLayout(1,1));
		jp_tab_p1_2.add(new JScrollPane(table2));
		//����ѡ�
		tabbed_center.add("���ܱ�",jp_tab_p2);
		jp_tab_p2.setLayout(new GridLayout(2,1));
		jp_tab_p2.add(jp_tab_p2_1);
		jp_tab_p2_1.setLayout(new GridLayout(1,1));
		jp_tab_p2_1.add(new JScrollPane(table3));
		jp_tab_p2.add(jp_tab_p2_2);
		jp_tab_p2_2.setBorder(BorderFactory.createTitledBorder("��Ʒ�ɹ���ϸ��"));
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
		this.setTitle("�ɹ����ݲ�ѯ");	
		this.setBounds(300, 100, 850, 550);
		
		/**
		 * table1 �ĵ���¼�
		 */
		table1.addMouseListener(new TableMouse(table1));
		table3.addMouseListener(new Table3Mouse(table3));
		
		/**
		 * ���ڲ�ѯ�¼�
		 */
		btn_top7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String date1=tf_name.getText()+"";
			String date2=tf_check.getText()+"";
				
			}
		});
		this.setModal(true);
		this.setVisible(true);
	}
	/***
	 * 
	 * ���1�ĵ���¼�
	 * ��ʹ���2�����仯
	 *
	 */
	
	public class TableMouse extends MouseAdapter{
		JTable table;
		public TableMouse(	JTable table){
			this.table=table;
		}
		public void mouseClicked(MouseEvent e) {
			if(e.getButton()==1&&isSelectTable1()!=null){
				table2model=new DefaultTableModel(in_order_dao.getAlwaysInorder(isSelectTable1().get(0)+""),columnNames2);
				table2.setModel(table2model);
				table2.updateUI();
			}
		}
	}
	/***
	 * 
	 * ���3�ĵ���¼�
	 * ��ʹ���4�����仯
	 *
	 */
	
	public class Table3Mouse extends MouseAdapter{
		JTable table;
		public Table3Mouse(	JTable table){
			this.table=table;
		}
		public void mouseClicked(MouseEvent e) {
			if(e.getButton()==1&&isSelectTable3()!=null){
				jp_tab_p2_2.setBorder(BorderFactory.createTitledBorder("��Ʒ�ɹ���ϸ��"+isSelectTable3().get(1)));
				int gid=Integer.parseInt(isSelectTable3().get(0)+"");
				String oid=isSelectTable3().get(9)+"";
				table4model=new DefaultTableModel(in_order_dao.getGoodsInorderInfo(gid,oid),columnNames4);
				table4.setModel(table4model);
				table4.updateUI();
			}
		}
	}
	/**
	 * 
	 * ���ر��1ѡ�е���
	 */
	public Vector isSelectTable1(){
		Vector vector=null;
		if(table1.isShowing()){
			try{
				 vector=(Vector)in_order_dao.getAllInorder().get(table1.getSelectedRow());		 
			}catch (Exception e2) {
				
			}
		}
		return vector;
	}
	/**
	 * 
	 * ���ر��3ѡ�е���
	 */
	public Vector isSelectTable3(){
		Vector vector=null;
		if(table3.isShowing()){
			try{
				 vector=(Vector)in_order_dao.getAlwaysInorder().get(table3.getSelectedRow());		 
			}catch (Exception e2) {
				
			}
		}
		return vector;
	}
	/**
	 * ���±�ĺ���
	 * @param args
	 */
	public void UpdateTable (JTable table,DefaultTableModel model){
		table.setModel(model);
		table.updateUI();
	}
	/**
	 * ��д�ı��仯�¼�
	 * @param args
	 */
	public static void main(String[] args) {
		new BuyDocumentsCheckModelWindow();
	}
	
}
