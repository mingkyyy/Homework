package Day0518;

public class day0518 {
	   public static void main(String[] args) {
		      // TODO Auto-generated method stub
		         long start=System.currentTimeMillis();  //1970.1.1.00��(UTC) ~���ݱ��� ����� �и���
		            
		            for(int i=1; i<=1000000; i++) { //for�� ���� 1���� �鸸���� ���
		               System.out.println(i);
		            }
		            long end=System.currentTimeMillis(); ////1970.1.1.00��(UTC) ~���ݱ��� ����� �и���
		            
		            System.out.println("�ҿ�ð�(�и���): "+ (end-start));   //end - strart = for�� �ҿ� �ð�
		            System.out.println("�ҿ�ð�(��): "+ (end-start)/1000);  //1000�и��� = 1��


		      

		   }


}
