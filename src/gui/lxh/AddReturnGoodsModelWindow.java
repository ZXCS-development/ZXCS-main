package gui.lxh;

import gui.lxh.OldGoodsADDModelWindow.MyMouse;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;

import bean.GoodsType;

import util.TypeWindow;

import dao.GetAllGoodsDao;

//�����Ʒ
public class AddReturnGoodsModelWindow extends JDialog{
	BuyReturnGoodsModelWindow brg=null;							//����һ�������ڶ���
	GetAllGoodsDao get_goods_dao=null;							//������Ʒdao
	JPanel jp_left,jp_right;									//���������������
	JPanel jp_left_top,jp_left_center;
	JPanel jp_left_top_p1,jp_left_top_p2;
	JPanel jp_right_center,jp_right_bottom;
	JTextField tf_seekgoods;
	JButton btn_addgood;
	JTabbedPane tabbed;
	JPanel jp_tabbed1,jp_tabbed2,jp_tabbed2_center,jp_tabbed2_left;
	JTable table1,table2,table3;
	DefaultTableModel table1model,table2model,table3model;
	Vector columnNames1,columnNames2,columnNames3;
	String[] arr1={"��Ʒ���","��Ʒ����","��λ","���","�ο�����","�����"};
	String[] arr2={"��Ʒ���","��Ʒ����","��λ","���","�ο�����","�����"};
	String[] arr3={"��Ʒ���","��Ʒ����","��λ","���","����","����","�ܽ��"};
	JButton btn_alter,btn_del,btn_ok,btn_exit;
	
