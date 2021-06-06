package Day6_4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server{
   public static void main(String[] args){
      Socket socket= null;
      BufferedReader br=null;
      BufferedWriter bw=null;
      ServerSocket serverSocket=null;
      Scanner sc=new Scanner(System.in);
      
      
      try{
         serverSocket = new ServerSocket(55000);
         System.out.println("서버 소켓 생성! 클라이언트를 기다립니다..");
         socket = serverSocket.accept(); 
         System.out.println("클라이언트 연결됨! 상대 IP :"
        		 +socket.getInetAddress());

         br =new BufferedReader(new InputStreamReader(socket.getInputStream()));
         bw =new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

         String readMessage;
         String writemessage;
         while ((readMessage=br.readLine())!=null){                            
            System.out.println("클라이언트가 보내온 내용 : " + readMessage);
            
                                  
            System.out.print("클라이언트에게 보낼 메시지: ");
            writemessage=sc.nextLine();
            bw.write(writemessage+"\r\n");            
            bw.flush();
                  
         }
         bw.close();
         br.close();

      }
      catch (Exception e)
      {
         e.printStackTrace();
      }finally {
         try {
            if(serverSocket!=null)
               serverSocket.close();
         }catch (IOException e) {
            e.printStackTrace();
            
         }
      }
   }
}