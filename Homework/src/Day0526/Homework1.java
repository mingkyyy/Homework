package Day0526;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/*

* 메인 스레드 : 구구단 랜덤하게 5문재를 냄.

* 스래드1 : 3초 단위로 룰루랄라~~를 총 10번 Sysout함

* 스래드2 :다섯문제를 모두 맞힐 때 까지 초 단위로 Sysout 출력함.

*        :각 문제들을 몇초에 입력 했는지 기록.(각 문제 맞추는 시간을 스레드 2에 보관을 해라) 
*      

*/
class Thread1 extends Thread{

	@Override  //3초 단위로 룰루랄라를 총 10번함

		public void run() {
		for(int i=0; i<10; i++) {
			System.out.println("룰루랄라~~");
			try {
				Thread.sleep(3000); ////3초 후에 실행한다
			} catch (InterruptedException e) {
			} 
		}
		}
}

class Thread2 extends Thread{
	    int i=1;
	    boolean run=true;
		List<Integer> records= new ArrayList<Integer>(); //add를 언제 할꺼냐?
		public void terminate() {
			run=false;
		}
@Override
	public void run() {
	
		while(run) { //초수 계속 흘러감
			System.out.println(i +"초");
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
	

	  while(j<6) { //맞은 개수가 5개 나올때 까지 반복
	 for(int i=0; i<5; i++) {	 
		  int random1=(int)(Math.random()*9)+1; //1~9까지 랜덤한 숫자  
		  int random2=(int)(Math.random()*9)+1; //1~9까지 랜덤한 숫자  
		  int result=random1 * random2;
		  String input=JOptionPane.showInputDialog((i+1)+"번째 문제: "+random1+"*"+random2+"의 결과를 작성하세요"); 
		  aa.add(tr2.i);
		  
		   if(input.equals(Integer.toString(result))) {   
			  JOptionPane.showMessageDialog(null, "정답입니다.");
			  j++;
		 }else {  //정답이 아니면
		  JOptionPane.showMessageDialog(null, "틀렷습니다. 처음부터 다시 푸세요");
		  break; //틀리면 처음부터 다시 풀어라
         }
		  
	 }
	 
	 }
	  tr2.terminate(); //초 세는거 끝냄
	  System.out.println("문제를 입력한시간: "+aa);
	 
	  
	 
 }
}

 





