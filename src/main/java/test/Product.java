package test;

public class Product {
	private int id;
	private String name;
	private int price;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", price=" + price +", id=" + id + "]";
	}

	public Product(int id,String name, int price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}

}
