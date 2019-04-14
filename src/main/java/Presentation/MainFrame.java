package Presentation;

import java.awt.event.ActionListener;

import javax.swing.*;

public class MainFrame {

	JFrame frame;

	JButton viewClient;
	JButton viewProduct;
	JButton newOrder;
	JButton close;

	public MainFrame() {

		frame = new JFrame();
		frame.getContentPane().setLayout(null);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(450, 200);
		frame.setLocationRelativeTo(null);

		viewClient = new JButton("Clients");
		viewClient.setBounds(35, 35, 150, 25);
		frame.getContentPane().add(viewClient);

		viewProduct = new JButton("Products");
		viewProduct.setBounds(210, 35, 150, 25);
		frame.getContentPane().add(viewProduct);

		newOrder = new JButton("New Order");
		newOrder.setBounds(35, 80, 150, 25);
		frame.getContentPane().add(newOrder);

		close = new JButton("Close");
		close.setBounds(210, 80, 150, 25);
		frame.getContentPane().add(close);

	}

	public void setVisible() {
		frame.setVisible(true);
	}

	public void setInvisible() {
		frame.setVisible(false);
	}

	public void addBtnCloseListener(ActionListener e) {
		close.addActionListener(e);
		
	}
	public void addBtnClientListener(ActionListener e) {
		viewClient.addActionListener(e);
	}
	
	public void addBtnProductListener(ActionListener e) {
		viewProduct.addActionListener(e);
		
	}
	public void addBtnOrderListener(ActionListener e) {
		newOrder.addActionListener(e);
	}
	
}
