package Day0520;

	

import java.util.Scanner;
import java.util.regex.Pattern;

	public class day0520_2 {
         public static void main(String[] args) {
	      // TODO Auto-generated method stub
	      
	      Scanner sc=new Scanner(System.in);  //입력 받을 스캐너 생성
	      String email;
	      String password;
	      
	      String emailst="^[_a-zA-Z0-9-\\.]+@[\\.a-zA-Z0-9-]+\\.[a-zA-Z]+$"; //이메일 형식 정규식
	      String Idlist="^[a-zA-Z]{1}[a-zA-Z0-9_]{4,11}$"; //아이디 정규화(시작은 영문으로 _제외한 특수문자x,영문 숫자로만 이루어진 5~12글자)


	   while(true) {  //break 걸릴때 까지 계속 반복 한다
	         System.out.print("E-MAIL:"); //화면 출력
	         email=sc.next(); //이메일 입력
	      
	         if(Pattern.matches(emailst, email)) {  //입력 email이 정규식 이메일과 같다면
	         String[] str=email.split("@");  //id를 출력하기 위해서 split으로 @기준으로 분리한다.
	         if(Pattern.matches(Idlist,str[0])) { //@전 id가 id정규식과 같다면
	            break;
	          }else { //id 정규식과 같지 않다면
	            System.out.println("잘못된 형식의 아이디입니다. 다시 입력하세요");
	         }
	      }else {
	         System.out.println("잘못된 형식의 이메일 입니다. 다시 입력하세요"); 
	      }
	      }
	      
	      String passst="^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[$@$!%*#?&])[A-Za-z[0-9]$@$!%*#?&]{8,}$"; //8자 이상, 대소문자,특수기호 최소 1개 포함 하는 정규식
	      
	      while(true) { //break 걸릴때 까지 계속 반복
	      System.out.print("password:" );
	       password=sc.next(); //패스워드 입력
	      if(Pattern.matches(passst, password)) { //입력 password와 조건식이 만족한다면
	         System.out.print("확인용 비밀번호를 입력해주세요:");
	         String password2=sc.next(); //확인용 비밀번호를 입력
	         if(password2.equals(password)) { //확인용 비밀번호와 비밀번호가 갖다면
	            break;
	                                
	         }else {  //확인용 비밀번호와 비밀번호가 다르다면
	            System.out.println("비밀번호가 다릅니다. 다시 입력해주세요");
	         }
	         }
	      else { //조건이 정규식 조건이 충족할수 없음
	            System.out.println("정규식에 충족되지 않습니다. 다시 입력해주세요.");
	            
	         
	      }

	      }
	      System.out.println("E-MAIL:"+email);
	      String[] str=email.split("@");  //id를 출력하기 위해서 split으로 @기준으로 분리한다.
	      System.out.println("ID:"+str[0]); //분리된 이메일 앞 부분을 출력한다.
	      String st=password.replaceAll(password.substring(2), "*");  
	      System.out.println("PASSWORD:"+st);
	      
	      
	   }

	}


