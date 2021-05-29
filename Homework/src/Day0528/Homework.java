package Day0528;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Homework{
	private JFrame frame; //������ ����	
	private JButton[] buttons=new JButton[16];
	private int i=1;
    public Homework() {
			
	frame=new JFrame("����");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	frame.setSize(600,600); //������ ����
	frame.setLocationRelativeTo(null); // �� ��� ��ġ ����
		
	//1���� 16���� ��ư ����

	for(int i= 0; i<buttons.length; ++i) {
		buttons[i] = new JButton(String.valueOf(i+1)); 
	}
	
	//��ư ���ġ
	for(int i= 0; i<20; ++i) {
		int i1=(int)(Math.random()*buttons.length);
		int i2=(int)(Math.random()*buttons.length);
		JButton temp= buttons[i1];
		buttons[i1]=buttons[i2];
		buttons[i2]=temp;	
   }
	frame.setLayout(new GridLayout(4,4));	

	for(int i=0; i<buttons.length; ++i) {
	  frame.add(buttons[i]);	 //ȭ�� ���̱� �Ϸ�
	}
	
	ActionListener litesner = new ActionListener() {   //�̰� Ŭ�� ������		
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton clickedBtn = (JButton) e.getSource();
			
			if(Integer.parseInt(clickedBtn.getText())==i) {
				clickedBtn.setVisible(false);
				i++;
				if(Integer.parseInt(clickedBtn.getText())==16) {
					JOptionPane.showMessageDialog(frame, "win");
					frame.dispose();	
					
			}
		}else{
			JOptionPane.showMessageDialog(frame, "LOSE �ٽ� �õ��ϼ���");
			
			
			
			}
		
		}	
	};
	
	for(int i=0; i<buttons.length; ++i) {
		  	 buttons[i].addActionListener(litesner); //������ �߰�
		} 	
	frame.setVisible(true);
    }
    public static void main(String[] args) {
    	new Homework();	
	}

}