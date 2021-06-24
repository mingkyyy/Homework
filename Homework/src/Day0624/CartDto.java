package Day0624;

public class CartDto {
	private int ctNo;
	private int memNO;
	private int pdNO;

	public int getctNo() {
		return ctNo;
	}

	public void setctNo(int ctNo) {
		this.ctNo = ctNo;
	}

	public int getMemNO() {
		return memNO;
	}

	public void setMemNO(int memNO) {
		this.memNO = memNO;
	}

	public int getPdNO() {
		return pdNO;
	}

	public void setPdNO(int pdNO) {
		this.pdNO = pdNO;
	}

	@Override
	public String toString() {
		return "CartDto [ctNo=" + ctNo + ", memNO=" + memNO + ", pdNO=" + pdNO + "]";
	}
	
	

}