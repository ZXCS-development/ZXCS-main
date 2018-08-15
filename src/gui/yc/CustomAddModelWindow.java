package gui.yc;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import bean.Customer;

import dao.CustomDao;

public class CustomAddModelWindow extends JDialog{
	JPanel jp1,jp2,jp3,jp4,jp5,jp6,jp7,jp8,jp9;
	JTextField tf_p1,tf_p2,tf_p3,tf_p4,tf_p5,tf_p6,tf_p7;
	JRadioButton btn_f,btn_s;
	ButtonGroup bg;
	JLabel jl;
	JButton btn_ok,btn_exit;
	Customer ret;
	public CustomAddModelWindow(){
		jp1=new JPanel();
		jp2=new JPanel();
		jp3=new JPanel();
		jp4=new JPanel();
		jp5=new JPanel();
		jp6=new JPanel();
		jp7=new JPanel();
		jp8=new JPanel();
		jp9=new JPanel();
		tf_p1=new JTextField(20);
		tf_p2=new JTextField(20);
		tf_p3=new JTextField(20);
		tf_p4=new JTextField(20);
		tf_p5=new JTextField(20);
		tf_p6=new JTextField(10);
		tf_p7=new JTextField(20);
		btn_f=new JRadioButton("Ĭ�Ͽͻ�");
		btn_s=new JRadioButton("����");
		bg=new ButtonGroup();
		jl=new JLabel("(����Ӧ�գ������˿ͻ�ʱ,�˿ͻ�ĿǰǷ�ҷ��Ļ�����.)");
		btn_ok=new JButton("ȷ��");
		btn_exit=new JButton("�˳�");
		this.setLayout(new GridLayout(9,1));
		jp9.add(new JLabel("�ͻ����:"));
		jp9.add(tf_p7);
		jp1.add(new JLabel("�ͻ�����:"));
		jp1.add(tf_p1);
		jp2.add(new JLabel("��   ϵ �ˣ�"));
		jp2.add(tf_p2);
		jp3.add(new JLabel("��ϵ�绰:"));
		jp3.add(tf_p3);
		jp4.add(new JLabel("��ϵ��ַ:"));
		jp4.add(tf_p4);
		jp5.add(new JLabel("��         ע:"));
		jp5.add(tf_p5);
		jp6.add(new JLabel("����Ӧ�գ�"));
		jp6.add(tf_p6);
		bg.add(btn_f);
		bg.add(btn_s);
		jp6.add(btn_f);
		jp6.add(btn_s);
		jl.setForeground(Color.red);
		jp7.add(jl);
		jp8.setLayout(new GridLayout(1,5));
		jp8.add(new JLabel());
		jp8.add(btn_ok);
		jp8.add(new JLabel());
		jp8.add(btn_exit);
		jp8.add(new JLabel());
		this.add(jp9);
		this.add(jp1);
		this.add(jp2);
		this.add(jp3);
		this.add(jp4);
		this.add(jp5);
		this.add(jp6);	
		this.add(jp7);
		this.add(jp8);
		
		/**
		 * �����¼�
		 * @author yc
		 */
		//�ı���ֻ����������
		tf_p7.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {	
				if(e.getKeyChar()>KeyEvent.VK_0 &&e.getKeyChar()<KeyEvent.VK_9){
				
				}else if (e.getKeyChar()==KeyEvent.VK_BACK_SPACE){
					
				}else{
					JOptionPane.showMessageDialog(CustomAddModelWindow.this, "����������!!");
					e.consume();
				}
			}
			
			@Override
			public void keyReleased(KeyEvent e) {}
			
			@Override
			public void keyPressed(KeyEvent e) {}
		});
		
		//ȷ��
		btn_ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str1=tf_p7.getText().trim();
				int i=Integer.parseInt(str1);
				String str2=tf_p1.getText().trim();
				String str3=tf_p2.getText().trim();
				String str4=tf_p3.getText().trim();
				String str5=tf_p4.getText().trim();
				String str6=tf_p5.getText().trim();
				if(str1.isEmpty()){
					JOptionPane.showMessageDialog(CustomAddModelWindow.this, "�ͻ����Ʋ���Ϊ��");
				}else{
					if(str2.isEmpty()){
						str2=" ";
					}
					if(str3.isEmpty()){
						str3=" ";
					}
					if(str4.isEmpty()){
						str4=" ";
					}
					if(str5.isEmpty()){
						str5=" ";
					}
					if(str6.isEmpty()){
						str6=" ";
					}
					Customer c=new Customer();
					c.setCid(i);
					c.setName(str2);
					c.setContact(str3);
					c.setPhone(str4);
					c.setAddress(str5);
					c.setBz(str6);
					new CustomDao().addCustomersInfo(c);
					ret=c;//�����������
					CustomAddModelWindow.this.setVisible(false);
				}
				
				
				
			}
		});
		//�˳�
		btn_exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomAddModelWindow.this.setVisible(false);
			}
		});
		this.setTitle("���ӿͻ�");
		this.setBounds(500,250,360,360);
		this.setModal(true);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new CustomAddModelWindow();
	}
}
