package gui;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import bean.Admin;
import bean.Customer;
import bean.Depot;
import bean.Employee;
import bean.Supplier;
import service.AdminService;
import service.DepotService;
import service.SystemService;
import util.CastUtil;

import javax.swing.JScrollPane;

/**
 * ��ʵ�����ϸ��Ϣ�������
 * 	�๹��ʵ�ֶ�����
 * @author pcshao
 *
 */
public class Manage_ParentUI extends JFrame{
	
	private JTable table;
	private DefaultTableModel model;
	public Vector items;
	
	private SystemService systemService;
	private DepotService depotService;
	private AdminService adminService;
	
	public Manage_ParentUI(String title) {
			
		systemService = new SystemService();
		depotService = new DepotService();
		adminService = new AdminService();
		
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel jp_top = new JPanel();
		getContentPane().add(jp_top, BorderLayout.NORTH);
		jp_top.setLayout(new GridLayout(0, 8, 0, 0));
		
		JButton btn_add = new JButton("����");
		jp_top.add(btn_add);
		
		JButton btn_edit = new JButton("�޸�");
		jp_top.add(btn_edit);
		
		JButton btn_delete = new JButton("ɾ��");
		jp_top.add(btn_delete);
		
		JButton btn_search = new JButton("����");
		jp_top.add(btn_search);
		
		JButton btn_all = new JButton("ȫ��");
		jp_top.add(btn_all);
		
		JButton btn_export = new JButton("����");
		jp_top.add(btn_export);
		
		JButton btn_exit = new JButton("�˳�");
		jp_top.add(btn_exit);
		
		JPanel jp_center = new JPanel();
		getContentPane().add(jp_center, BorderLayout.CENTER);
		jp_center.setLayout(new BorderLayout(0, 0));
		
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setBounds(0,0,770,400);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		//�жϴ���
		if("Ա������".equals(title)) {
			Manage_employees(title);
		}else if("�ֿ����".equals(title)) {
			Manage_depots(title);
		}else if("����Ա����".equals(title)) {
			Manage_admins(title);
		}else if("�ͻ�����".equals(title)) {
			Manage_customers(title);
		}else if("��Ӧ�̹���".equals(title)) {
			Manage_appliers(title);
		}
		
		JScrollPane scrollPane = new JScrollPane(table);
		jp_center.add(scrollPane);
		
		//����
		btn_exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Manage_ParentUI.this.setVisible(false);
			}
		});
		/**
		 * ������add����ͨ���ж���һ�����ڵı���������Ӧ����ͬ�Ĺ��ܴ���
		 * 	���뵱ǰ����ѡ��table���ݶ���
		 * 	��һ�����ڲ�����ɣ�ˢ�±�����
		 */
		btn_add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//����
				if("Ա������".equals(title)) {
					new Manage_addUI("����Ա��",items);
					updateTable(systemService.getEmployees());
				}else if("�ֿ����".equals(title)) {
					new Manage_addUI("���Ӳֿ�",items);
					updateTable(systemService.getDepots());
				}else if("����Ա����".equals(title)) {
					new Manage_addUI("���Ӳ���Ա",items);
					updateTable(systemService.getAdmins());
				}else if("�ͻ�����".equals(title)) {
					new Manage_addUI("���ӿͻ�",items);
					updateTable(systemService.getCustomers());
				}else if("��Ӧ�̹���".equals(title)) {
					new Manage_addUI("���ӹ�Ӧ��",items);
					updateTable(systemService.getSuppliers());
				}
			}
		});
		/**
		 * ������edit����ͨ���ж���һ�����ڵı���������Ӧ����ͬ�Ĺ��ܴ���
		 * 	���뵱ǰ����ѡ��table���ݶ���
		 * 	��һ�����ڲ�����ɣ�ˢ�±�����
		 */
		btn_edit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//�޸�
				if("Ա������".equals(title)) {
					Vector selected = systemService.getEmployees().get(table.getSelectedRow());
					if(selected==null)
						return;
					new Manage_editUI("�޸�Ա��",items,selected);
					updateTable(systemService.getEmployees());
				}else if("�ֿ����".equals(title)) {
					Vector selected = systemService.getDepots().get(table.getSelectedRow());
					if(selected==null)
						return;
					new Manage_editUI("�޸Ĳֿ�",items,selected);
					updateTable(systemService.getDepots());
				}else if("����Ա����".equals(title)) {
					Vector selected = systemService.getAdmins().get(table.getSelectedRow());
					if(selected==null)
						return;
					new Manage_editUI("�޸Ĳ���Ա",items,selected);
					updateTable(systemService.getAdmins());
				}else if("�ͻ�����".equals(title)) {
					Vector selected = systemService.getCustomers().get(table.getSelectedRow());
					if(selected==null)
						return;
					new Manage_editUI("�޸Ŀͻ�",items,selected);
					updateTable(systemService.getCustomers());
				}else if("��Ӧ�̹���".equals(title)) {
					Vector selected = systemService.getSuppliers().get(table.getSelectedRow());
					if(selected==null)
						return;
					new Manage_editUI("�޸Ĺ�Ӧ��",items,selected);
					updateTable(systemService.getSuppliers());
				}
			}
		});
		btn_delete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//ɾ��
				if("Ա������".equals(title)) {
					Vector selected = systemService.getEmployees().get(table.getSelectedRow());
					if(selected==null)
						return;
					if(confirmRemove(selected.get(1).toString()))
						systemService.removeEmployee(Integer.parseInt(selected.get(0).toString()));
					updateTable(systemService.getEmployees());	
				}else if("�ֿ����".equals(title)) {
					Vector selected = systemService.getDepots().get(table.getSelectedRow());
					if(selected==null)
						return;
					Depot depot = new Depot(Integer.parseInt(selected.get(0).toString()), selected.get(1).toString());
					if(confirmRemove(depot.getName()))
						depotService.removeDepotById(depot);
					updateTable(systemService.getDepots());
				}else if("����Ա����".equals(title)) {
					Vector selected = systemService.getAdmins().get(table.getSelectedRow());
					if(selected==null)
						return;
					Admin admin = new Admin(Integer.parseInt(selected.get(0).toString()), selected.get(1).toString());
					if(confirmRemove(admin.getName()))
						adminService.removeAdmin(admin);
					updateTable(systemService.getAdmins());
				}else if("�ͻ�����".equals(title)) {
					Vector selected = systemService.getCustomers().get(table.getSelectedRow());
					if(selected==null)
						return;
					if(confirmRemove(selected.get(1).toString()))
						systemService.removeCustomer(Integer.parseInt(selected.get(0).toString()));
					updateTable(systemService.getCustomers());	
				}else if("��Ӧ�̹���".equals(title)) {
					Vector selected = systemService.getSuppliers().get(table.getSelectedRow());
					if(selected==null)
						return;
					if(confirmRemove(selected.get(1).toString()))
						systemService.removeSupplier(Integer.parseInt(selected.get(0).toString()));
					updateTable(systemService.getSuppliers());	
				}
			}
		});
		btn_search.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String content = new JOptionPane().showInputDialog("�����������Ϣ");
				if("Ա������".equals(title)) {
					updateTable(new CastUtil().objectToVector(systemService.searchEmployee(content), new Employee()));
				}else if("�ֿ����".equals(title)) {
					updateTable(new CastUtil().objectToVector(depotService.searchDepot(content), new Depot()));
				}else if("����Ա����".equals(title)) {
					updateTable(new CastUtil().objectToVector(adminService.searchAdmin(content), new Admin()));
				}else if("�ͻ�����".equals(title)) {
					updateTable(new CastUtil().objectToVector(systemService.searchCustomer(content), new Customer()));
				}else if("��Ӧ�̹���".equals(title)) {
					updateTable(new CastUtil().objectToVector(systemService.searchSupplier(content), new Supplier()));	
				}
			}
		});
		btn_all.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if("Ա������".equals(title)) {
					updateTable(systemService.getEmployees());	
				}else if("�ֿ����".equals(title)) {
					updateTable(systemService.getDepots());
				}else if("����Ա����".equals(title)) {
					updateTable(systemService.getAdmins());
				}else if("�ͻ�����".equals(title)) {
					updateTable(systemService.getCustomers());	
				}else if("��Ӧ�̹���".equals(title)) {
					updateTable(systemService.getSuppliers());	
				}
			}
		});
		btn_export.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//����
			}
		});
	}
	private boolean confirmRemove(String name) {
		return new JOptionPane().showConfirmDialog(Manage_ParentUI.this, "�Ƿ�ȷ��ɾ��  "+name, "", JOptionPane.YES_NO_OPTION)==0;
	}
	private void updateTable(Vector<Vector> tableData) {
		//ˢ������
		model = new DefaultTableModel(tableData, items);
		table.setModel(model);
		table.updateUI();
	}
	public void Manage_depots(String title) {
		Manage_ParentUI.this.setTitle(title);
		table = new JTable() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		items = new Vector();
		items.add("���");
		items.add("�ֿ�����");
		items.add("������");
		items.add("��ϵ�绰");
		items.add("�ֿ��ַ");
		items.add("��ע");
		//�ֿ����
		model = new DefaultTableModel(systemService.getDepots(), items);
		table.setModel(model);
		table.updateUI();
		
	}
	public void Manage_employees(String title) {
		Manage_ParentUI.this.setTitle(title);
		//Ա������
		table = new JTable() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		items = new Vector();
		items.add("���");
		items.add("Ա������");
		items.add("ְ��");
		items.add("��ϵ�绰");
		items.add("��ϵ��ַ");
		items.add("��ע");
		model = new DefaultTableModel(systemService.getEmployees(), items);
		table.setModel(model);
		table.updateUI();
	}
	public void Manage_admins(String title) {
		Manage_ParentUI.this.setTitle(title);
		//����Ա����
		table = new JTable() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		items = new Vector();
		items.add("���");
		items.add("�û�����");
		items.add("����ְ��");
		items.add("�Ƿ�POS����Ա");
		items.add("�Ƿ��");
		items.add("����");
		model = new DefaultTableModel(systemService.getAdmins(), items);
		table.setModel(model);
		table.updateUI();
	}
	public void Manage_customers(String title) {
		Manage_ParentUI.this.setTitle(title);
		//�ͻ�����
		table = new JTable() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		items = new Vector();
		items.add("���");
		items.add("�ͻ�����");
		items.add("��ϵ��");
		items.add("��ϵ�绰");
		items.add("��ϵ��ַ");
		items.add("��ע");
		model = new DefaultTableModel(systemService.getCustomers(), items);
		table.setModel(model);
		table.updateUI();
	}
	public void Manage_appliers(String title) {
		Manage_ParentUI.this.setTitle(title);
		//��Ӧ�̹���
		table = new JTable() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		items = new Vector();
		items.add("���");
		items.add("����������");
		items.add("��ϵ��");
		items.add("��ϵ�绰");
		items.add("��ϵ��ַ");
		items.add("��ע");
		model = new DefaultTableModel(systemService.getSuppliers(), items);
		table.setModel(model);
		table.updateUI();
	}
	
}
