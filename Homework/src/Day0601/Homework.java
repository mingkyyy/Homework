package Day0601;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Homework {
	public static void main(String[] args) {
		try {
			for(int i=2; i<10; i++) {
				FileWriter fw=new FileWriter(i+"��.txt");
				for(int j=1; j<10; j++) {
			
			fw.write(i+"*"+j+"="+(i*j)+"\n");					
				}
				fw.close();	
			}			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //2��~9�ܱ��� txt�� ���
		
		Scanner sc= new Scanner(System.in);
		System.out.print("����ϰ� ���� ���� �Է��ϼ���: ");
		int i=sc.nextInt();
		try {
			FileInputStream fin = new FileInputStream(i+"��.txt");
			Scanner scanner=new Scanner(fin);
			String s;
			while(scanner.hasNext()) {
				s=scanner.nextLine();
				System.out.println(s);
			}
			sc.close();
			fin.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
