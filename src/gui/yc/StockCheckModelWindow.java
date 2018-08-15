package gui.yc;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import bean.GoodsType;

import util.MyDateChooser;
import util.TypeWindow;
import dao.DepotsDao;
import gui.TypeTreeModelWindow;
//��ǰ����ѯ
public class StockCheckModelWindow extends JDialog{
	MyDateChooser dc1,dc2;
	JTabbedPane tabbed;
	JPanel jp_p1,jp_p2,jp_p3;
	JPanel jp_p1_top,jp_p1_top_p1,jp_p1_top_p2,jp_p1_center;
	JPanel jp_p2_top,jp_p2_top_p1,jp_p2_top_p2,jp_p2_center;
	JPanel jp_p3_left,jp_p3_left_top,jp_p3_left_center,jp_p3_right,jp_p3_right_top,jp_p3_right_center;
	JButton btn_top_p1_1,btn_top_p1_2,btn_top_p1_3,btn_top_p1_4,btn_top_p1_5,btn_top_p1_6,btn_top_p1_7;
	JButton  btn_top_p2_1,btn_top_p2_2,btn_top_p2_3,btn_top_p2_4,btn_top_p2_5;
	JTextField jf_p1_1,jf_p1_2;
	JTextField jf_p2_1,jf_p2_2,jf_p2_3;
	JTextField jf_p3_1,jf_p3_2;
	Vector aModelVector1,aModelVector2;
	DefaultComboBoxModel aModel1,aModel2;
	JComboBox cobx_depots;
	JCheckBox cbox_1,cbox_2;
	Vector columnNames1,columnNames2,columnNames3;
	Vector<Vector> data1,data2,data3;
	DefaultTableModel table1model,table2model,table3model;
	JTable table1,table2,table3;
	String[] arr1={"��Ʒ���","��Ʒ����","����","��λ","�����","Ԥ���ۼ�","�����ֵ","����ͺ�","��������","��ע  "};
	String[] arr2={"��Ʒ���","��Ʒ����","�������","��������","�����˻�����","�����ϼ�����","��������","�����˻�����","���ۺϼ�����"};
	String[] arr3={"��Ʒ���","��Ʒ����","������","���ۼ�","��λ","����ͺ�","��������","��ע"};
	
	
	public StockCheckModelWindow(){	
		dc1=MyDateChooser.getInstance("yyyy-MM-dd");
		dc2=MyDateChooser.getInstance("yyyy-MM-dd");
		tabbed=new JTabbedPane();
		/**
		 * ѡ�һ
		 */
		jp_p1=new JPanel();//���䶯���
		jp_p1_top=new JPanel();
		jp_p1_top_p1=new JPanel();
		jp_p1_top_p2=new JPanel();
		jf_p1_1=new JTextField(6);
		jf_p1_2=new JTextField(10);
		aModelVector1=new DepotsDao().getDepots();
		aModel1=new DefaultComboBoxModel(aModelVector1);
		cobx_depots=new JComboBox(aModel1);
		jp_p1_center=new JPanel();
		btn_top_p1_1=new JButton("�߼���ѯ");
		btn_top_p1_2=new JButton("�鿴��ϸ");
		btn_top_p1_3=new JButton("�����ο�");
		btn_top_p1_4=new JButton("�˻��ο�");
		btn_top_p1_5=new JButton("����");
		btn_top_p1_6=new JButton("�˳�");
		btn_top_p1_7=new JButton("��ѯ");
		cbox_1=new JCheckBox("����ʾ���Ϊ0����Ʒ");
		cbox_2=new JCheckBox("ʹ�ø��������ѯ��Ʒ");
		
		data1=new Vector<Vector>();
		columnNames1=new Vector();
		for(String str:arr1){
			columnNames1.add(str);
		}
		table1model=new DefaultTableModel(data1, columnNames1);
		table1=new JTable(table1model);
		
		jp_p1.setLayout(new BorderLayout());
		jp_p1_top.setLayout(new GridLayout(2,1));
		jp_p1_top_p1.add(btn_top_p1_1);
		jp_p1_top_p1.add(btn_top_p1_2);
		jp_p1_top_p1.add(btn_top_p1_3);
		jp_p1_top_p1.add(btn_top_p1_4);
		jp_p1_top_p1.add(btn_top_p1_5);
		jp_p1_top_p1.add(btn_top_p1_6);
		jp_p1_top.add(jp_p1_top_p1);
		jp_p1_top_p2.add(new JLabel("�ֿ�:"));
		jp_p1_top_p2.add(new JScrollPane(cobx_depots));
		jp_p1_top_p2.add(new JLabel("��Ʒ���:"));
		jf_p1_1.setText("�������");
		jf_p1_1.setEditable(false);
		jp_p1_top_p2.add(jf_p1_1);
		jp_p1_top_p2.add(new JLabel("��Ʒ��Ż�����:"));
		jp_p1_top_p2.add(jf_p1_2);
		jp_p1_top_p2.add(btn_top_p1_7);
		jp_p1_top_p2.add(cbox_1);
		jp_p1_top_p2.add(cbox_2);
		jp_p1_top.add(jp_p1_top_p2);
		jp_p1.add(jp_p1_top,BorderLayout.NORTH);
		
		jp_p1_center.setLayout(new GridLayout(1,1));
		jp_p1_center.add(new JScrollPane(table1));
		jp_p1.add(jp_p1_center,BorderLayout.CENTER);
		/**
		 * ѡ�2
		 * @author yc
		 */
		jp_p2=new JPanel();//��Ʒ�䶯���
		jp_p2_top=new JPanel();
		jp_p2_top_p1=new JPanel();
		jp_p2_top_p2=new JPanel();
		jf_p2_1=new JTextField(10);
		jf_p2_2=new JTextField(10);
		jf_p2_3=new JTextField(10);
		aModelVector2=new DepotsDao().getDepots();
		aModel2=new DefaultComboBoxModel(aModelVector2);
		cobx_depots=new JComboBox(aModel2);
		jp_p2_center=new JPanel();
		btn_top_p2_1=new JButton("�鿴��ϸ");
		btn_top_p2_2=new JButton("����");
		btn_top_p2_3=new JButton("��ӡ");
		btn_top_p2_4=new JButton("�˳�");
		btn_top_p2_5=new JButton("��ѯ");
		
		data2=new Vector<Vector>();
		columnNames2=new Vector();
		for(String str:arr2){
			columnNames2.add(str);
		}
		table2model=new DefaultTableModel(data2, columnNames2);
		table2=new JTable(table2model);
		
		jp_p2.setLayout(new BorderLayout());
		jp_p2_top.setLayout(new GridLayout(2,1));
		jp_p2_top_p1.add(btn_top_p2_1);
		jp_p2_top_p1.add(btn_top_p2_2);
		jp_p2_top_p1.add(btn_top_p2_3);
		jp_p2_top_p1.add(btn_top_p2_4);
		jp_p2_top.add(jp_p2_top_p1);
		jp_p2_top_p2.add(new JLabel("ͳ��ʱ�䣺"));
		dc1.register(jf_p2_1);
		jf_p2_1.setText(dc1.getStrDate());
		jp_p2_top_p2.add(jf_p2_1);
		jp_p2_top_p2.add(new JLabel("��"));
		dc2.register(jf_p2_2);
		jf_p2_2.setText(dc2.getStrDate());
		jp_p2_top_p2.add(jf_p2_2);
		jp_p2_top_p2.add(new JLabel("��Ʒ��Ż�����"));
		jp_p2_top_p2.add(jf_p2_3);
		jp_p2_top_p2.add(btn_top_p2_5);
		jp_p2_top.add(jp_p2_top_p2);
		jp_p2.add(jp_p2_top,BorderLayout.NORTH);
		jp_p2_center.setLayout(new GridLayout(1,1));
		jp_p2_center.add(new JScrollPane(table2));
		jp_p2.add(jp_p2_center,BorderLayout.CENTER);
		/**
		 * ѡ�3
		 * @author yc
		 */
		jp_p3=new JPanel();//��Ʒ��Ϣ��ѯ
		jp_p3_left=new JPanel();
		jp_p3_right=new JPanel();
		jp_p3_left_top=new JPanel();
		jp_p3_left_center=new JPanel();
		jf_p3_1=new JTextField(12);
		jf_p3_2=new JTextField(12);
		jp_p3_right_top=new JPanel();
		jp_p3_right_center=new JPanel();
		data3=new Vector<Vector>();
		columnNames3=new Vector();
		for(String str:arr3){
			columnNames3.add(str);
		}
		table3model=new DefaultTableModel(data3, columnNames3);
		table3=new JTable(table3model);
		jp_p3.setLayout(new BorderLayout());
		jp_p3_left.setBorder(BorderFactory.createTitledBorder("�����Ϣ"));
		jp_p3_left.setLayout(new BorderLayout());
		jp_p3_left_top.add(new JLabel("�������"));
		jp_p3_left_top.add(jf_p3_1);
		jp_p3_left.add(jp_p3_left_top,BorderLayout.NORTH);
		jp_p3_left_center.setLayout(new GridLayout(1,1));
		jp_p3_left_center.setBorder(BorderFactory.createTitledBorder(""));
		jp_p3_left_center.add(new TypeWindow());
		jp_p3_left.add(jp_p3_left_center,BorderLayout.CENTER);
		jp_p3.add(jp_p3_left,BorderLayout.WEST);
		jp_p3_right.setLayout(new BorderLayout());
		jp_p3_right_top.add(new JLabel("��Ʒ��Ϣ��ѯ"));
		jp_p3_right_top.add(jf_p3_2);
		jp_p3_right_top.add(new JLabel("(������Ʒ��š����� )"));
		jp_p3_right.add(jp_p3_right_top,BorderLayout.NORTH);
		jp_p3_right_center.setLayout(new GridLayout(1,1));
		jp_p3_right_center.add(new JScrollPane(table3));
		jp_p3_right.add(jp_p3_right_center,BorderLayout.CENTER);
		jp_p3_right.setBorder(BorderFactory.createTitledBorder("��Ʒ�б�"));
		jp_p3.add(jp_p3_right,BorderLayout.CENTER);
		/**
		 * �����¼�
		 * @author yc
		 * 
		 */
		//��Ʒ����ı���������
		jf_p1_1.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseClicked(MouseEvent e) {
				if(e.getButton()==1){
					if(e.getButton()==1){
						TypeTreeModelWindow ttmw=new TypeTreeModelWindow();
						ttmw.setVisible(true);
						jf_p1_1.setText(ttmw.type.getName());
					}
				}
			}
		});
		
		
		tabbed.add("���䶯���",jp_p1);
		tabbed.add("��Ʒ�䶯���",jp_p2);
		tabbed.add("��Ʒ��Ϣ��ѯ",jp_p3);
		this.add(tabbed);
		this.setTitle("��ǰ����ѯ");	
		this.setBounds(300, 100, 900, 550);
		this.setLocationRelativeTo(null);
		this.setModal(true);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new StockCheckModelWindow();
	}
	
}
