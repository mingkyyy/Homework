package Day0518;

public class day0518 {
	   public static void main(String[] args) {
		      // TODO Auto-generated method stub
		         long start=System.currentTimeMillis();  //1970.1.1.00시(UTC) ~지금까지 경과한 밀리초
		            
		            for(int i=1; i<=1000000; i++) { //for문 으로 1부터 백만까지 출력
		               System.out.println(i);
		            }
		            long end=System.currentTimeMillis(); ////1970.1.1.00시(UTC) ~지금까지 경과한 밀리초
		            
		            System.out.println("소요시간(밀리초): "+ (end-start));   //end - strart = for문 소요 시간
		            System.out.println("소요시간(초): "+ (end-start)/1000);  //1000밀리초 = 1초


		      

		   }


}
