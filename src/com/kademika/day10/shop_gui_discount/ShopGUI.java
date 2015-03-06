package com.kademika.day10.shop_gui_discount;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.SplashScreen;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class ShopGUI {

	private Shop shop;
	private Car[] products;
	private JFrame frame;
	private JFrame tFrame;
	private JTextField textFieldName;
	private JTextField textFieldSurname;
	private JTextField textFieldPhoneNumber;
	private JFormattedTextField textFieldDate;
	private JComboBox<Object> productsList;
	private JTable transactionsTable;
	
	public ShopGUI(Shop shop) throws Exception {
		
		SplashScreen splash = SplashScreen.getSplashScreen();
		Thread.sleep(1000);
		
		Graphics2D g2d = splash.createGraphics(); //VM arguments(options): -splash:car_shop_splash.png
		g2d.setColor(Color.WHITE);
		g2d.drawString("Car Shop Loading...", 35, 80);
		splash.update();
		
		Thread.sleep(4000);
		splash.close();
		
		this.shop = shop;
		
		//Create and set up the window
		frame = new JFrame("Car Shop 2.1");
		frame.setLocation(100, 100);
		frame.setMinimumSize(new Dimension(1040, 240));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Create and set up the menu items
		JMenuItem menuItemBuyCar = new JMenuItem("Buy Car");
		menuItemBuyCar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				showSellingPanel();
			}
		});
		
		JMenuItem menuItemSeeTransactions = new JMenuItem("See transactions");
		menuItemSeeTransactions.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				showTransactionsListTablePanel();
			}
		});
		
		//Create and set up the menu
		JMenu menuActions = new JMenu("Actions");
		menuActions.add(menuItemBuyCar);
		menuActions.add(menuItemSeeTransactions);
		
		//Create and set up the menu bar
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(menuActions);
		frame.getRootPane().setJMenuBar(menuBar);
		
		//Display the window
		frame.pack();
		frame.setVisible(true);
	}
	
	private void showTransactionsListTablePanel() {
        //Create and set up the window
        tFrame = new JFrame("Transactions List");
        tFrame.setLocation(100, 100);
        tFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        //Create and set up the content pane
        tFrame.setContentPane(createTransactionsListTablePanel());
		
//		frame.getContentPane().removeAll();
//		frame.getContentPane().add(createTransactionsListTablePanel());
//		frame.pack();
//		frame.setVisible(true);

        //Display the window
        tFrame.pack();
        tFrame.setVisible(true);
        
	}
	
	private void showSellingPanel() {
		//frame.getContentPane().removeAll();
		frame.getContentPane().add(createSellingPanel());
		frame.pack();
		frame.setVisible(true);
	}
	
	private JPanel createTransactionsListTablePanel() {
		JPanel tPanel = new JPanel();
		
		String[] columnNames = {"ID"
								, "Date"
								, "Name"
								, "Surname"
								, "Phone"
								, "Body Type"
								, "Brend"
								, "Model"
								, "Price"
								, "Discount"
                                , "Total Price"};
		
		ArrayList<Transaction> transactions = shop.getAllTransactions();
		Object[][] data = new Object[transactions.size()][];
		for (int i = 0; i < transactions.size(); i++ ) {
			Transaction t = transactions.get(i);
			data[i] = new Object[] {t.getId(), t.getDate()
					, t.getCustomer().getName(), t.getCustomer().getSurname(), t.getCustomer().getPhoneNumber()
					, t.getCar().getBodyType(), t.getCar().getBrend(), t.getCar().getModel(), t.getCar().getPrice()
					, t.getDiscount(), t.getTotalPrice()};
		}
		
		transactionsTable = new JTable(data, columnNames);
		transactionsTable.setPreferredScrollableViewportSize(new Dimension(700, 70));
		transactionsTable.getColumnModel().getColumn(1).setPreferredWidth(130);
		transactionsTable.getColumnModel().getColumn(4).setPreferredWidth(110);
		
		 //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(transactionsTable);
        
        //Add the scroll pane to this panel.
        tPanel.add(scrollPane);
        
        return tPanel;
	}

	private JPanel createSellingPanel() {
		JPanel sPanel = new JPanel();
		sPanel.setLayout(new GridBagLayout());

		JLabel labelName = new JLabel("Customer Name:");
		sPanel.add(labelName, new GridBagConstraints(0, 0, 1, 1, 0, 0,
				GridBagConstraints.LINE_START, 0, new Insets(0, 0, 0, 0), 0, 0));

		textFieldName = new JTextField();
		textFieldName.setColumns(11);
		sPanel.add(textFieldName, new GridBagConstraints(1, 0, 1, 1, 0, 0,
				GridBagConstraints.LINE_START, 0, new Insets(0, 0, 0, 0), 0, 0));
		
		JLabel labelSurame = new JLabel("Customer Surname:");
		sPanel.add(labelSurame, new GridBagConstraints(0, 1, 1, 1, 0, 0,
				GridBagConstraints.LINE_START, 0, new Insets(0, 0, 0, 0), 0, 0));

		textFieldSurname = new JTextField();
		textFieldSurname.setColumns(11);
		sPanel.add(textFieldSurname, new GridBagConstraints(1, 1, 1, 1, 0, 0,
				GridBagConstraints.LINE_START, 0, new Insets(0, 0, 0, 0), 0, 0));

		JLabel labelPhoneNumber = new JLabel("Phone number:");
		sPanel.add(labelPhoneNumber, new GridBagConstraints(0, 2, 1, 1, 0, 0,
				GridBagConstraints.LINE_START, 0, new Insets(0, 0, 0, 0), 0, 0));

		textFieldPhoneNumber = new JTextField("+380");
		textFieldPhoneNumber.setColumns(11);
		sPanel.add(textFieldPhoneNumber, new GridBagConstraints(1, 2, 1, 1, 0, 0, 
				GridBagConstraints.LINE_START, 0, new Insets(0, 0, 0, 0), 0, 0));

		JLabel labelDate = new JLabel("Date:");
		sPanel.add(labelDate, new GridBagConstraints(0, 3, 1, 1, 0, 0,
				GridBagConstraints.LINE_START, 0, new Insets(0, 0, 0, 0), 0, 0));
		
		Date today = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy kk:mm:ss");
		textFieldDate = new JFormattedTextField(dateFormat.format(today));
		textFieldDate.setColumns(11);
		sPanel.add(textFieldDate, new GridBagConstraints(1, 3, 1, 1, 0, 0,
				GridBagConstraints.LINE_START, 0, new Insets(0, 0, 0, 0), 0, 0));
		
		
		JLabel labelCar = new JLabel("Car:");
		sPanel.add(labelCar, new GridBagConstraints(0, 4, 1, 1, 0, 0,
				GridBagConstraints.LINE_START, 0, new Insets(0, 0, 0, 0), 0, 0));

		products = shop.getGarage();
		productsList = new JComboBox<Object>(products);
		sPanel.add(productsList, new GridBagConstraints(1, 4, 1, 1, 0, 0,
				GridBagConstraints.LINE_START, 0, new Insets(0, 0, 0, 0), 0, 0));
		
		JButton buyButton = new JButton("Buy");
		sPanel.add(buyButton, new GridBagConstraints(1, 5, 1, 1, 0, 0,
				GridBagConstraints.LINE_START, 0, new Insets(0, 0, 0, 0), 5, 5));
		
		JButton transListButton = new JButton("See transactions");
		sPanel.add(transListButton, new GridBagConstraints(1, 6, 1, 1, 0, 0,
				GridBagConstraints.LINE_START, 0, new Insets(0, 0, 0, 0), 0, 0));
		
		JButton inStockButton = new JButton("In Stock");
		sPanel.add(inStockButton, new GridBagConstraints(2, 6, 1, 1, 0, 0,
				GridBagConstraints.LINE_START, 0, new Insets(0, 0, 0, 0), 0, 0));
		
		JButton priceListButton = new JButton("Price List");
		sPanel.add(priceListButton, new GridBagConstraints(3, 6, 1, 1, 0, 0,
				GridBagConstraints.LINE_START, 0, new Insets(0, 0, 0, 0), 0, 0));
		
		buyButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = textFieldName.getText();
				String surname = textFieldSurname.getText();
				String phone = textFieldPhoneNumber.getText();
				
				Customer customer = new Customer(name, surname, phone);
				
				Car car = products[productsList.getSelectedIndex()];
				
				String date = textFieldDate.getText();
				
				try {
					shop.sell(date, car, customer);
				} catch (NullPointerException exception) {
					System.out.println("(!) Requested car is absent (!)");
				}
				
				
			}
		});
		
		transListButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				shop.outTransactionsList();
				showTransactionsListTablePanel();
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
		
		return sPanel;
	}

}
