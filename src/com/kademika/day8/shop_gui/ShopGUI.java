package com.kademika.day8.shop_gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ShopGUI {

	private Shop shop;
	private JTextField textFieldName;
	private JTextField textFieldSurname;

	public ShopGUI(Shop shop) {
		this.shop = shop;

		JFrame f = new JFrame("Car Shop 1.0");

		f.setLocation(100, 100);
		f.setMinimumSize(new Dimension(240, 240));
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		f.getContentPane().add(createSellingPanel());

		f.pack();
		f.setVisible(true);
	}

	private JPanel createSellingPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());

		JLabel labelName = new JLabel("Customer Name:");
		panel.add(labelName, new GridBagConstraints(0, 0, 1, 1, 0, 0,
				GridBagConstraints.LINE_START, 0, new Insets(0, 0, 0, 0), 0, 0));

		textFieldName = new JTextField(); /////////////////////////// final ??? //shoul be global var
		textFieldName.setColumns(11);
		panel.add(textFieldName, new GridBagConstraints(1, 0, 1, 1, 0, 0,
				GridBagConstraints.LINE_START, 0, new Insets(0, 0, 0, 0), 0, 0));
		
		JLabel labelSurame = new JLabel("Customer Surname:");
		panel.add(labelSurame, new GridBagConstraints(0, 1, 1, 1, 0, 0,
				GridBagConstraints.LINE_START, 0, new Insets(0, 0, 0, 0), 0, 0));

		textFieldSurname = new JTextField(); ////////////////////////////////////////// final ???
		textFieldSurname.setColumns(11);
		panel.add(textFieldSurname, new GridBagConstraints(1, 1, 1, 1, 0, 0,
				GridBagConstraints.LINE_START, 0, new Insets(0, 0, 0, 0), 0, 0));

		JLabel labelPhoneNumber = new JLabel("Phone number:");
		panel.add(labelPhoneNumber, new GridBagConstraints(0, 2, 1, 1, 0, 0,
				GridBagConstraints.LINE_START, 0, new Insets(0, 0, 0, 0), 0, 0));

		final JTextField textFieldPhoneNumber = new JTextField("+380"); /////////////////////////////// final ???
		textFieldPhoneNumber.setColumns(11);
		panel.add(textFieldPhoneNumber, new GridBagConstraints(1, 2, 1, 1, 0, 0, 
				GridBagConstraints.LINE_START, 0, new Insets(0, 0, 0, 0), 0, 0));

		JLabel labelDate = new JLabel("Date:");
		panel.add(labelDate, new GridBagConstraints(0, 3, 1, 1, 0, 0,
				GridBagConstraints.LINE_START, 0, new Insets(0, 0, 0, 0), 0, 0));
		
		Date today = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy kk:mm:ss");
		final JFormattedTextField textFieldDate = new JFormattedTextField(dateFormat.format(today)); // final ???
		textFieldDate.setColumns(11);
		panel.add(textFieldDate, new GridBagConstraints(1, 3, 1, 1, 0, 0,
				GridBagConstraints.LINE_START, 0, new Insets(0, 0, 0, 0), 0, 0));
		
		
		JLabel labelCar = new JLabel("Car:");
		panel.add(labelCar, new GridBagConstraints(0, 4, 1, 1, 0, 0,
				GridBagConstraints.LINE_START, 0, new Insets(0, 0, 0, 0), 0, 0));

		final Car[] products = shop.getGarage(); ///////////////////////////////////////////////////// final ???
		final JComboBox productsList = new JComboBox(products); ////////////////////////////////////// final ???
		panel.add(productsList, new GridBagConstraints(1, 4, 1, 1, 0, 0,
				GridBagConstraints.LINE_START, 0, new Insets(0, 0, 0, 0), 0, 0));
		
		JButton buyButton = new JButton("Buy");
		panel.add(buyButton, new GridBagConstraints(1, 5, 1, 1, 0, 0,
				GridBagConstraints.LINE_START, 0, new Insets(0, 0, 0, 0), 5, 5));
		
		JButton transListButton = new JButton("See transactions");
		panel.add(transListButton, new GridBagConstraints(1, 6, 1, 1, 0, 0,
				GridBagConstraints.LINE_START, 0, new Insets(0, 0, 0, 0), 0, 0));
		
		JButton inStockButton = new JButton("In Stock");
		panel.add(inStockButton, new GridBagConstraints(2, 6, 1, 1, 0, 0,
				GridBagConstraints.LINE_START, 0, new Insets(0, 0, 0, 0), 0, 0));
		
		JButton priceListButton = new JButton("Price List");
		panel.add(priceListButton, new GridBagConstraints(3, 6, 1, 1, 0, 0,
				GridBagConstraints.LINE_START, 0, new Insets(0, 0, 0, 0), 0, 0));
		
		buyButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = textFieldName.getText(); //////////////////////////// Change modifier to final
				String surname = textFieldSurname.getText(); ////////////////////// Change modifier to final
				String phone = textFieldPhoneNumber.getText(); //////////////////// Change modifier to final
				
				Customer customer = new Customer(name, surname, phone);
				
				Car car = products[productsList.getSelectedIndex()]; ////////////// Change modifier to final
				
				String date = textFieldDate.getText(); //////////////////////////// Change modifier to final

				shop.sell(date, car, customer);
			}
		});
		
		transListButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				shop.outTransactionsList();
			}
		});
		
		inStockButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				shop.inStock();
			}
		});
		
		priceListButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				shop.getPriceList();
			}
		});
		
		return panel;
	}

}
