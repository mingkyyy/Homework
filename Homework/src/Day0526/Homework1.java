package Day0526;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/*

* ���� ������ : ������ �����ϰ� 5���縦 ��.

* ������1 : 3�� ������ ������~~�� �� 10�� Sysout��

* ������2 :�ټ������� ��� ���� �� ���� �� ������ Sysout �����.

*        :�� �������� ���ʿ� �Է� �ߴ��� ���.(�� ���� ���ߴ� �ð��� ������ 2�� ������ �ض�) 
*      

*/
class Thread1 extends Thread{

	@Override  //3�� ������ ������ �� 10����

		public void run() {
		for(int i=0; i<10; i++) {
			System.out.println("������~~");
			try {
				Thread.sleep(3000); ////3�� �Ŀ� �����Ѵ�
			} catch (InterruptedException e) {
			} 
		}
		}
}

class Thread2 extends Thread{
	    int i=1;
	    boolean run=true;
		List<Integer> records= new ArrayList<Integer>(); //add�� ���� �Ҳ���?
		public void terminate() {
			run=false;
		}
@Override
	public void run() {
	
		while(run) { //�ʼ� ��� �귯��
			System.out.println(i +"��");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {			
			}
			++i;
		}
	}
}
public class Homework1 {

 public static void main(String[] args) {
    
	 Thread1 tr1=new Thread1();
	 Thread2 tr2=new Thread2();
	 tr1.start();
	 tr2.start();
	 List<Integer> aa= tr2.records;
	 int j=1;
	

	  while(j<6) { //���� ������ 5�� ���ö� ���� �ݺ�
	 for(int i=0; i<5; i++) {	 
		  int random1=(int)(Math.random()*9)+1; //1~9���� ������ ����  
		  int random2=(int)(Math.random()*9)+1; //1~9���� ������ ����  
		  int result=random1 * random2;
		  String input=JOptionPane.showInputDialog((i+1)+"��° ����: "+random1+"*"+random2+"�� ����� �ۼ��ϼ���"); 
		  aa.add(tr2.i);
		  
		   if(input.equals(Integer.toString(result))) {   
			  JOptionPane.showMessageDialog(null, "�����Դϴ�.");
			  j++;
		 }else {  //������ �ƴϸ�
		  JOptionPane.showMessageDialog(null, "Ʋ�ǽ��ϴ�. ó������ �ٽ� Ǫ����");
		  break; //Ʋ���� ó������ �ٽ� Ǯ���
         }
		  
	 }
	 
	 }
	  tr2.terminate(); //�� ���°� ����
	  System.out.println("������ �Է��ѽð�: "+aa);
	 
	  
	 
 }
}

 





