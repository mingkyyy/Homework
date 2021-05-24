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
		int num=Integer.parseInt(JOptionPane.showInputDialog("숫자를 입력하세요 (1.국가 추가 2. 모든 국가 보기 3.번호로 검색 4. 이름으로 검색 0. 종료): "));
		
		switch (num) {   //국가 추가
		case 1:   
			String nation=JOptionPane.showInputDialog("국가명 입력하세요: ");	
			String capital=JOptionPane.showInputDialog("수도명 입력하세요: ");
			
			int population=Integer.parseInt(JOptionPane.showInputDialog("인구수 입력하세요: "));
			arry.add(new Nation(nation, capital, population));
			break;
		
		case 2:  //모든 국가 보기
			    
				JOptionPane.showMessageDialog(null, arry);
			    
				break;
			
			
		case 3:  //번호로 검색
			
			int nn=Integer.parseInt(JOptionPane.showInputDialog("숫자을 입력하세요")); 
			if(arry.contains(nn)) {
				JOptionPane.showMessageDialog(null, "있습니다.");
			}else {
				JOptionPane.showMessageDialog(null, "없습니다.");
			}
			
			break;
		
		case 4:  //이름으로 검색
			
			
			String nnn=JOptionPane.showInputDialog("국가명을 입력하세요: ");
			if(arry.contains(nnn)) {
				JOptionPane.showMessageDialog(null, "있습니다.");
			}else {
				JOptionPane.showMessageDialog(null, "없습니다.");
			}
			
			break;
	
		case 0:  //종료
			run=false;
			break;
			
			
		}		
			
		}
	JOptionPane.showMessageDialog(null, "종료되었습니다.");
		
	}


}



