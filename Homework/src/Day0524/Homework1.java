package Day0524;

import java.util.ArrayList;


import javax.swing.JOptionPane;


class Nation {
	String nation;
	String capital;
	int population;
	
	Nation(String nation, String capital, int population){
		
		this.nation=nation;
		this.capital=capital;
		this.population=population;
		
	}
	
	
	@Override
	public String toString() {
		return  nation+"," +capital+","+population;
	}

}

public class Homework1 {


	public static void main(String[] args) {
	ArrayList<Nation> arry=new ArrayList<Nation>();
		
	    boolean run=true;
		
	while(run) {
		int num=Integer.parseInt(JOptionPane.showInputDialog("���ڸ� �Է��ϼ��� (1.���� �߰� 2. ��� ���� ���� 3.��ȣ�� �˻� 4. �̸����� �˻� 0. ����): "));
		
		switch (num) {   //���� �߰�
		case 1:   
			String nation=JOptionPane.showInputDialog("������ �Է��ϼ���: ");	
			String capital=JOptionPane.showInputDialog("������ �Է��ϼ���: ");
			
			int population=Integer.parseInt(JOptionPane.showInputDialog("�α��� �Է��ϼ���: "));
			arry.add(new Nation(nation, capital, population));
			break;
		
		case 2:  //��� ���� ����
			    
				JOptionPane.showMessageDialog(null, arry);
			    
				break;
			
			
		case 3:  //��ȣ�� �˻�
			
			int nn=Integer.parseInt(JOptionPane.showInputDialog("������ �Է��ϼ���")); 
			if(arry.contains(nn)) {
				JOptionPane.showMessageDialog(null, "�ֽ��ϴ�.");
			}else {
				JOptionPane.showMessageDialog(null, "�����ϴ�.");
			}
			
			break;
		
		case 4:  //�̸����� �˻�
			
			
			String nnn=JOptionPane.showInputDialog("�������� �Է��ϼ���: ");
			if(arry.contains(nnn)) {
				JOptionPane.showMessageDialog(null, "�ֽ��ϴ�.");
			}else {
				JOptionPane.showMessageDialog(null, "�����ϴ�.");
			}
			
			break;
	
		case 0:  //����
			run=false;
			break;
			
			
		}		
			
		}
	JOptionPane.showMessageDialog(null, "����Ǿ����ϴ�.");
		
	}


}