	/**
	 * 
	 * ����װtable1��table2����ά����
	 */
	Vector vector_boss=null;
	/**
	 * �������һ�����
	 */
	TypeWindow p_tree_type=null; 									//��������һ����
	public AddReturnGoodsModelWindow(BuyReturnGoodsModelWindow brg){
		this.brg=brg;
		p_tree_type=new TypeWindow();								//��ʼ������һ����
		get_goods_dao=new GetAllGoodsDao();							//��ʼ����Ʒdao
		jp_left=new JPanel();
		jp_right=new JPanel();
		
		jp_left.setBorder(BorderFactory.createTitledBorder("��ѯ��Ʒ�б�"));
		jp_right.setBorder(BorderFactory.createTitledBorder("��ѡ��Ʒ"));
		
/*--------------------------------------������--------------------------------------------------*/		
		jp_left_top=new JPanel();			//��߶���
		jp_left_top_p1=new JPanel();
		jp_left_top_p2=new JPanel();
		tf_seekgoods=new JTextField(12);
		btn_addgood=new JButton("������ѡ��Ʒ");
		jp_left.setLayout(new BorderLayout());
		jp_left_top.setLayout(new GridLayout(2,1));
		jp_left_top_p1.add(new JLabel("��������Ʒ��Ż����Ʋ�ѯ��Ʒ,��ѯ����Ʒ����ӵ��ұ���ѡ��Ʒ"));
		jp_left_top_p2.add(new JLabel("������Ʒ��Ż����Ʋ�ѯ��Ʒ��"));
		jp_left_top_p2.add(tf_seekgoods);
		jp_left_top_p2.add(btn_addgood);
		jp_left_top_p2.setBorder(BorderFactory.createTitledBorder(""));
		jp_left_top.add(jp_left_top_p1);
		jp_left_top.add(jp_left_top_p2);
		jp_left.add(jp_left_top,BorderLayout.NORTH);
		
		jp_left_center=new JPanel();		//����м�
		tabbed=new JTabbedPane();
		jp_tabbed1=new JPanel();
		jp_tabbed2=new JPanel();
		jp_tabbed2_center=new JPanel();
		jp_tabbed2_left=new JPanel();
		/**
		 * ��ʼ��װ����ά����
		 */
		vector_boss=new Vector();												//װ����ά����������
		columnNames1=new Vector();
		for(String str:arr1){
			columnNames1.add(str);
		}
		table1model=new DefaultTableModel(get_goods_dao.getAllGoods1(""),columnNames1);
		/**
		 * ���ñ�񲻿ɱ༭
		 */
		table1=new JTable(table1model){
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		columnNames2=new Vector();
		for(String str:arr2){
			columnNames2.add(str);
		}
		table2model=new DefaultTableModel(get_goods_dao.getAllGoods1(""),columnNames2);
		
		/**
		 * ���ñ�񲻿ɱ༭
		 */
		table2=new JTable(table2model){
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		tabbed.add("��Ʒ�嵥",jp_tabbed1);
		tabbed.add("��Ʒ�б�",jp_tabbed2);
		jp_tabbed1.add(new JScrollPane(table1));
		jp_tabbed2.setLayout(new BorderLayout());
		jp_tabbed2_center.setLayout(new GridLayout(1,1));
		jp_tabbed2_center.add(new JScrollPane(table2));
		jp_tabbed2_left.setLayout(new GridLayout(1,1));									//��������һ����
		jp_tabbed2_left.add(new JScrollPane(p_tree_type));
		jp_tabbed2.add(jp_tabbed2_left,BorderLayout.WEST);
		jp_tabbed2.add(jp_tabbed2_center,BorderLayout.CENTER);
		jp_left_center.setLayout(new GridLayout(1,1));
		jp_left_center.add(tabbed);
		jp_left.add(jp_left_center,BorderLayout.CENTER);
		
/*--------------------------------------�ұ����--------------------------------------------------*/		
		jp_right_center=new JPanel();
		columnNames3=new Vector();
		/**
		 * ���ñ�񲻿ɱ༭
		 */
		for(String str:arr3){
			columnNames3.add(str);
		}
		table3model=new DefaultTableModel(null,columnNames3);
		table3=new JTable(table3model){
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		jp_right_bottom=new JPanel();
		btn_alter=new JButton(" ��   �� ");
		btn_del=new JButton(" ɾ    �� ");
		btn_ok=new JButton(" ȷ    �� ");
		btn_exit=new JButton(" ȡ    �� ");
		jp_right_center.setLayout(new GridLayout(1,1));
		jp_right_center.add(new JScrollPane(table3));
		jp_right.setLayout(new BorderLayout());
		jp_right.add(jp_right_center,BorderLayout.CENTER);
		jp_right_bottom.setBorder(BorderFactory.createTitledBorder(""));
		jp_right_bottom.add(btn_alter);
		jp_right_bottom.add(btn_del);
		jp_right_bottom.add(btn_ok);
		jp_right_bottom.add(btn_exit);
		jp_right_bottom.add(new JLabel());
		jp_right_bottom.add(new JLabel());
		jp_right_bottom.add(new JLabel());
		jp_right_bottom.add(new JLabel());
		jp_right.add(jp_right_bottom,BorderLayout.SOUTH);
		
		
		this.setTitle("������Ʒ(��Ʒ�˻�)");
		this.setLayout(new GridLayout(1,2));
		this.add(jp_left);
		this.add(jp_right);
		this.setBounds(200,50,1000, 650);
		/**
		 * �޸��¼�
		 * @author lxh
		 *
		 */
		btn_alter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Vector vector=(Vector) vector_boss.get(table3.getSelectedRow());
					int num=Integer.parseInt(JOptionPane.showInputDialog("������Ҫ�޸ĵ�������"));
					vector.set(5, num);
					table3model=new DefaultTableModel(vector_boss,columnNames3);
					table3.setModel(table3model);
					table3.updateUI();
				} catch (Exception e2) {	
				}
			}
		});
		/**
		 * ɾ���ұ�ѡ�����
		 * 
		 */
		btn_del.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Vector vector=(Vector) vector_boss.remove(table3.getSelectedRow());
					table3model=new DefaultTableModel(vector_boss,columnNames3);
					table3.setModel(table3model);
					table3.updateUI();
				} catch (Exception e2) {
				}
				
			}
		});
		/**
		 * ������ѡ��Ʒ
		 */	
		btn_addgood.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {	
					if(table1.isShowing()){
						try{
							setTableL_C(table1);
						}catch (Exception e2) {
							
						}
					}else if(table2.isShowing()){
						try{
							setTableL_C(table2);
						}catch (Exception e2) {
							
						}
					}		
			}
		});
		/*
		 * typeWindow������ĵ���¼�
		 * 
		 */
		p_tree_type.tree_type.addTreeSelectionListener(new TreeSelectionListener() {	
			public void valueChanged(TreeSelectionEvent e) {
				DefaultMutableTreeNode node =(DefaultMutableTreeNode) p_tree_type.tree_type.getLastSelectedPathComponent();
				if(node!=null){
					GoodsType type=(GoodsType) node.getUserObject();
					int id=type.getSelf_id();
					table2model=new DefaultTableModel(get_goods_dao.getAllGoods(id),columnNames2);
					table2.setModel(table2model);
					table2.updateUI();
				}
				
			}
		});
		/**
		 * �����Ż����ֲ�ѯ��Ʒ�б�
		 */
		tf_seekgoods.getDocument().addDocumentListener(new DocumentListener() {
			public void removeUpdate(DocumentEvent e) {
				
				updaateTable(table1model, table1, columnNames1,tf_seekgoods.getText());
				updaateTable(table2model, table2, columnNames2,tf_seekgoods.getText());
				
			}
			public void insertUpdate(DocumentEvent e) {
				updaateTable(table1model, table1, columnNames1,tf_seekgoods.getText());
				updaateTable(table2model, table2, columnNames2,tf_seekgoods.getText());
				
			}
			public void changedUpdate(DocumentEvent e) {
				updaateTable(table1model, table1, columnNames1,tf_seekgoods.getText());
				updaateTable(table2model, table2, columnNames2,tf_seekgoods.getText());
				
			}
		});
		/**
		 * ȷ���¼�
		 */
		btn_ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AddReturnGoodsModelWindow.this.brg.data=vector_boss;
					AddReturnGoodsModelWindow.this.brg.tablemodel=new DefaultTableModel(AddReturnGoodsModelWindow.this.brg.data,AddReturnGoodsModelWindow.this.brg.columnNames);
					AddReturnGoodsModelWindow.this.brg.table.setModel(AddReturnGoodsModelWindow.this.brg.tablemodel);
					AddReturnGoodsModelWindow.this.brg.table.updateUI();
					float money=0;
					for(Object str:vector_boss){
						Vector v_money=(Vector) str;
						money+=Float.parseFloat((v_money.get(6)+""));
					}
					AddReturnGoodsModelWindow.this.brg.tf_wantmoney.setText(money+"");
					AddReturnGoodsModelWindow.this.brg.tf_paymoney.setText(money+"");
				} catch (Exception e2) {
					
				}
				if(vector_boss.isEmpty()){
				}else{	
					AddReturnGoodsModelWindow.this.setVisible(false);
				}
			}
		});
		/**
		 * ��ߵ����ݼ��뵽�ұ�
		 */
		table1.addMouseListener(new MyMouse());
		table2.addMouseListener(new MyMouse());
		this.setModal(true);
		this.setVisible(true);
	}
	/**
	 * ���˫���¼����Ҽ��¼�
	 * @author lxh
	 *
	 */
	public class MyMouse extends MouseAdapter{
		public void mouseClicked(MouseEvent e) {
			if(e.getButton()==1&&e.getClickCount()==2){
				if(table1.isShowing()){
					try{
						setTableL_C(table1);
					}catch (Exception e2) {
						
					}
				}else if(table2.isShowing()){
					try{
						setTableL_C(table2);
					}catch (Exception e2) {
						
					}
				}
			}	
		}
	}
	/**
	 * ���б��ӵ��ұ�
	 * @param table_l
	 */
	public void setTableL_C(JTable table){
		Vector date=new Vector();
		Vector vector=(Vector) get_goods_dao.getAllGoods1("").get(table.getSelectedRow());
		try{
			int sum=Integer.parseInt(JOptionPane.showInputDialog("��������:"));
			date.add(vector.get(0));
			date.add(vector.get(1));
			date.add(vector.get(2));
			date.add(vector.get(3));
			date.add(vector.get(4));
			date.add(sum);
			date.add(sum*Float.parseFloat(vector.get(4)+""));
			vector_boss.add(date);
			table3model=new DefaultTableModel(vector_boss,columnNames3);
			table3.setModel(table3model);
			table3.updateUI();
		}catch (Exception e2) {
			
		}
	}/**
	 * �Ƿ�ѡ���˱�����ȡѡ��ı����
	 * @return
	 */
	public Vector isSelectTable(){
		Vector vector=null;
		if(table1.isShowing()){
			try{
				 vector=(Vector) get_goods_dao.getAllGoods1("").get(table1.getSelectedRow());
				 
			}catch (Exception e2) {
				
			}
		}else if(table2.isShowing()){
			try{
				 vector=(Vector) get_goods_dao.getAllGoods1("").get(table2.getSelectedRow());
			}catch (Exception e2) {
				
			}
		}
		return vector;
		}
	/**
	 * �����Ż������ֲ�ѯ����
	 */
	public void updaateTable(DefaultTableModel medel,JTable table,Vector vector,String txt){
		medel=new DefaultTableModel(get_goods_dao.getAllGoods1(txt),vector);
		table.setModel(medel);
		table.updateUI();
	}
}
