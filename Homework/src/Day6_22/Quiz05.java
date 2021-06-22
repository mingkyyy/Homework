package Day6_22;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import util.MyConnection;

public class Quiz05 {
	
	
	public static void main(String[] args) {
		//회원 가입
		Scanner sc = new Scanner(System.in);
		String menu= "1. 회원가입 \r\n" + "2. 로그인 \r\n" + "3. 상품 보기\r\n" + "4. 장바구니 담기\r\n" + "5. 내 장바구니 보기\r\n"+"0. 종료";
		boolean run=true;
		
		String name=null;
		String email=null;
		int type=0;
		int point=0;
		int memNO=0;
		int pdNO=0;
		int ctNO=0;
		
		String sql=null;
		Connection conn=null;
		PreparedStatement ps= null;
		ResultSet rs= null;
		
		
		while(run) {
			
			
			System.out.println(menu);
			System.out.print("메뉴 버튼을 선택하세요 : ");
			int num=sc.nextInt();
			switch (num) {
			
			case 0:
				System.out.println("프로그램이 종료 됩니다.");
				run=false;
				break;
				
			case 1: //회원 가입
				try {
				sql="INSERT member (username, point, type, email) VALUE(?, ?, ? , ?)";
				System.out.print("이름을 입력하세요");
				name=sc.next();
				System.out.print("포인트를 입력하세요");
				point=sc.nextInt();
				System.out.print("타입을 입력하세요 0 : 일반 , 1 : 관리자");
				type=sc.nextInt();
				System.out.print("이메일을 입력하세요");
				email=sc.next();
				
				
				conn=MyConnection.getConnection();			
				ps=conn.prepareStatement(sql);			
				//rs=ps.executeQuery();
				ps.setString(1, name);
				ps.setInt(2, point);
				ps.setInt(3, type);
				ps.setString(4, email);
				
				ps.execute();
				System.out.println("회원 가입 완료!");
				System.out.println();
				
				
				}catch (Exception e) {
					e.printStackTrace();
				}finally {
					MyConnection.close(conn, ps);
				}
				
				break;
				
				
				
			case 2: //로그인
				try {
				sql="SELECT * FROM member WHERE username= ? ";
				System.out.print("이름을 입력하세요");
				name=sc.next();
				conn=MyConnection.getConnection();			
				ps=conn.prepareStatement(sql);	
				ps.setString(1, name);
				rs=ps.executeQuery();
				
				while(rs.next()) {
					if(rs.getString("username").contentEquals(name)) {
						System.out.println("로그인 완료");
						System.out.println();
						memNO=rs.getInt("mem_no");
						//System.out.println("회원 번호 :" +memNO); 회원 번호 나옴
						
						}else {
							System.out.println("로그인 실패"); //??? console 창에 안나옴
					
					}
					
				}	
				}
				catch (Exception e) {
					e.printStackTrace();
				}finally {
					MyConnection.close(conn, ps);
				}
				
			
				break;
	
			case 3: //상품보기
				sql="SELECT * FROM product";
				
				try {
					conn=MyConnection.getConnection();			
					ps=conn.prepareStatement(sql);			
					rs=ps.executeQuery();
					
					while(rs.next()) {
						int pd_no = rs.getInt("pd_no");
						String pd_name = rs.getString("pd_name");
						int pd_price = rs.getInt("pd_price");
						
						
						
						System.out.println("상품 번호 : "+ pd_no);
						System.out.println("상품 이름 : "+ pd_name);
						System.out.println("상품 가격 : "+ pd_price);
						System.out.println();
					}
					
					
					
				}catch (Exception e) {
					e.printStackTrace();
				}finally {
					MyConnection.close(conn,ps,rs);
			}
	
				break;
	
			case 4: //장바구니에 담기
				sql="INSERT INTO cart(mem_no, pd_no) VALUES(?, ?)";
				//System.out.print("회원 번호를 입력하세요 : ");
				//memNO=sc.nextInt();
				System.out.print("추가 할 상품 번호를 입력하세요 : ");
				pdNO=sc.nextInt();
				
				
				
				
				try {
					conn=MyConnection.getConnection();			
					ps=conn.prepareStatement(sql);	
					
					ps.setInt(1, memNO);
					ps.setInt(2, pdNO);
					
					ps.execute();
					System.out.println("장바구니에 담기 완료!");
					System.out.println();
				}catch (Exception e) {
					e.printStackTrace();
				}finally {
					
				}
	
				break;
			case 5: //내 장바구니 보기
				sql="SELECT * FROM cart WHERE mem_no = ?";
				System.out.println("장바구에 찾을 회원 번호 입력");
				
				
				try {
					conn=MyConnection.getConnection();
					ps=conn.prepareStatement(sql);
					ps.setInt(1, memNO);
					rs=ps.executeQuery();
					while(rs.next()) { //상품 번호 출력
						
						int pd_no = rs.getInt("pd_no");				
					    System.out.print(pd_no + " ");
					    
					}
					System.out.println();
					
					
				} catch (SQLException e) {
					
					e.printStackTrace();
				}	
				
				
				break;
				
				
			default:
				break;
			} //swith 문 끝
		} //while 문 끝
		
		
		
	
}
}