package gui.zw.modewindow;

import java.awt.Dialog;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class CheckDiagWindow  extends JDialog{
	JPanel jp1,jp2,jp3,jp4,jp5,jp6;
	JButton btn1,btn2,btn3,btn4,btn5,btn6,btn7;
	JTextField tf1,tf2,tf3,tf4,tf5;
	public CheckDiagWindow(){
		jp1=new JPanel();
		jp2=new JPanel();
		jp3=new JPanel();
		jp4=new JPanel();
		jp5=new JPanel();
		jp6=new JPanel();
		
		btn1=new JButton("�̵㵥��");
		btn2=new JButton("��������");
		btn3=new JButton("�ֿ�����");
		btn4=new JButton("����    Ա");
		btn5=new JButton("��        ע");
		btn6=new JButton("ȷ��");
		btn7=new JButton("�˳�");
		
		tf1=new JTextField(10);
		tf2=new JTextField(10);
		tf3=new JTextField(10);
		tf4=new JTextField(10);
		tf5=new JTextField(10);
		jp1.add(btn1);jp1.add(tf1);
		jp2.add(btn2);jp2.add(tf2);
		jp3.add(btn3);jp3.add(tf3);
		jp4.add(btn4);jp4.add(tf4);
		jp5.add(btn5);jp5.add(tf5);
		jp6.add(btn6);jp6.add(btn7);
		
		
		this.add(jp1);
		this.add(jp2);
		this.add(jp3);
		this.add(jp4);
		this.add(jp5);
		this.add(jp6);
		
		this.setLayout(new GridLayout(6,2));
		this.setTitle("�����̵㵥");
		this.setBounds(100, 100, 400, 400);
		this.setModal(true);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new CheckDiagWindow();
	}
}
