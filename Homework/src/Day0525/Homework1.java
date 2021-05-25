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
		
		String menu="1.단어 추가\n 2.모든 단어 보기\n 3.단어 검색\n 4.퀴즈 \n 0.종료합니다.";
		Map<String, English> map=new TreeMap<>();
		
		loop: while(true) {
			String selec=JOptionPane.showInputDialog(menu);
			
			switch (selec) {
			
			 case "0": {
				 JOptionPane.showMessageDialog(null, "프로그램 종료");
				 break loop;//종료
			
			}
       case "1": {  //단어 추가
    	  
    	   String eng=JOptionPane.showInputDialog("영어를 입력하세요");
    	   String kor=JOptionPane.showInputDialog("한국어를 입력하세요");
    	   map.put(eng,new English(kor));
    	   JOptionPane.showMessageDialog(null, "등록 완료되었습니다.");
    	   break;			
				
			}
      case "2": {  //단어 출력
    	  JOptionPane.showMessageDialog(null, map);
    	  break;
	
	
         }
      case "3": {  //있으면 그 단어 뜻 없으면 못 찾았다고 말하기
    	  String name=JOptionPane.showInputDialog("찾을 단어의 영어를 입력하세오: ");
    	  map.containsKey(name);
    	  if(map.containsKey(name)) {
    		  JOptionPane.showMessageDialog(null,map.get(name));
    	  }else {
    		  JOptionPane.showMessageDialog(null, "없는 단어 입니다.");
    	  }
    	  break;
	
	
         }
      case "4": { //퀴즈
    	  Object[] arr=map.values().toArray();  //값들(한국어)만 배열로 받음
    	  int random=(int)(Math.random()*arr.length)+0; //랜드함수로 주소값 맘대로
    	  String quiz=JOptionPane.showInputDialog(arr[random]+"를 영어로 쓰세요"); 
    	 //if(????????){ "맞앗습니다"}
    	  //else{"틀렷습니다"}
    	  //
 
             }   
         }
  }
		

		}
	}

