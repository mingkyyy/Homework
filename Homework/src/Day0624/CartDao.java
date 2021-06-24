package Day0624;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * cart DB의 dao 
 * new CartDao(); 대신
 * CartDao.getInstance() 를 사용하세요.
 */
public class CartDao {
	private static CartDao instance;
	private CartDao() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static CartDao getInstance() {
		if(instance == null) {
			instance = new CartDao();
		}
		return instance;
	}
	
	
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	/**
	 * 
	 * @param ctNo cart 의 pk (int)
	 * @return ctNo번 레코드의 정보를 담은 CartDto 인스턴스
	 */
	public CartDto select(int ctNo) {
		String sql = 
				"SELECT ct_no, pd_no, mem_no FROM cart WHERE ct_no = ?";
		CartDto dto = null;
		try {
			conn = getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, ctNo);
			rs = ps.executeQuery();
			if(rs.next()) {
				dto = new CartDto();
				dto.setctNo(rs.getInt("ct_no"));
				dto.setPdNO(rs.getInt("pd_no"));
				dto.setMemNO(rs.getInt("mem_no"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, ps, rs);
		}
		return dto;
	}
	
	/**
	 * Cart의 모든 레코드들을 각각 Dto들에 담아서 
	 * Dto들을 ArrayList에 모두 담고 
	 * 이 ArrayList 를 반환
	 * @return ArrayList (모든 레코드)
	 */
	public List<CartDto> selectAll(){
		String sql="SELECT ct_no, pd_no, mem_no FROM cart";
	    ArrayList<CartDto> list = new ArrayList<CartDto>();
	    CartDto dto= null;
	    try {
	    	conn=getConnection();
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				dto = new CartDto();
				dto.setctNo(rs.getInt("ct_no"));
				dto.setPdNO(rs.getInt("pd_no"));
				dto.setMemNO(rs.getInt("mem_no"));
				
				list.add(dto);
			}
			
	    	
	    }catch (Exception e) {
	    	e.printStackTrace();
			
		}finally {
			close(conn, ps, rs);
			
		}
		return list;
	}
	
	
	/**
	 * 현재 장바구니 레코드에서 해당 상품이 얼마나 있는지 조회
	 * @param pdNo
	 * @return 
	 */
	public List<CartDto> selectAllByPdNo(int pdNo){
		String sql = "SELECT ct_no, pd_no, mem_no FROM cart WHERE pd_no = ?";
		ArrayList<CartDto> list = new ArrayList<>();
		CartDto dto=null;
		 try {
		    	conn=getConnection();
				ps=conn.prepareStatement(sql);
				ps.setInt(1, pdNo);
				rs=ps.executeQuery();			
				while(rs.next()) {
					dto = new CartDto();
					dto.setctNo(rs.getInt("ct_no"));
					dto.setPdNO(rs.getInt("pd_no"));
					dto.setMemNO(rs.getInt("mem_no"));
					
					list.add(dto);
				}
				
		    	
		    }catch (Exception e) {
		    	e.printStackTrace();
				
			}finally {
				close(conn, ps, rs);
				
			}
			return list;
		
		
	}
	
	/**
	 * 현재 장바구니 레코드에서 해당 회원이 얼마나 있는지 조회
	 * @param memNo
	 * @return
	 */
	public List<CartDto> selectAllByMemNo(int memNo){
		String sql="SELECT ct_no, pd_no, mem_no FROM cart WHERE mem_no = ?";
		ArrayList<CartDto> list = new ArrayList<>();
		CartDto dto=null;
		 try {
		    	conn=getConnection();
				ps=conn.prepareStatement(sql);
				ps.setInt(1, memNo);
				rs=ps.executeQuery();			
				while(rs.next()) {
					dto = new CartDto();
					dto.setctNo(rs.getInt("ct_no"));
					dto.setPdNO(rs.getInt("pd_no"));
					dto.setMemNO(rs.getInt("mem_no"));
					
					list.add(dto);
				}
				
		    	
		    }catch (Exception e) {
		    	e.printStackTrace();
				
			}finally {
				close(conn, ps, rs);
				
			}
			return list;
		
	}
	
	
	
	/**
	 * 레코드 추가 
	 * @param dto insert할 내용이 담겨있는 dto 인스턴스
	 * @return 성공하면 true, 예외발생하면 false
	 */
	public boolean insert(CartDto dto) {
		String sql="INSERT INTO Cart(mem_no, pd_no) VALUES (? , ?)";
		boolean result = false;
		try {
			conn=getConnection();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, dto.getMemNO());
			ps.setInt(2, dto.getPdNO());
			
			ps.execute();
			rs=ps.executeQuery();
			if(rs.next()) {
				dto.setctNo(rs.getInt("ct_no"));
				dto.setMemNO(rs.getInt("mem_no"));
				dto.setPdNO(rs.getInt("pd_no"));
				
			}
			result=ps.executeUpdate()>0;
			
			
		}catch (Exception e) {
		
		}finally {
			close(conn, ps, rs);
		}
		return result;
		
	}
	
	/**
	 * 레코드 삭제
	 * @param ctNo 삭제할 장바구니 번호 
	 * @return 성공하면 true, 예외발생하면 false
	 */
	public boolean delete(int ctNo) {
		String sql= "DELETE FROM cart WHERE ct_no=? ";
		boolean result = false;
		try{
			
			conn=getConnection();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, ctNo);
			
			result=ps.executeUpdate()>0;			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(conn, ps, rs);
		}		
		return result;
	}
	
	
	/**
	 * 레코드 수정
	 * @param dto 수정할 레코드의 ct_no와,
	 *  수정할 새로운 pd_no, mem_no가 담겨있는 dto 인스턴스
	 * @return 성공하면 true, 예외발생하면 false
	 */
	public boolean update(CartDto dto) {
		String sql="UPDATE cart SET pd_no = ? , mem_no=? WHERE ct_no = ?";
		boolean result = false;
		try {
		conn = getConnection();
		ps = conn.prepareStatement(sql);
		ps.setInt(1, dto.getPdNO());
		ps.setInt(2, dto.getMemNO());
		ps.setInt(3, dto.getctNo());

		result= ps.executeUpdate()>0;
		
		}catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			close(conn, ps);
		}
		return result;
		
	}
	
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
		CartDao dao=CartDao.getInstance();
		CartDto dto =  dao.select(9);
		//System.out.println(dto);
		
		dto = new CartDto();	
		dto.setPdNO(3);
		dto.setMemNO(11);
		dto.setctNo(1);
	    //System.out.println(dao.update(dto));
	    
		//System.out.println(dao.delete(5));
		//System.out.println(dao.selectAll());
		//System.out.println(dao.selectAllByPdNo(3));
		//System.out.println(dao.selectAllByMemNo(1));
		
	}
}

