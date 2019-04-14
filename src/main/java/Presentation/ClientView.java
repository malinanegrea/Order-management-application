package Presentation;

import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Entites.Customer;

public class ClientView {

	JFrame frame;
	JTable table;
	JButton add;
	JButton delete;
	JButton update;
	JTextField name = null;
	JTextField address =null;
	JTextField phone = null;
	JButton close;
	DefaultTableModel model;

	public ClientView(List<Customer> clients) {
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

		JLabel addressLabel = new JLabel("Address");
		addressLabel.setBounds(430, 95, 170, 25);
		frame.getContentPane().add(addressLabel);

		address = new JTextField();
		address.setBounds(430, 130, 170, 25);
		frame.getContentPane().add(address);

		JLabel phoneNreLabel = new JLabel("Phone number");
		phoneNreLabel.setBounds(430, 165, 170, 25);
		frame.getContentPane().add(phoneNreLabel);

		phone = new JTextField();
		phone.setBounds(430, 200, 170, 25);
		frame.getContentPane().add(phone);

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

		model= (DefaultTableModel) table.getModel();
		ReflectionTable.setTabel(clients,model );
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
	
	public Customer getSelectedRow() {
		int s= table.getSelectedRow();
		Customer c = new Customer();
		c.setId((Integer) table.getValueAt(s, 0));
		c.setName((String) table.getValueAt(s, 1));
		c.setPhoneNr((String) table.getValueAt(s, 3));
		c.setAddress((String) table.getValueAt(s, 2));
		return c;
	}
	
	public Customer removeRow() {
		Customer c= getSelectedRow();
		model.removeRow(table.getSelectedRow());
		return c;
	}
	
	public String getAddress() {
		if (!address.getText().equals("")) {
			return address.getText();
		} else
			return null;
	}
	
	public String getPhoneNr() {
		if (!phone.getText().equals("")) {
			return phone.getText();
		} else
			return null;
	}
	
	public void errorMessage() {
		JOptionPane.showMessageDialog(frame, "Error", "Error",
				JOptionPane.ERROR_MESSAGE);
	}
	public void updateTable() {
		int s= table.getSelectedRow();
		if(getName()!=null) {
			model.setValueAt(getName(), s,1);
		}
		if(getAddress()!=null) {
			model.setValueAt(getAddress(), s, 2);
		}
		if(getPhoneNr()!=null) {
			model.setValueAt(getPhoneNr(), s, 3);
		}

	}
	public void addCustomer(Customer c) {
		ReflectionTable.addRow(c, model);
	}
	public void emptyFields() {
		name.setText("");
		address.setText("");
		phone.setText("");
	}

}