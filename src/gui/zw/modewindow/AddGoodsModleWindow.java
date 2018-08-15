package gui.zw.modewindow;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;


public class AddGoodsModleWindow extends JDialog{
		
		JPanel p_up,p_up1,p_up2,p_up3,p_up4,p_up5,p_up6,p_up7,p_down;													//�������������
		JTextField tf_type,tf_number,tf_name,tf_bar,tf_spec,tf_unit,tf_sum,tf_color,tf_inprice,tf_outprice,tf_bz,tf_adress;
		JButton btn_look,btn_ok,btn_cancel;
		public AddGoodsModleWindow(){
			//-----------��ʼ��-----------------
			p_up=new JPanel();
			p_down=new JPanel();
			p_up1=new JPanel();
			p_up2=new JPanel();
			p_up3=new JPanel();
			p_up4=new JPanel();
			p_up5=new JPanel();
			p_up6=new JPanel();
			p_up7=new JPanel();
			
			tf_type=new JTextField(7);
			tf_number=new JTextField(13);
			tf_name=new JTextField(13);
			tf_bar=new JTextField(13);
			tf_spec=new JTextField(13);
			tf_unit=new JTextField(13);
			tf_sum=new JTextField(13);
			tf_color=new JTextField(13);
			tf_inprice=new JTextField(13);
			tf_outprice=new JTextField(13);
			tf_bz=new JTextField(30);
			tf_adress=new JTextField(30);
			
			btn_look=new JButton("�鿴");
			btn_ok=new JButton("ȷ��");
			btn_cancel=new JButton("�˳�");
			
			//----------���-------------
			//��up��Ϊ3�����
	
			p_up1.add(new JLabel("�������"));
			p_up1.add(tf_type);
			p_up1.add(btn_look);
			p_up1.add(new JLabel("   "));
			p_up1.add(new JLabel("��Ʒ��ţ�"));
			p_up1.add(tf_number);
			
			p_up2.add(new JLabel("��Ʒ���ƣ�"));
			p_up2.add(tf_name);
			p_up2.add(new JLabel("   "));
			p_up2.add(new JLabel("��Ʒ���룺"));
			p_up2.add(tf_bar);
			
			p_up3.add(new JLabel("����ͺţ�"));
			p_up3.add(tf_spec);
			p_up3.add(new JLabel("   "));
			p_up3.add(new JLabel("��         λ��"));
			p_up3.add(tf_unit);
			
			p_up4.add(new JLabel("������ޣ�"));
			p_up4.add(tf_sum);
			p_up4.add(new JLabel("   "));
			p_up4.add(new JLabel("��          ɫ��"));
			p_up4.add(tf_color);
			
			p_up5.add(new JLabel("Ԥ����ۣ�"));
			p_up5.add(tf_inprice);
			p_up5.add(new JLabel("   "));
			p_up5.add(new JLabel("Ԥ���ۼۣ�"));
			p_up5.add(tf_outprice);
			
			p_up6.add(new JLabel("��         ע��"));
			p_up6.add(tf_bz);
			p_up7.add(new JLabel("�������̣�"));
			p_up7.add(tf_adress);
			
			p_up.setLayout(new GridLayout(7,1));
			p_up.add(p_up1);
			p_up.add(p_up2);
			p_up.add(p_up3);
			p_up.add(p_up4);
			p_up.add(p_up5);
			p_up.add(p_up6);
			p_up.add(p_up7);
			
			//up��ϣ���ʼdown
			p_down.setLayout(new GridLayout(1,5));
			p_down.add(new JLabel(""));
			p_down.add(btn_ok);
			p_down.add(new JLabel(""));
			p_down.add(btn_cancel);
			p_down.add(new JLabel(""));
			
			
			p_up1.setBorder(BorderFactory.createTitledBorder(""));
			p_up2.setBorder(BorderFactory.createTitledBorder(""));
			p_up3.setBorder(BorderFactory.createTitledBorder(""));
			p_up4.setBorder(BorderFactory.createTitledBorder(""));
			p_up5.setBorder(BorderFactory.createTitledBorder(""));
			p_up6.setBorder(BorderFactory.createTitledBorder(""));
			p_up7.setBorder(BorderFactory.createTitledBorder(""));
			p_up.setBorder(BorderFactory.createTitledBorder(""));
			p_down.setBorder(BorderFactory.createTitledBorder(""));
			this.setLayout(new BorderLayout());
			this.add(p_up,BorderLayout.CENTER);
			this.add(p_down,BorderLayout.SOUTH);
			this.setTitle("������Ʒ");
			this.setBounds(0, 0, 500, 600);
			this.setLocationRelativeTo(null);
			this.setModal(true);
			this.setVisible(true);
		}
		public static void main(String[] args) {
			new AddGoodsModleWindow();
		}
		
}
