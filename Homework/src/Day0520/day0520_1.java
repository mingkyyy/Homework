package Day0520;


import java.util.regex.Pattern;

	public class day0520_1 {

	   public static void main(String[] args) {
	      // TODO Auto-generated method stub
	      
	      //String[] split(String regex)
	      //입력받은 정규표현식 또는 툭정 문자를 기준으로 문자열을 나누어 배열에 저장하여 리턴한다.
	      
	      String str="010-5319-6261";
	      String[] mom=str.split("-");  //-를 기준으로 문자열을 나누어 저장
	      String n1 = mom[0];  
	      String n2 = mom[1];  
	      String n3 = mom[2];  
	      
	      System.out.println(n1);  //010
	      System.out.println(n2);  //5319
	      System.out.println(n3);  //6261
	      
	      //String.matches() 
	      //특정 패턴의 문자열을 포함하는지 확인할수 있다.(정규표현)
	      String st="JavaStudy";
	      String st2="dfef546";
	      String ex="^[a-zA-Z]*$"; //영어만 나오게 하는 정규식
	      System.out.println(Pattern.matches(ex, st));  //true
	      System.out.println(Pattern.matches(ex, st2));  //false
	      
	      
	   }

	}


