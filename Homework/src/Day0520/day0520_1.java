package Day0520;


import java.util.regex.Pattern;

	public class day0520_1 {

	   public static void main(String[] args) {
	      // TODO Auto-generated method stub
	      
	      //String[] split(String regex)
	      //�Է¹��� ����ǥ���� �Ǵ� ���� ���ڸ� �������� ���ڿ��� ������ �迭�� �����Ͽ� �����Ѵ�.
	      
	      String str="010-5319-6261";
	      String[] mom=str.split("-");  //-�� �������� ���ڿ��� ������ ����
	      String n1 = mom[0];  
	      String n2 = mom[1];  
	      String n3 = mom[2];  
	      
	      System.out.println(n1);  //010
	      System.out.println(n2);  //5319
	      System.out.println(n3);  //6261
	      
	      //String.matches() 
	      //Ư�� ������ ���ڿ��� �����ϴ��� Ȯ���Ҽ� �ִ�.(����ǥ��)
	      String st="JavaStudy";
	      String st2="dfef546";
	      String ex="^[a-zA-Z]*$"; //��� ������ �ϴ� ���Խ�
	      System.out.println(Pattern.matches(ex, st));  //true
	      System.out.println(Pattern.matches(ex, st2));  //false
	      
	      
	   }

	}


