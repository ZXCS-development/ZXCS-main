package gui.zw.warehouse;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import dao.GoodsDao;
import gui.zw.modewindow.*;
import util.MyDateChooser;

public class CheckWindow extends JFrame {
	public static void main(String[] args) {
		new CheckWindow();
	}
	JTabbedPane jtp;//ѡ�
	JPanel jp_center,jp_top,jp_low,jtp_2,jtp_3,jtp_1;
	JPanel jp_center_top,jp_center_low,jp_low_top,jp_low_low,
	jp_low_center,jp_top_top,jp_top_low,jp_top_center,jp_top_center_top;		
	JTextField tf_1,tf_2,tf_3,tf_4,tf_5,tf_6;
	//Vector items=new Vector();
	JButton btn_1,btn_2,btn_3,btn_4,btn_5,btn_6,btn_7,btn_8,btn_9;
	JButton btn1_1,btn1_2;
	//�ڶ�������
	Vector items=new Vector();
	JComboBox  cmbx;
	JPanel jp2_center,jp2_top,jp2_low,jtp2_2,jtp2_3,jtp2_1;
	JPanel jp2_center_top,jp2_center_low,jp2_low_top,jp2_low_low,
	jp2_low_center,jp2_top_top,jp2_top_low,jp2_top_center,jp2_top_center_top;		
	JTextField tf2_1,tf2_2,tf2_3,tf2_4,tf2_5,tf2_6,tf2_7;
	//Vector items=new Vector();
	JButton btn2_1,btn2_2,btn2_3,btn2_4,btn2_5,btn2_6,btn2_7,btn2_8,btn2_9;
	//��һ�����
	JTable table;
	Vector<Vector> rowData=new Vector<Vector>();	
	Vector columnNames=new Vector();	
	DefaultTableModel model;
	//�ڶ������
	JTable table1;
	Vector<Vector> rowData1=new Vector<Vector>();
	Vector columnNames1=new Vector();
	DefaultTableModel model1;
	//���������
	JTable table2;
	Vector<Vector> rowData2=new Vector<Vector>();	
	Vector columnNames2=new Vector();	
	DefaultTableModel model2;
	//���ĸ����
	JTable table3;
	Vector<Vector> rowData3=new Vector<Vector>();
	Vector columnNames3=new Vector();
	DefaultTableModel model3;
	MyDateChooser dc1_1,dc1_2,dc2_2;
	GoodsDao gdao=null;
	public CheckWindow(){
		gdao=new GoodsDao();
		
		btn_1=new JButton("��ʼ�̵�");
		btn_2=new JButton("�鿴���� ");
		btn_3=new JButton("����excel");
		btn_4=new JButton("�˳�");
		btn_5=new JButton("�����̵㵥");
		btn_6=new JButton("�޸��̵㵥");
		btn_7=new JButton("ɾ���̵㵥");
		btn_8=new JButton("�߼���ѯ");
		btn_9=new JButton("��ѯ ");
		
		btn1_1=new JButton("ȷ��");
		btn1_2=new JButton("�˳�");
		
		btn2_1=new JButton("��ӡ");
		btn2_2=new JButton("�鿴���� ");
		btn2_3=new JButton("����excel");
		btn2_4=new JButton("�˳�");
		btn2_5=new JButton("��ѯ");	
		btn2_6=new JButton("����");
		btn2_7=new JButton("ȷ��");
		btn2_8=new JButton("�˳�");
		
	
		
		dc1_1=MyDateChooser.getInstance("yyyy-MM-dd");
		dc1_2=MyDateChooser.getInstance("yyyy-MM-dd");
		dc2_2=MyDateChooser.getInstance("yyyy-MM-dd");
		
			
		tf_1=new JTextField(10);tf_2=new JTextField(10);tf_3=new JTextField(10);
		tf_4=new JTextField(8);tf_5=new JTextField(50);tf_6=new JTextField(20);
		jp_center=new JPanel();jp_top=new JPanel();jp_low=new JPanel();
		jp_center_top=new JPanel();jp_center_low=new JPanel();
		jp_low_top=new JPanel();jp_low_low=new JPanel();jp_low_center=new JPanel();
		jp_top_top=new JPanel();jp_top_low=new JPanel();jp_top_center=new JPanel();
		jp_top_center_top=new JPanel();jp_low_low=new JPanel();
		
		jtp=new JTabbedPane();
		jtp_1=new JPanel();jtp_2=new JPanel();
		
		//top��Ӱ�ť
		jp_top_top.add(btn_1);jp_top_top.add(btn_2);jp_top_top.add(btn_3);
		jp_top_top.add(btn_4);jp_top_center_top.add(btn_5);jp_top_center_top.add(btn_6);
		jp_top_center_top.add(btn_7);jp_top_center_top.add(btn_8);
		//��һ�����
		columnNames.add("�̵㵥�ݺ�");
		columnNames.add("����");
		columnNames.add("�ֿ�����");
		columnNames.add("����");
		//columnNames.add("��Ʒ����");
		//columnNames.add("��Ʒ����");
		columnNames.add("��ע");
		//gdao.getpdOrders()rowData
		model=new DefaultTableModel(gdao.getGoods(), columnNames);
		table=new JTable(model);
		//�ڶ������
		columnNames1.add("���");	
		columnNames1.add("�̵㵥��");
		columnNames1.add("��Ʒ���");	
		//gdao.getpdOrdersDetails()
		model1=new DefaultTableModel(rowData1, columnNames1);
		table1=new JTable(model1);
	
		//top����ٷ�
		jp_top.setLayout(new BorderLayout());
		jp_top.add(jp_top_top,BorderLayout.NORTH);
		jp_top.add(jp_top_center,BorderLayout.CENTER);
		jp_top_center.setBorder(BorderFactory.createTitledBorder("�̵㵥���б�"));
		jp_top_center.setLayout(new BorderLayout());
		
		jp_top_center.add(jp_top_center_top,BorderLayout.NORTH);
		jp_top_center.add(new JScrollPane(table),BorderLayout.CENTER);
		//jp_top.add(new Label("�ϼ�0"),BorderLayout.SOUTH);
		
		//low����ٷ�
		jp_low.setBorder(BorderFactory.createTitledBorder("�̵���Ʒ��ϸ"));
		jp_low_top.add(new Label("����Բ����̵��ţ�"));jp_low_top.add(tf_1);
		
		jp_low_top.add(btn_9);
		jp_low.setLayout(new BorderLayout());
		jp_low.add(jp_low_top,BorderLayout.NORTH);
		jp_low.add(new JScrollPane(table1),BorderLayout.CENTER);
		jp_low.add(jp_low_low,BorderLayout.SOUTH);
		jp_low_low.add(btn1_1);jp_low_low.add(btn1_2);
		btn1_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CheckWindow.this.setVisible(false);
			}
		});
		//��ʷ�̵��ѯ
		//top��Ӱ�ť
		items.add("���вֿ�");
		items.add("���ֿ�");
		items.add("���Ͽ�");
		items.add("�ƿ�");
		cmbx=new  JComboBox(items);
		
		tf2_1=new JTextField(8);tf2_2=new JTextField(10);tf2_3=new JTextField(10);
		tf2_4=new JTextField(8);tf2_5=new JTextField(8);tf2_6=new JTextField(20);
		tf2_7=new JTextField(8);
		jp2_center=new JPanel();jp2_top=new JPanel();jp2_low=new JPanel();
		jp2_center_top=new JPanel();jp2_center_low=new JPanel();
		jp2_low_top=new JPanel();jp2_low_low=new JPanel();jp2_low_center=new JPanel();
		jp2_top_top=new JPanel();jp2_top_low=new JPanel();jp2_top_center=new JPanel();
		jp2_top_center_top=new JPanel();
		
		
				jp2_top_top.add(btn2_1);jp2_top_top.add(btn2_2);jp2_top_top.add(btn2_3);
				jp2_top_top.add(btn2_4);
				jp2_top_center_top.add(new JLabel("��ѯ���ڣ�"));
				//�˴��������
				dc1_1.register(tf2_4);jp2_top_center_top.add(tf2_4);
				jp2_top_center_top.add(new JLabel("��"));
				dc1_2.register(tf2_5);jp2_top_center_top.add(tf2_5);
				jp2_top_center_top.add(new JLabel("�ֿ�����:"));jp2_top_center_top.add(cmbx);
				jp2_top_center_top.add(new JLabel("����Ա"));jp2_top_center_top.add(tf2_1);
				jp2_top_center_top.add(btn2_5);jp2_top_center_top.add(tf2_7);
				//���������
				columnNames2.add("�̵㵥��");
				columnNames2.add("����");
				columnNames2.add("�ֿ�����");
				columnNames2.add("����Ա");
				columnNames2.add("��Ʒ����");
				columnNames2.add("��Ʒ����");
				columnNames2.add("��ע");
				model2=new DefaultTableModel(rowData2, columnNames2);
				table2=new JTable(model2);
				//���ĸ�������Ʒ goods������
				columnNames3.add("���");	
				columnNames3.add("����");
				columnNames3.add("��λ");
				columnNames3.add("����ͺ�");
				//columnNames3.add("");
				//columnNames3.add("��������");
				columnNames3.add("�ֿ�");
				//columnNames3.add("�̵�����");
				model3=new DefaultTableModel(rowData2, columnNames3);
				table3=new JTable(model3);
			
				//top����ٷ�
				jp2_top.setLayout(new BorderLayout());
				jp2_top.add(jp2_top_top,BorderLayout.NORTH);
				jp2_top.add(jp2_top_center,BorderLayout.CENTER);
				//jp2_top_center.setBorder(BorderFactory.createTitledBorder("�̵㵥�б�"));
				jp2_top_center.setLayout(new BorderLayout());
				
				jp2_top_center.add(jp2_top_center_top,BorderLayout.NORTH);
				jp2_top_center.add(new JScrollPane(table2),BorderLayout.CENTER);
				//jp2_top.add(new Label("�ϼ�0"),BorderLayout.SOUTH);
				
				//low����ٷ�
				//jp2_low_top.add(new Label("��Ʒ�����̵���Ϣ��"));
				jp2_low.setBorder(BorderFactory.createTitledBorder("���»���"));
				jp2_low_top.add(new Label("���Բ���Ʒ��Ż��߻������ƣ�"));
				jp2_low_top.add(tf2_3);
				jp2_low_top.add(btn2_6);
				jp2_low.setLayout(new BorderLayout());
				jp2_low.add(jp2_low_top,BorderLayout.NORTH);
				jp2_low.add(new JScrollPane(table3),BorderLayout.CENTER);
				jp2_low.add(jp2_low_low,BorderLayout.SOUTH);
				jp2_low_low.add(btn2_7);jp2_low_low.add(btn2_8);
		
				btn_1.addActionListener(new ActionListener() {	
					//��ʼ�̵�
					public void actionPerformed(ActionEvent e) {
						new StartCheck();
						
					}
				});
				//����¼�
				btn_5.addActionListener(new ActionListener() {
					//�����̵㵥
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						new  NewCheckWindow();
					}
				});
				btn_6.addActionListener(new ActionListener() {
					//�޸��̵㵥
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						new CheckDiagWindow();
					}
				});
				btn_7.addActionListener(new ActionListener() {
					//�Ƴ��̵㵥
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						new CheckDiagWindow();
					}
				});
				//��ʷ�̵��ѯ
				btn2_5.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						
						
					}
				});
				btn2_6.addActionListener(new ActionListener() {
					//���һ������Ҽ��Ѳ���
				
					public void actionPerformed(ActionEvent e) {
						String info=tf2_3.getText().trim();
						model3=new DefaultTableModel(gdao.getgoodsthreequeery(info), columnNames);
						table3.setModel(model3);
						table3.updateUI();
						
					}
				});
		
				jtp.add("�̵��б�",jtp_1);jtp.add("��ʷ�̵��ѯ",jtp_2);
				jtp_1.setLayout(new GridLayout(2,1));
				jtp_1.add(jp_top);jtp_1.add(jp_low);
				jtp_2.setLayout(new GridLayout(2,1));
				jtp_2.add(jp2_top);jtp_2.add(jp2_low);
				//jtp_2.add(jp_top);jtp_1.add(jp_low);
				this.add(jtp);
				this.setTitle("����̵�");			
				this.setBounds(100, 100, 800, 600);
				this.setDefaultCloseOperation(HIDE_ON_CLOSE);
				this.setVisible(true);
		}

	}
