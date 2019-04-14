package BussinessLogic;

import java.util.List;
import java.util.NoSuchElementException;

import DataAcces.ProductDAL;
import Entites.Product;

public class ProductBL {

	private ProductDAL productDAO;

	public ProductBL() {
		productDAO = new ProductDAL();

	}

	public Product findProductById(int id) {
		Product cs = productDAO.findById(id);
		if (cs == null) {
			throw new NoSuchElementException("The Product with id =" + id + " was not found!");
		}
		return cs;

	}

	public List<Product> findAll() {
		List<Product> cs = productDAO.findAll();
		if (cs == null) {
			throw new NoSuchElementException("No Product found!");
		}
		return cs;

	}

	public void insert(Product c) {
		Product cs = productDAO.insert(c);
		if (cs == null) {
			throw new NoSuchElementException("Couldn't insert");
		}
	}

	public void delete(Product c) {
		Product cs = productDAO.delete(c);
		if (cs == null) {
			throw new NoSuchElementException("Couldn't delete!");
		}
	}

	public void update(Product c) {
		Product cs = productDAO.update(c);
		if (cs == null) {
			throw new NoSuchElementException("Couldn't update!");
		}
	}
	public int getId(String name,float price, int quantity) {
		int id = productDAO.selectId(name, price, quantity);
		return id;
	}
}
