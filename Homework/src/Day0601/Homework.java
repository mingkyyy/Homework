package Day0601;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Homework {
	public static void main(String[] args) {
		try {
			for(int i=2; i<10; i++) {
				FileWriter fw=new FileWriter(i+"단.txt");
				for(int j=1; j<10; j++) {
			
			fw.write(i+"*"+j+"="+(i*j)+"\n");					
				}
				fw.close();	
			}			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //2단~9단까지 txt만 들기
		
		Scanner sc= new Scanner(System.in);
		System.out.print("출력하고 싶은 단을 입력하세요: ");
		int i=sc.nextInt();
		try {
			FileInputStream fin = new FileInputStream(i+"단.txt");
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
