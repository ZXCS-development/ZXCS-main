package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import gui.lxh.OldGoodsADDModelWindow;

public class Index_bottom_SomeButtonUI extends JPanel{

	JButton btn_1,btn_2,btn_3,btn_4,btn_5;
	JPanel jp;
	
	public Index_bottom_SomeButtonUI() {
		jp = new JPanel(new GridLayout(1, 5));
		jp.add(btn_1 = new JButton("��Ʒ����")); 
		btn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new OldGoodsADDModelWindow(null);
			}
		});
		jp.add(btn_2 = new JButton("�����̹���")); 
		jp.add(btn_3 = new JButton("�ͻ�����")); 
		jp.add(btn_4 = new JButton("�ֿ�����")); 
		jp.add(btn_5 = new JButton("Ա����Ϣ")); 
		this.add(jp);
		
		btn_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Manage_ParentUI("��Ӧ�̹���");
			}
		});
		btn_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Manage_ParentUI("�ͻ�����");
			}
		});
		btn_4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Manage_ParentUI("�ֿ����");
			}
		});
		btn_5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Manage_ParentUI("Ա������");
			}
		});
	}
}
