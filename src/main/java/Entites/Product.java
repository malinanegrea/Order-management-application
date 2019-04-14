package Entites;

public class Product {

	int id;
	String name;
	float price;
	int quantity;
	
	public Product() {
		
	}

	public Product(int id, String name, float price, int quantuty) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantuty;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public float getPrice() {
		return price;

	}

	public int getQuantity() {
		return quantity;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
