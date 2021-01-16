public class Item {
	private String name;
	private int buyPrice;
	private int sellPrice;
	private String custName;
	
	public Item(String name, int buyPrice, int sellPrice) {
		this.name = name;
		this.buyPrice = buyPrice;
		this.sellPrice = sellPrice;
	}
	
	public Item(String name, int sellPrice, String custName) {
		this.name = name;
		this.sellPrice = sellPrice;
		this.custName = custName;
	}
	
	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getName() {
		return name;
	}
	
	public int getBuyPrice() {
		return buyPrice;
	}
	
	public int getSellPrice() {
		return sellPrice;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setBuyPrice(int buyPrice) {
		this.buyPrice = buyPrice;
	}
	
	public void setSellPrice(int sellPrice) {
		this.sellPrice = sellPrice;
	}

	public String toString() {
		return "Item [name=" + name + ", sellPrice=" + sellPrice + "]";
	}	
}
