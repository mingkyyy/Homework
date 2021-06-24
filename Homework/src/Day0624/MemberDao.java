package Day0624;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberDao {
	
	private static MemberDao instance;
	private MemberDao() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static MemberDao getInstance() {
		if(instance == null) {
			instance = new MemberDao();
		}
		return instance;
	}
	
	public MemberDto select(int memberNo) {
		String sql="SELECT mem_no, username, point, type, email ,regdate FROM member WHERE mem_no = ? ";
		MemberDto dto = null;
		try {
			conn=getConnection();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, memberNo);
			rs=ps.executeQuery();
			if(rs.next()) {
				dto=new MemberDto();
				dto.setMem_no(rs.getInt("mem_no"));
				dto.setUsername(rs.getString("username"));
				dto.setPoint(rs.getInt("point"));
				dto.setType(rs.getInt("type"));
				dto.setEmail(rs.getString("email"));
				dto.setRegdate(rs.getString("regdate"));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(conn, ps, rs);
		}
		return dto;
	}
	
	public List<MemberDto> selectAll(){
		String sql="SELECT mem_no, username, point, type, email ,regdate FROM member";
		ArrayList<MemberDto> list = new ArrayList<>();
		MemberDto dto=null;
		try {
			conn=getConnection();
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				dto=new MemberDto();
				dto.setMem_no(rs.getInt("mem_no"));
				dto.setUsername(rs.getString("username"));
				dto.setPoint(rs.getInt("point"));
				dto.setType(rs.getInt("type"));
				dto.setEmail(rs.getString("email"));
				dto.setRegdate(rs.getString("regdate"));
				
				list.add(dto);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(conn, ps, rs);
		}
		
		return list;
	}
	public boolean insert(MemberDto dto) {
		String sql="INSERT INTO member(username , type,email) VALUE(?, ?, ?)";
		boolean result = false;
		try {
			conn=getConnection();
			ps=conn.prepareStatement(sql);
			ps.setString(1, dto.getUsername());
			ps.setInt(2, dto.getType());
			ps.setString(3, dto.getEmail());
			ps.execute();
				
			rs=ps.executeQuery();
			if(rs.next()) {
				dto.setMem_no(rs.getInt("mem_no"));
				dto.setPoint(rs.getInt("point"));
				dto.setUsername(rs.getString("username"));
				dto.setType(rs.getInt("type"));
				dto.setEmail(rs.getString("email"));
				dto.setRegdate(rs.getString("regdate"));
			}
			result=ps.executeUpdate()>0;
			
			
		}catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			close(conn, ps, rs);
		}
		return result;
	}
	
	public boolean delete(int mem_no) {
		String sql="DELETE FROM member WHERE mem_no=?";
		boolean result=false;
		try {
			conn=getConnection();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, mem_no);
			
			result=ps.executeUpdate()>0;
			}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(conn, ps, rs);
		}
		return result;
	}
	
	public boolean modify(MemberDto dto) {
		String sql="UPDATE member SET username = ? , email = ? WHERE mem_no=?";
		boolean result = false;
		try {
			conn=getConnection();
			ps=conn.prepareStatement(sql);
			ps.setString(1, dto.getUsername());
			ps.setString(2, dto.getEmail());
			ps.setInt(3, dto.getMem_no());
			
			result=ps.executeUpdate()>0;
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(conn, ps);
		}
		return false;
	}
	
	
	
	
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public Connection getConnection() {
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection(
				"jdbc:mysql://127.0.0.1:3306/studydb?useUnicode=true&characterEncoding=utf8",
				"root", 
				"kmk62616261"
			);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public void close(Connection conn, PreparedStatement ps) {
		close(conn, ps, null);
	}
	
	public void close(Connection conn, PreparedStatement ps, ResultSet rs) {
		try {
			if(rs != null) rs.close();
			if(ps != null) ps.close();
			if(conn != null) conn.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		MemberDao dao=MemberDao.getInstance();
		MemberDto dto=dao.select(3);
		//System.out.println(dto);
		//System.out.println(dao.selectAll());
		
		dto=new MemberDto();
		dto.setEmail("ldkfj");
		dto.setUsername("admin686");
		dto.setMem_no(5);
		//System.out.println(dao.modify(dto));
		
		//System.out.println(dao.insert(dto));
		
		//System.out.println(dao.delete(8));
	}

}
