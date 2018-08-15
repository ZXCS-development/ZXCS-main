package gui.lxh;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import util.CastUtil;
import dao.SuppliersDao;

//�ͻ���Ϣ
public class SupplierInfoModelWindow extends JDialog{
	public Vector retData;
	JPanel jp_center,jp_bottom;
	Vector<Vector> data;
	Vector columnNames;
	DefaultTableModel tablemodel;
	JTable table;
	JTextField tf_check;
	JButton btn_add,btn_alter,btn_ok,btn_exit;
	SuppliersDao sp;
	
	public SupplierInfoModelWindow(){
		
		sp=new SuppliersDao();
		
		jp_center=new JPanel();
		jp_bottom=new JPanel();
		tf_check=new JTextField(15);
		btn_add=new JButton("�����ͻ�");
		btn_alter=new JButton("�޸�");
		btn_ok=new JButton("ȷ��");
		btn_exit=new JButton("�˳�");
		columnNames=new Vector();
		columnNames.add("���");
		columnNames.add("�ͻ�����");
		columnNames.add("��ϵ��");
		columnNames.add("��ϵ�绰");
		columnNames.add("��ϵ��ַ");
		//data=new Vector<Customer>();
		
		data = new CastUtil().SupplierToVector(sp.getSupplier());
		tablemodel = new DefaultTableModel(data, columnNames);
		
		table=new JTable(tablemodel)
		{
			public boolean isCellEditable(int row,int clumn){
				return false;
			}
		};
		jp_center.setLayout(new GridLayout(1,1));
		jp_center.add(new JScrollPane(table));
		jp_bottom.setBorder(BorderFactory.createTitledBorder(""));
		jp_bottom.add(new JLabel("���ҿͻ���"));
		jp_bottom.add(tf_check);
		jp_bottom.add(btn_add);
		jp_bottom.add(btn_alter);
		jp_bottom.add(btn_ok);
		jp_bottom.add(btn_exit);
		
/*-------------------------------------����------------------------------------*/
		//�����ͻ�	
			btn_add.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new SupplierInfoModelWindow();
				}
			});
			
		//ȷ��
			btn_ok.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						retData  = data.get(table.getSelectedRow());
						SupplierInfoModelWindow.this.setVisible(false);
					} catch (Exception e2) {	
					}
					
				}
			});
		//�˳�
			btn_exit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					SupplierInfoModelWindow.this.setVisible(false);
				}
			});
		//���ҹ�����
			tf_check.getDocument().addDocumentListener(new DocumentListener() {
				public void removeUpdate(DocumentEvent e) {
					String str=tf_check.getText();
					tablemodel=new DefaultTableModel(new CastUtil().SupplierToVector(sp.getSuppliersInfoByContactorName(str)),columnNames);
					table.setModel(tablemodel);
					table.updateUI();
				}
				public void insertUpdate(DocumentEvent e) {
					String str=tf_check.getText();
					tablemodel=new DefaultTableModel(new CastUtil().SupplierToVector(sp.getSuppliersInfoByContactorName(str)),columnNames);
					table.setModel(tablemodel);
					table.updateUI();
				}
				public void changedUpdate(DocumentEvent e) {}
			});
			
		
		this.setLayout(new BorderLayout());
		this.add(jp_center,BorderLayout.CENTER);
		this.add(jp_bottom,BorderLayout.SOUTH);
		this.setBounds(310, 250, 600, 300);
		this.setModal(true);
		this.setVisible(true);
		

		
	}
}
