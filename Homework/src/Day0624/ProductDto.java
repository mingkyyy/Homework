package Day0624;


public class ProductDto {
	private int pd_no;
	private String pd_name;
	private int pd_price;
	
	public int getPd_no() {
		return pd_no;
	}
	
	public void setPd_no(int pd_no) {
		this.pd_no = pd_no;
	}
	
	public String getPd_name() {
		return pd_name;
	}
	
	public void setPd_name(String pd_name) {
		this.pd_name = pd_name;
	}
	
	public int getPd_price() {
		return pd_price;
	}
	
	public void setPd_price(int pd_price) {
		this.pd_price = pd_price;
	}

	@Override
	public String toString() {
		return "ProductDto [pd_no=" + pd_no + ", pd_name=" + pd_name + ", pd_price=" + pd_price + "]";
	}

	
	

}