package Day6_4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Client{
   public static void main(String[] args){
      Socket socket= null;
      BufferedReader br=null;
      BufferedWriter bw=null;
      Scanner sc=new Scanner(System.in);
      try{
          socket = new Socket("127.0.0.1", 55000);
          

          bw=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
          br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
          
         String writemessage;
         String readmessage;
         while(true) {         
         System.out.print("서버에게 보낼 메시지를 입력하세요 (exit를 입력하면 종료 됩니다.)");
         writemessage=sc.nextLine();
         if("exit".equals(writemessage)) break;
         bw.write(writemessage+"\r\n");
         bw.flush();      
         
         readmessage = br.readLine();               
         System.out.println("서버가 보내온 내용 : " + readmessage);
         
         }
         
         br.close();
         bw.close();
      }
      catch (Exception e)
      {
         e.printStackTrace();
      } finally {
         try {
            if(socket!=null)
               socket.close();
         }catch (IOException e) {
            e.printStackTrace();
         }
      }
   }
}