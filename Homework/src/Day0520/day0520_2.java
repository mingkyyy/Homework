package Day0520;

	

import java.util.Scanner;
import java.util.regex.Pattern;

	public class day0520_2 {
         public static void main(String[] args) {
	      // TODO Auto-generated method stub
	      
	      Scanner sc=new Scanner(System.in);  //�Է� ���� ��ĳ�� ����
	      String email;
	      String password;
	      
	      String emailst="^[_a-zA-Z0-9-\\.]+@[\\.a-zA-Z0-9-]+\\.[a-zA-Z]+$"; //�̸��� ���� ���Խ�
	      String Idlist="^[a-zA-Z]{1}[a-zA-Z0-9_]{4,11}$"; //���̵� ����ȭ(������ �������� _������ Ư������x,���� ���ڷθ� �̷���� 5~12����)


	   while(true) {  //break �ɸ��� ���� ��� �ݺ� �Ѵ�
	         System.out.print("E-MAIL:"); //ȭ�� ���
	         email=sc.next(); //�̸��� �Է�
	      
	         if(Pattern.matches(emailst, email)) {  //�Է� email�� ���Խ� �̸��ϰ� ���ٸ�
	         String[] str=email.split("@");  //id�� ����ϱ� ���ؼ� split���� @�������� �и��Ѵ�.
	         if(Pattern.matches(Idlist,str[0])) { //@�� id�� id���Խİ� ���ٸ�
	            break;
	          }else { //id ���Խİ� ���� �ʴٸ�
	            System.out.println("�߸��� ������ ���̵��Դϴ�. �ٽ� �Է��ϼ���");
	         }
	      }else {
	         System.out.println("�߸��� ������ �̸��� �Դϴ�. �ٽ� �Է��ϼ���"); 
	      }
	      }
	      
	      String passst="^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[$@$!%*#?&])[A-Za-z[0-9]$@$!%*#?&]{8,}$"; //8�� �̻�, ��ҹ���,Ư����ȣ �ּ� 1�� ���� �ϴ� ���Խ�
	      
	      while(true) { //break �ɸ��� ���� ��� �ݺ�
	      System.out.print("password:" );
	       password=sc.next(); //�н����� �Է�
	      if(Pattern.matches(passst, password)) { //�Է� password�� ���ǽ��� �����Ѵٸ�
	         System.out.print("Ȯ�ο� ��й�ȣ�� �Է����ּ���:");
	         String password2=sc.next(); //Ȯ�ο� ��й�ȣ�� �Է�
	         if(password2.equals(password)) { //Ȯ�ο� ��й�ȣ�� ��й�ȣ�� ���ٸ�
	            break;
	                                
	         }else {  //Ȯ�ο� ��й�ȣ�� ��й�ȣ�� �ٸ��ٸ�
	            System.out.println("��й�ȣ�� �ٸ��ϴ�. �ٽ� �Է����ּ���");
	         }
	         }
	      else { //������ ���Խ� ������ �����Ҽ� ����
	            System.out.println("���ԽĿ� �������� �ʽ��ϴ�. �ٽ� �Է����ּ���.");
	            
	         
	      }

	      }
	      System.out.println("E-MAIL:"+email);
	      String[] str=email.split("@");  //id�� ����ϱ� ���ؼ� split���� @�������� �и��Ѵ�.
	      System.out.println("ID:"+str[0]); //�и��� �̸��� �� �κ��� ����Ѵ�.
	      String st=password.replaceAll(password.substring(2), "*");  
	      System.out.println("PASSWORD:"+st);
	      
	      
	   }

	}


