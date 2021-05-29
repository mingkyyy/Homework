package Day0528;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Homework{
	private JFrame frame; //프레임 생성	
	private JButton[] buttons=new JButton[16];
	private int i=1;
    public Homework() {
			
	frame=new JFrame("과제");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	frame.setSize(600,600); //사이즈 설정
	frame.setLocationRelativeTo(null); // 한 가운데 위치 설정
		
	//1부터 16까지 버튼 생성

	for(int i= 0; i<buttons.length; ++i) {
		buttons[i] = new JButton(String.valueOf(i+1)); 
	}
	
	//버튼 재배치
	for(int i= 0; i<20; ++i) {
		int i1=(int)(Math.random()*buttons.length);
		int i2=(int)(Math.random()*buttons.length);
		JButton temp= buttons[i1];
		buttons[i1]=buttons[i2];
		buttons[i2]=temp;	
   }
	frame.setLayout(new GridLayout(4,4));	

	for(int i=0; i<buttons.length; ++i) {
	  frame.add(buttons[i]);	 //화면 보이기 완료
	}
	
	ActionListener litesner = new ActionListener() {   //이게 클릭 했을때		
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
			JOptionPane.showMessageDialog(frame, "LOSE 다시 시도하세요");
			
			
			
			}
		
		}	
	};
	
	for(int i=0; i<buttons.length; ++i) {
		  	 buttons[i].addActionListener(litesner); //리스너 추가
		} 	
	frame.setVisible(true);
    }
    public static void main(String[] args) {
    	new Homework();	
	}

}