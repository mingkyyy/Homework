package Day0525;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.JOptionPane;







class English{
	String kor;  
	String eng;  
	
	public English(String kor) {
		this.kor=kor;
		
	}
	
	
	@Override
	public String toString() {
		return kor;
	}
}

public class Homework1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String menu="1.�ܾ� �߰�\n 2.��� �ܾ� ����\n 3.�ܾ� �˻�\n 4.���� \n 0.�����մϴ�.";
		Map<String, English> map=new TreeMap<>();
		
		loop: while(true) {
			String selec=JOptionPane.showInputDialog(menu);
			
			switch (selec) {
			
			 case "0": {
				 JOptionPane.showMessageDialog(null, "���α׷� ����");
				 break loop;//����
			
			}
       case "1": {  //�ܾ� �߰�
    	  
    	   String eng=JOptionPane.showInputDialog("��� �Է��ϼ���");
    	   String kor=JOptionPane.showInputDialog("�ѱ�� �Է��ϼ���");
    	   map.put(eng,new English(kor));
    	   JOptionPane.showMessageDialog(null, "��� �Ϸ�Ǿ����ϴ�.");
    	   break;			
				
			}
      case "2": {  //�ܾ� ���
    	  JOptionPane.showMessageDialog(null, map);
    	  break;
	
	
         }
      case "3": {  //������ �� �ܾ� �� ������ �� ã�Ҵٰ� ���ϱ�
    	  String name=JOptionPane.showInputDialog("ã�� �ܾ��� ��� �Է��ϼ���: ");
    	  map.containsKey(name);
    	  if(map.containsKey(name)) {
    		  JOptionPane.showMessageDialog(null,map.get(name));
    	  }else {
    		  JOptionPane.showMessageDialog(null, "���� �ܾ� �Դϴ�.");
    	  }
    	  break;
	
	
         }
      case "4": { //����
    	  Object[] arr=map.values().toArray();  //����(�ѱ���)�� �迭�� ����
    	  int random=(int)(Math.random()*arr.length)+0; //�����Լ��� �ּҰ� �����
    	  String quiz=JOptionPane.showInputDialog(arr[random]+"�� ����� ������"); 
    	 //if(????????){ "�¾ѽ��ϴ�"}
    	  //else{"Ʋ�ǽ��ϴ�"}
    	  //
 
             }   
         }
  }
		

		}
	}

