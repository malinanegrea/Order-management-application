package Presentation;

import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Entites.Customer;
import Entites.Product;

public class OrderView {

	JFrame frame;
	JTable tableClients;
	JTable tableProduct;
	DefaultTableModel modelClients;
	DefaultTableModel modelProduct;
	JButton newOrder;
	JButton close;
	JTextField quantity;

	public OrderView(List<Customer> customers, List<Product> products) {
		frame = new JFrame();
		frame.getContentPane().setLayout(null);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(900, 500);
		frame.setLocationRelativeTo(null);

		tableClients = new JTable();
		tableClients.setBounds(10, 20, 400, 300);
		frame.getContentPane().add(tableClients);
		modelClients = (DefaultTableModel) tableClients.getModel();
		ReflectionTable.setTabel(customers, modelClients);

		tableProduct = new JTable();
		tableProduct.setBounds(430, 20, 400, 300);
		frame.getContentPane().add(tableProduct);
		modelProduct = (DefaultTableModel) tableProduct.getModel();
		ReflectionTable.setTabel(products, modelProduct);

		JLabel qunatityLabel = new JLabel("Quantity");
		qunatityLabel.setBounds(10, 330, 170, 25);
		frame.getContentPane().add(qunatityLabel);

		quantity = new JTextField();
		quantity.setBounds(10, 365, 170, 25);
		frame.getContentPane().add(quantity);

		newOrder = new JButton("New Order");
		newOrder.setBounds(200, 365, 150, 25);
		frame.getContentPane().add(newOrder);

		close = new JButton("Close");
		close.setBounds(720, 400, 130, 25);
		frame.getContentPane().add(close);

	}

	public void errorMessage() {
		JOptionPane.showMessageDialog(frame, "There is not enough product in stock", "Under stock",
				JOptionPane.ERROR_MESSAGE);
	}

	public Product getSelectedRowProduct() {
		int s = tableProduct.getSelectedRow();
		Product c = new Product();
		c.setId((Integer) tableProduct.getValueAt(s, 0));
		c.setName((String) tableProduct.getValueAt(s, 1));
		c.setQuantity((Integer) tableProduct.getValueAt(s, 3));
		c.setPrice((Float) tableProduct.getValueAt(s, 2));
		return c;
	}

	public void setVisible() {
		frame.setVisible(true);
	}

	public void setInvisible() {
		frame.setVisible(false);
		frame.dispose();
	}

	public void addBtnCloseListener(ActionListener e) {
		close.addActionListener(e);

	}

	public void addBtnOrderListener(ActionListener e) {
		newOrder.addActionListener(e);
	}

	public int getQuantity() {
		if (!quantity.getText().equals("")) {
			return Integer.parseInt(quantity.getText());
		} else {
			return -1;
		}
	}

	public Customer getSelectedRowCustomer() {
		int s = tableClients.getSelectedRow();
		Customer c = new Customer();
		c.setId((Integer) tableClients.getValueAt(s, 0));
		c.setName((String) tableClients.getValueAt(s, 1));
		c.setPhoneNr((String) tableClients.getValueAt(s, 3));
		c.setAddress((String) tableClients.getValueAt(s, 2));
		return c;
	}
	
	public void updateStock() {
		int s=tableProduct.getSelectedRow();
		int q =(Integer) modelProduct.getValueAt(s, 3) - getQuantity();
		modelProduct.setValueAt(q, s, 3);
		quantity.setText("");
	}

	public void succesMessage() {
		JOptionPane.showMessageDialog(frame, "Succes", "Succes",
				JOptionPane.PLAIN_MESSAGE);
	}
}
