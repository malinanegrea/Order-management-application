package BussinessLogic;

import java.util.List;
import java.util.NoSuchElementException;

import BussinessLogic.Validators.ClientValidator;
import DataAcces.CustomerDAL;
import Entites.Customer;

public class CustomerBL {

	private CustomerDAL customerDAO;

	public CustomerBL() {
		customerDAO = new CustomerDAL();

	}

	public Customer findCustomerById(int id) {
		Customer cs = customerDAO.findById(id);
		if (cs == null) {
			throw new NoSuchElementException("The customer with id =" + id + " was not found!");
		}
		return cs;

	}

	public List<Customer> findAll() {
		List<Customer> cs = customerDAO.findAll();
		if (cs == null) {
			throw new NoSuchElementException("No customer found!");
		}
		return cs;

	}

	public void insert(Customer c) throws Exception {
		if (ClientValidator.phoneNrValidator(c)) {
			Customer cs = customerDAO.insert(c);
			if (cs == null) {
				throw new NoSuchElementException("Couldn't insert!");
			}
		} else {
			throw new Exception("Wrong phone nr");
		}
	}

	public void delete(Customer c) {
		Customer cs = customerDAO.delete(c);
		if (cs == null) {
			throw new NoSuchElementException("Couldn't delete!");
		}
	}

	public void update(Customer c) throws Exception {
		if (ClientValidator.phoneNrValidator(c)) {
			Customer cs = customerDAO.update(c);
			if (cs == null) {
				throw new NoSuchElementException("Couldn't update!");
			}
		} else {
			throw new Exception("Wrong phone nr");
		}
		
	}

	public int getId(String name, String address, String phoneNr) {
		int id = customerDAO.selectId(name, address, phoneNr);
		return id;
	}

}
