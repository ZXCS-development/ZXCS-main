package util;

import gui.lxh.AddGoodsModleWindow;
import gui.lxh.OldGoodsADDModelWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JDialog;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;

import dao.GetAllGoodsDao;
import dao.GoodsTypeDao;

import bean.GoodsType;



public class TypeWindow extends JPanel{	
	//�������Ҽ���Ĳ˵�
	JPopupMenu pop;
	JMenuItem mitem_add,mitem_alter,mitem_delete;
	GoodsTypeDao dao=null;

	//���������йص�
	public JTree tree_type;
	DefaultTreeModel  tree_model;
	DefaultMutableTreeNode node_alltype;
	

	public TypeWindow(){
		pop=new JPopupMenu();
		mitem_add=new JMenuItem("���");
		mitem_alter=new JMenuItem("�޸�");
		mitem_delete=new JMenuItem("ɾ��");
		pop.add(mitem_add);
		pop.add(mitem_alter);
		pop.add(mitem_delete);
		dao=new GoodsTypeDao();
		
		//�������
		node_alltype=new DefaultMutableTreeNode(new GoodsType(1,"�ֿ�",1));
		node_alltype=(dao.getNodeFromDB(1,node_alltype));
		tree_model=new DefaultTreeModel(node_alltype);
		tree_type=new JTree(tree_model);
		
		this.add(tree_type);
		
		//�Ҽ�����¼�
		tree_type.addMouseListener(new myMouse());	
		
		//���һ���ڵ�
		mitem_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					DefaultMutableTreeNode node=(DefaultMutableTreeNode) tree_type.getLastSelectedPathComponent();
					String str=new JOptionPane().showInputDialog("������Ҫ��ӵ�������֣�").trim();
					if(str==null||str.equals("")){	
						JOptionPane.showMessageDialog(tree_type, "�벻Ҫ�����ֵ����");
					}else{
						if(node==null){													//���node��ȫ��node,����������Ǹ��ڵ�
							JOptionPane.showMessageDialog(tree_type, "��ѡ�нڵ�����ӣ���");
						}else{
							GoodsType type=(GoodsType) node.getUserObject();						//��ȡѡ�еĽڵ�
							int superid=dao.getSuperId(type.getSelf_id());				//��ȡѡ�еĽڵ㸸�׵�id
							int selfid=dao.getIdNumber();								//�����½ڵ��id
							dao.insertInfo(selfid,type.getSelf_id(),str);
							node.add(new DefaultMutableTreeNode(new GoodsType(selfid,str,type.getSelf_id())));

							tree_type.setModel(tree_model);
							tree_type.updateUI();
						}
					}
				}catch (Exception ex) {
					
				}	
			}
		});
		
		//�޸�
		mitem_alter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				DefaultMutableTreeNode node=(DefaultMutableTreeNode) tree_type.getLastSelectedPathComponent();
					String new_name=new JOptionPane().showInputDialog("������Ҫ�޸ĺ��������֣�").trim();
					if(new_name==null||new_name.equals("")){	
						JOptionPane.showMessageDialog(tree_type, "�벻Ҫ�����ֵ����");
					}else{
						if(node==null){													//���node��ȫ��node,����������Ǹ��ڵ�
							JOptionPane.showMessageDialog(tree_type, "��ѡ�нڵ��ٵ���޸ģ���");
						}else{
							GoodsType type=(GoodsType) node.getUserObject();						//��ȡѡ�еĽڵ�
							dao.alterNode(type.getSelf_id(), new_name);
							
							DefaultMutableTreeNode node1=new DefaultMutableTreeNode(new GoodsType(1,"�ֿ�",1));
							node1=dao.getNodeFromDB(1,node1);
							tree_model=new DefaultTreeModel(node1);
							DefaultTreeModel sb=tree_model;
							tree_type.setModel(sb);
							tree_type.updateUI();

						}
					}
				}catch (Exception ex) {
					
				}		
			}
		});
		//ɾ����������Ҷ�ӽڵ㣬����û����Ʒ
		mitem_delete.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				try{
					DefaultMutableTreeNode node=(DefaultMutableTreeNode) tree_type.getLastSelectedPathComponent();
					GoodsType type=(GoodsType) node.getUserObject();
					if(node.isLeaf()){
						dao.deleteNode(type.getSelf_id());
						
						//������ˢ�²���Ŷ
						DefaultMutableTreeNode node1=new DefaultMutableTreeNode(new GoodsType(1,"�ֿ�",1));
						node1=dao.getNodeFromDB(1,node1);
						tree_model=new DefaultTreeModel(node1);
						DefaultTreeModel sb=tree_model;
						tree_type.setModel(tree_model);
						tree_type.updateUI();
						//ˢ�½���
					}else{
						JOptionPane.showMessageDialog(tree_type, "ֻ��ɾ��Ҷ�ӽڵ�");
					}
				}catch (Exception ex) {
					JOptionPane.showMessageDialog(tree_type, "��ѡ�нڵ��ٵ���Ҽ���");
				}
				
				
			}
		});
	
	}
	
		//ʵ���Ҽ������Ҫ����
	public class myMouse extends MouseAdapter{
		public void mouseClicked(MouseEvent e) {
			if(e.getButton()==3){
				pop.show(tree_type, e.getX(), e.getY());	
			}
		}
	}
}
