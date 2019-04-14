package Entites;

public class Customer {
	int id;
	String name;
	String address;
	String phoneNr;

	public Customer() {
		
	}
	public Customer(int id, String name, String address, String phoneNr) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.phoneNr = phoneNr;

	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public String getPhoneNr() {
		return phoneNr;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public void setPhoneNr(String phoneNr) {
		this.phoneNr = phoneNr;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
