package Entites;

public class Orderr {

	int id;
	int idCustomer;
	int idProduct;
	int quantity;
	float price;

	public Orderr() {

	}

	public Orderr(int id, int idCustomer, int idProduct, int quantity, float price) {
		this.id = id;
		this.idCustomer = idCustomer;
		this.idProduct = idProduct;
		this.quantity = quantity;
		this.price = price;
	}

	public int getId() {
		return id;

	}

	public int getIdCustomer() {
		return idCustomer;

	}

	public int getIdProuct() {
		return idProduct;

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

	public void setIdCustomer(int id) {
		this.idCustomer = id;
	}

	public void setIdProduct(int id) {
		this.idProduct = id;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public void setQunatity(int quantity) {
		this.quantity = quantity;
	}
}
