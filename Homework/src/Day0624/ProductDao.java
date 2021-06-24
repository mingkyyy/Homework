package Day0624;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {
	private static ProductDao instance;
	private ProductDao() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static ProductDao getInstance() {
		if(instance == null) {
			instance = new ProductDao();
		}
		return instance;
	}
	
	
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public ProductDto select(int pd_no) {
		String sql="SELECT pd_no, pd_name , pd_price FROM product WHERE pd_no=?";
		ProductDto dto = null;
		try {
			conn=getConnection();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, pd_no);
			rs=ps.executeQuery();
			if(rs.next()) {
				dto=new ProductDto();
				dto.setPd_no(rs.getInt("pd_no"));
				dto.setPd_name(rs.getString("pd_name"));
				dto.setPd_price(rs.getInt("pd_price"));
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(conn, ps, rs);
		}
		return dto;
		
	}
	  public List<ProductDto> selectAll(){
		  String sql="SELECT pd_no, pd_name , pd_price FROM product ";
		  ArrayList<ProductDto> list = new ArrayList<ProductDto>();
		  ProductDto dto = null;
		  try {
			  conn=getConnection();
			  ps=conn.prepareStatement(sql);
			  rs=ps.executeQuery();
			  while(rs.next()) {
				  dto=new ProductDto();
				  dto.setPd_no(rs.getInt("pd_no"));
				  dto.setPd_name(rs.getString("pd_name"));
				  dto.setPd_price(rs.getInt("pd_price"));
				  
				  list.add(dto);
			  }
			 
		  }catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(conn, ps, rs);
		}
		  return list;
	  }
	  
	  public boolean insert(ProductDto dto) {
		  String sql="INSERT INTO product (pd_name , pd_price) VALUES (?, ?)";
		  boolean result = false;
		  try {
			  conn=getConnection();
			  ps=conn.prepareStatement(sql);
			  ps.setString(1, dto.getPd_name());
			  ps.setInt(2, dto.getPd_price());
			  
			  ps.execute();
			  rs=ps.executeQuery();
			  if(rs.next()) {
				  dto.setPd_no(rs.getInt("pd_no"));
				  dto.setPd_name(rs.getString("pd_name"));
				  dto.setPd_price(rs.getInt("pd_price"));
			  }
			  result= ps.executeUpdate()>0;
		  }catch (Exception e) {
			
			  e.printStackTrace();
		}finally {
			close(conn, ps, rs);
		}
		  return result;
		  
	  }
	  public boolean delete(int pd_no) {
		  String sql="DELETE FROM product WHERE pd_no=?";
		  boolean result = false;
		  try {
			  conn=getConnection();
			  ps=conn.prepareStatement(sql);
			  ps.setInt(1, pd_no);
			  
			  result=ps.executeUpdate()>0;
			  
		  }catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(conn, ps);
		}
		  return result;
		  
	  }
	  public boolean modify(ProductDto dto) {
		  String sql="UPDATE  product SET pd_name = ? , pd_price=? WHERE pd_no = ?";
		  boolean result = false;
		  try {
			  conn=getConnection();
			  ps=conn.prepareStatement(sql);
			  ps.setString(1,dto.getPd_name());
			  ps.setInt(2, dto.getPd_price());
			  ps.setInt(3, dto.getPd_no());
			  
			  result= ps.executeUpdate()>0;
		  }catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(conn, ps);
		}
		  return result;
	  }
	  public List<ProductDto> selectProduct(int mem_no){
		  //해당 회원(mem_no)이 담은 상품 리스트를 ArrayList에 담아 return 
		  String sql="SELECT product.pd_name, product.pd_price, product.pd_no\r\n"
		  		+ "FROM cart\r\n"
		  		+ "INNER JOIN member ON cart.mem_no = member.mem_no \r\n"
		  		+ "INNER JOIN product ON cart.pd_no = product.pd_no\r\n"
		  		+ "WHERE cart.mem_no = ?";
		  ArrayList<ProductDto> list = new ArrayList<>();
		  ProductDto dto = null;
		  
		  try {
			  conn=getConnection();
			  ps=conn.prepareStatement(sql);
			  ps.setInt(1, mem_no);
			  
			  rs=ps.executeQuery();
			  while(rs.next()) {
				  dto=new ProductDto();
				  dto.setPd_no(rs.getInt("pd_no"));
				  dto.setPd_price(rs.getInt("pd_price"));
				  dto.setPd_name(rs.getString("pd_name"));
				  list.add(dto);
				  
			  }
			  
		  }catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(conn, ps, rs);
		}
		  return list;
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
			ProductDao dao=ProductDao.getInstance();
			//ProductDto dto =dao.select(1);
			//System.out.println(dto);
			//System.out.println(dao.selectAll());
			//dto=new ProductDto();
			//dto.setPd_name("product66");
			//dto.setPd_price(5000);
			//System.out.println(dao.insert(dto));
			
			//System.out.println(dao.delete(1));
			//ProductDto dto=new ProductDto();
			//dto.setPd_name("dfdf");
			//dto.setPd_price(80000);
			//dto.setPd_no(2);
			//System.out.println(dao.modify(dto));
			System.out.println(dao.selectProduct(10));
		}
}

