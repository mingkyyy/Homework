package Day0624;



public class MemberDto {
	private int memberNo;
	private String username;
	private int point;
	private int type;
	private String email;
	private String regdate;
	//생성자 만들꺼면 기본 생성자 꼭 만들어야 함
	
	
	public int getMem_no() {
		return memberNo;
	}
	
	public void setMem_no(int mem_no) {
		this.memberNo = mem_no;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public int getPoint() {
		return point;
	}
	
	public void setPoint(int point) {
		this.point = point;
	}
	
	public int getType() {
		return type;
	}
	
	public void setType(int type) {
		this.type = type;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getRegdate() {
		return regdate;
	}
	
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "MemberDto [memberNo=" + memberNo + ", username=" + username + ", point=" + point + ", type=" + type
				+ ", email=" + email + ", regdate=" + regdate + "]";
	}
	
	

}