package Presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import BussinessLogic.CustomerBL;
import BussinessLogic.OrderBL;
import BussinessLogic.ProductBL;
import Entites.Customer;
import Entites.Orderr;
import Entites.Product;

public class Controler {

	private MainFrame mainFrame;
	private ClientView clientView;
	private ProductView productView;
	private OrderView orderView;
	private CustomerBL customerBL;
	private OrderBL orderBL;
	private ProductBL productBL;

	public Controler(MainFrame mainFrame, CustomerBL customerBL, OrderBL orderBL, ProductBL productBL) {
		this.mainFrame = mainFrame;
		this.customerBL = customerBL;
		this.productBL = productBL;
		this.orderBL = orderBL;

		mainFrame.addBtnClientListener(new ViewClientActionListener());
		mainFrame.addBtnCloseListener(new CloseMainActionListener());
		mainFrame.addBtnOrderListener(new ViewOrderActionListener());
		mainFrame.addBtnProductListener(new ViewProductActionListener());

	}

	public void setVisible() {
		mainFrame.setVisible();
	}

	public class CloseMainActionListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			mainFrame.setInvisible();

		}

	}

	public class CloseClientActionListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			clientView.setInvisible();
			mainFrame.setVisible();

		}

	}

	public class AddClientActionListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			Customer c = new Customer();
			c.setName(clientView.getName());
			c.setAddress(clientView.getAddress());
			c.setPhoneNr(clientView.getPhoneNr());
			try {
				customerBL.insert(c);
				clientView.addCustomer(c);
				clientView.emptyFields();
			} catch (Exception ex) {
				clientView.errorMessage();
			}
		}

	}

	public class DeleteClientActionListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			Customer c = clientView.removeRow();
			c.setId(customerBL.getId(c.getName(), c.getAddress(), c.getPhoneNr()));
			customerBL.delete(c);

		}

	}

	public class UpdateClientActionListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			Customer c = clientView.getSelectedRow();
			c.setId(customerBL.getId(c.getName(), c.getAddress(), c.getPhoneNr()));
			if (clientView.getName() != null) {
				c.setName(clientView.getName());
			}
			if (clientView.getAddress() != null) {
				c.setAddress(clientView.getAddress());
			}

			if (clientView.getPhoneNr() != null) {
				c.setPhoneNr(clientView.getPhoneNr());
			}

			System.out.println(c.getPhoneNr());
			try {
				customerBL.update(c);
				clientView.updateTable();
				clientView.emptyFields();
			} catch (Exception e1) {
				e1.printStackTrace();
				clientView.errorMessage();
			}

		}

	}

	public class AddProductActionListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			Product p = new Product();
			p.setName(productView.getName());
			p.setPrice(productView.getPrice());
			p.setQuantity(productView.getQuantity());
			try {
				productBL.insert(p);
				productView.addProduct(p);
				productView.emptyFields();
			} catch (Exception ex) {
				clientView.errorMessage();
			}
		}

	}

	public class DeleteProductActionListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			Product p = productView.removeRow();
			productBL.getId(p.getName(), p.getPrice(), p.getQuantity());
			productBL.delete(p);

		}

	}

	public class UpdateProductActionListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			Product p = productView.getSelectedRow();
			p.setId(productBL.getId(p.getName(), p.getPrice(), p.getQuantity()));
			if (productView.getName() != null) {
				p.setName(productView.getName());
			}
			if (productView.getPrice() != -1) {
				p.setPrice(productView.getPrice());
			}

			if (productView.getQuantity() != -1) {
				p.setQuantity(productView.getQuantity());
			}

			productBL.update(p);
			productView.updateTable();
			productView.emptyFields();

		}

	}

	public class CloseProductActionListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			productView.setInvisible();
			mainFrame.setVisible();

		}

	}

	public class CloseOrderActionListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			orderView.setInvisible();
			mainFrame.setVisible();
		}

	}

	public class ViewClientActionListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			clientView = new ClientView(customerBL.findAll());
			clientView.addBtnAddListener(new AddClientActionListener());
			clientView.addBtnCloseListener(new CloseClientActionListener());
			clientView.addBtnDeleteListener(new DeleteClientActionListener());
			clientView.addBtnUpdateListener(new UpdateClientActionListener());

			mainFrame.setInvisible();
			clientView.setVisible();
		}

	}

	public class ViewProductActionListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			productView = new ProductView(productBL.findAll());
			productView.addBtnAddListener(new AddProductActionListener());
			productView.addBtnCloseListener(new CloseProductActionListener());
			productView.addBtnDeleteListener(new DeleteProductActionListener());
			productView.addBtnUpdateListener(new UpdateProductActionListener());

			mainFrame.setInvisible();
			productView.setVisible();
		}

	}

	public class ViewOrderActionListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			orderView = new OrderView(customerBL.findAll(), productBL.findAll());
			orderView.addBtnOrderListener(new NewOrderActionListener());
			orderView.addBtnCloseListener(new CloseOrderActionListener());
			mainFrame.setInvisible();
			orderView.setVisible();
		}

	}

	public class NewOrderActionListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			Customer c = orderView.getSelectedRowCustomer();
			c.setId(customerBL.getId(c.getName(), c.getAddress(), c.getPhoneNr()));
			Product p = orderView.getSelectedRowProduct();
			System.out.println(p.getName() + " " + p.getPrice() + " " + p.getQuantity());
			p.setId(productBL.getId(p.getName(), p.getPrice(), p.getQuantity()));
			int q = orderView.getQuantity();
			if (q != -1) {
				Orderr o = new Orderr();
				o.setIdCustomer(c.getId());
				o.setIdProduct(p.getId());
				o.setQunatity(q);
				o.setPrice(p.getPrice() * q);
				try {
					orderBL.insert(o);
					orderView.updateStock();
					orderView.succesMessage();
				} catch (Exception e1) {
					e1.printStackTrace();
					orderView.errorMessage();
				}
			}

		}

	}

}
