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

public class ProductView {

	JFrame frame;
	JTable table;
	JButton add;
	JButton delete;
	JButton update;
	JTextField name = null;
	JTextField price = null;
	JTextField quantity = null;
	JButton close;
	DefaultTableModel model;

	public ProductView(List<Product> products) {
		frame = new JFrame();
		frame.getContentPane().setLayout(null);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(700, 500);
		frame.setLocationRelativeTo(null);

		table = new JTable();
		table.setBounds(10, 20, 400, 400);
		frame.getContentPane().add(table);

		JLabel nameLabel = new JLabel("Name");
		nameLabel.setBounds(430, 20, 170, 25);
		frame.getContentPane().add(nameLabel);

		name = new JTextField();
		name.setBounds(430, 60, 170, 25);
		frame.getContentPane().add(name);
		name.setText(null);

		JLabel priceLabel = new JLabel("Price");
		priceLabel.setBounds(430, 95, 170, 25);
		frame.getContentPane().add(priceLabel);

		price = new JTextField();
		price.setBounds(430, 130, 170, 25);
		frame.getContentPane().add(price);
		price.setText(null);

		JLabel quantityLabel = new JLabel("Quantity");
		quantityLabel.setBounds(430, 165, 170, 25);
		frame.getContentPane().add(quantityLabel);

		quantity = new JTextField();
		quantity.setBounds(430, 200, 170, 25);
		frame.getContentPane().add(quantity);
		quantity.setText(null);

		add = new JButton("Create");
		add.setBounds(430, 250, 150, 25);
		frame.getContentPane().add(add);

		delete = new JButton("Delete");
		delete.setBounds(430, 285, 150, 25);
		frame.getContentPane().add(delete);

		update = new JButton("Update");
		update.setBounds(430, 320, 150, 25);
		frame.getContentPane().add(update);

		close = new JButton("Close");
		close.setBounds(500, 400, 130, 25);
		frame.getContentPane().add(close);

		model = (DefaultTableModel) table.getModel();
		ReflectionTable.setTabel(products, model);
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

	public void addBtnAddListener(ActionListener e) {
		add.addActionListener(e);
	}

	public void addBtnDeleteListener(ActionListener e) {
		delete.addActionListener(e);

	}

	public void addBtnUpdateListener(ActionListener e) {
		update.addActionListener(e);
	}

	public String getName() {
		if (!name.getText().equals("")) {
			return name.getText();
		} else
			return null;
	}

	public int getQuantity() {
		if (!quantity.getText().equals("")) {
			return Integer.parseInt(quantity.getText());
		} else {
			return -1;
		}
	}

	public float getPrice() {
		if (price.getText().equals("")) {
			return -1;
		} else {
			return Float.parseFloat(price.getText());
		}

	}

	public Product getSelectedRow() {
		int s = table.getSelectedRow();
		Product c = new Product();
		c.setId((Integer) table.getValueAt(s, 0));
		c.setName((String) table.getValueAt(s, 1));
		c.setQuantity((Integer) table.getValueAt(s, 3));
		c.setPrice((Float) table.getValueAt(s, 2));
		return c;
	}

	public Product removeRow() {
		Product p = getSelectedRow();
		model.removeRow(table.getSelectedRow());
		return p;
	}

	public void errorMessage() {
		JOptionPane.showMessageDialog(frame, "Error", "Error", JOptionPane.ERROR_MESSAGE);
	}

	public void updateTable() {
		int s = table.getSelectedRow();
		if (!name.getText().equals("")) {
			model.setValueAt(getName(), s, 1);
		}
		if (getPrice() != -1) {
			model.setValueAt(getPrice(), s, 2);
		}
		if (getQuantity() != -1) {
			model.setValueAt(getQuantity(), s, 3);
		}
		emptyFields();
	}

	public void emptyFields() {
		name.setText("");
		price.setText("");
		quantity.setText("");
	}
	public void addProduct(Product p) {
		ReflectionTable.addRow(p, model);
	}
}
