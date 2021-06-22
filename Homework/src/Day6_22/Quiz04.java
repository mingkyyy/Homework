package Day6_22;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import util.MyConnection;

public class Quiz04 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int memNO;
		System.out.print("회원 번호 : ");
		memNO=sc.nextInt();
		
		String sql="SELECT * FROM cart WHERE mem_no=?";
		Connection conn = null;
		PreparedStatement ps= null;
		ResultSet rs= null;
		
		try {
			conn=MyConnection.getConnection();			
			ps=conn.prepareStatement(sql);	
			ps.setInt(1,memNO);
			
			rs=ps.executeQuery();
			//상품 번호 출력 : ct_no
			
			System.out.print("결과 : ");
			while(rs.next()) {
				int ct_no = rs.getInt("ct_no");				
			    System.out.print(ct_no + " ");
			}
			
			
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			MyConnection.close(conn,ps,rs);
	}
	}

}
