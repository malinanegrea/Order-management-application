package BussinessLogic;

import java.io.PrintWriter;
import java.util.List;
import java.util.NoSuchElementException;

import BussinessLogic.Validators.OrderValidator;
import DataAcces.OrderDAL;
import Entites.Customer;
import Entites.Orderr;
import Entites.Product;

public class OrderBL {

	private OrderDAL orderDAO;
	private ProductBL productBL;
	private CustomerBL customerBL;
	private int billNr;

	public OrderBL(ProductBL productBL, CustomerBL customerBL) {
		orderDAO = new OrderDAL();
		this.productBL = productBL;
		this.customerBL = customerBL;
		billNr=0;
	}

	public Orderr findOrderById(int id) {
		Orderr cs = orderDAO.findById(id);
		if (cs == null) {
			throw new NoSuchElementException("The Order with id =" + id + " was not found!");
		}
		return cs;

	}

	public List<Orderr> findAll() {
		List<Orderr> cs = orderDAO.findAll();
		if (cs == null) {
			throw new NoSuchElementException("No Order found!");
		}
		return cs;

	}

	public void insert(Orderr o) throws Exception {
		if (OrderValidator.stocValidator(productBL.findAll(), o)) {
			Product p = productBL.findProductById(o.getIdProuct());
			p.setQuantity(p.getQuantity()-o.getQuantity());
			productBL.update(p);
			Orderr cs = orderDAO.insert(o);
			if (cs == null) {
				throw new NoSuchElementException("Couldn't insert");
			}
			billNr++;
			String fileName = "BillNr"+ billNr;
			PrintWriter writer = new PrintWriter(fileName, "UTF-8");
			writer.println("Client 		Product		Quantity	Total");
			String cliName = null ;
			for(Customer c: customerBL.findAll()) {
				if(c.getId() == o.getIdCustomer()) {
					cliName=c.getName();
				}
			}
			String proName = null ;
			for(Product prod: productBL.findAll()) {
				if(prod.getId() == o.getIdProuct()) {
					proName=prod.getName();
				}
			}
			writer.println(cliName +"	 "+proName + " 		"+ o.getQuantity()+"     	 "+o.getPrice());
			writer.close();
		}
		else throw new Exception("Not enough stock!");
	}

	public void delete(Orderr c) {
		Orderr cs = orderDAO.delete(c);
		if (cs == null) {
			throw new NoSuchElementException("Couldn't delete!");
		}
	}

	public void update(Orderr c) {
		Orderr cs = orderDAO.update(c);
		if (cs == null) {
			throw new NoSuchElementException("Couldn't update!");
		}
	}

}
