package controller;

import javax.management.InvalidAttributeValueException;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import model.GroceryInventory;
import model.GroceryItem;
import model.GroceryList;

import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * This is the GUI for the GroceryList app
 *
 * @author Jeff Johnson
 * @version 1.0
 * @since Nov 6, 2024
 */

public class GUIDriver {

	public static void main(String args[]) {

		GroceryInventory newInv = new GroceryInventory();
		GroceryList newList = new GroceryList();
		JFrame frame = new JFrame("Cupboard");
		// needed for date ranges
		// these can stay as ints since those will never change
		final int MONTH_RANGE_START = 1;
		final int MONTH_RANGE_END = 12;
		final int DATE_RANGE_START = 1;
		final int DATE_RANGE_END = 31;
		// using getYear of LocalDate for these so the app can dynamically update expiration ranges based
		// on current year + however many I set
		LocalDate current = LocalDate.now();
		final int YEAR_RANGE_START = current.getYear();
		final int YEAR_RANGE_END = current.plusYears(15).getYear();

		frame.setSize(1000, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setResizable(false);

		JLabel label = new JLabel("Add Item to Cupboard");
		label.setBounds(15, 15, 300, 100);
		frame.add(label);

		// Name
		JLabel productNameLabel = new JLabel("Product Name:");
		productNameLabel.setBounds(60, 45, 300, 100);
		frame.add(productNameLabel);
		
		JTextField productNameField = new JTextField(1);
		productNameField.setBounds(200, 80, 150, 30);
		frame.add(productNameField);
		
		JLabel productNameFieldErrorLabel = new JLabel("");
		productNameFieldErrorLabel.setBounds(100, 255, 300, 100);
		frame.add(productNameFieldErrorLabel);

		// Section
		JLabel productSectionLabel = new JLabel("Product Section:");
		productSectionLabel.setBounds(60, 85, 300, 100);
		frame.add(productSectionLabel);

		JComboBox productSectionField = new JComboBox();
		productSectionField.setBounds(200, 120, 150, 30);		
		productSectionField.addItem("Produce");
		productSectionField.addItem("Meat/Seafood");
		productSectionField.addItem("Dairy");
		productSectionField.addItem("Deli");
		productSectionField.addItem("Frozen");
		productSectionField.addItem("Canned Goods");
		productSectionField.addItem("Dry Goods");
		productSectionField.addItem("Bread");
		productSectionField.addItem("Cereal");
		productSectionField.addItem("General");
		productSectionField.setSelectedIndex(-1);
		frame.add(productSectionField);
		
		JLabel productSectionFieldErrorLabel = new JLabel("");
		productSectionFieldErrorLabel.setBounds(100, 285, 300, 100);
		frame.add(productSectionFieldErrorLabel);

		// UPC
		JLabel productUPCLabel = new JLabel("Product UPC:");
		productUPCLabel.setBounds(60, 125, 300, 100);
		frame.add(productUPCLabel);

		JTextField productUPCField = new JTextField(1);
		productUPCField.setBounds(200, 160, 150, 30);
		frame.add(productUPCField);
		
		JLabel productUPCFieldErrorLabel = new JLabel("");
		productUPCFieldErrorLabel.setBounds(100, 315, 300, 100);
		frame.add(productUPCFieldErrorLabel);

		// Expiration
		JLabel productExpDateLabel = new JLabel("Product Expiration:");
		productExpDateLabel.setBounds(60, 165, 300, 100);
		frame.add(productExpDateLabel);

		// Month
		JLabel productExpMonth = new JLabel("Month: ");
		productExpMonth.setBounds(91, 185, 100, 100);
		frame.add(productExpMonth);

		JSpinner productExpMonthField = new JSpinner(new SpinnerNumberModel
				(current.getMonthValue(), MONTH_RANGE_START, MONTH_RANGE_END, 1));
		JSpinner.DefaultEditor monthEditor = (JSpinner.DefaultEditor) productExpMonthField.getEditor();
		monthEditor.getTextField().setEnabled(false);
		monthEditor.getTextField().setDisabledTextColor(Color.black);
		productExpMonthField.setBounds(135, 225, 75, 20);
		frame.add(productExpMonthField);

		JLabel productExpMonthErrorLabel = new JLabel("");
		productExpMonthErrorLabel.setBounds(215, 185, 300, 100);
		frame.add(productExpMonthErrorLabel);

		// Date
		JLabel productExpDate = new JLabel("Date: ");
		productExpDate.setBounds(102, 205, 100, 100);
		frame.add(productExpDate);

		JSpinner productExpDateField = new JSpinner(new SpinnerNumberModel
				(current.getDayOfMonth(), DATE_RANGE_START, DATE_RANGE_END, 1));
		JSpinner.DefaultEditor dateEditor = (JSpinner.DefaultEditor) productExpDateField.getEditor();
		dateEditor.getTextField().setEnabled(false);
		dateEditor.getTextField().setDisabledTextColor(Color.black);
		productExpDateField.setBounds(135, 245, 75, 20);
		frame.add(productExpDateField);

		JLabel productExpDateErrorLabel = new JLabel("");
		productExpDateErrorLabel.setBounds(215, 205, 300, 100);
		frame.add(productExpDateErrorLabel);

		// Year
		JLabel productExpYear = new JLabel("Year: ");
		productExpYear.setBounds(102, 225, 100, 100);
		frame.add(productExpYear);

		JSpinner productExpYearField = new JSpinner(new SpinnerNumberModel
				(current.getYear(), YEAR_RANGE_START, YEAR_RANGE_END, 1));
		JSpinner.NumberEditor yearEditor = new JSpinner.NumberEditor(productExpYearField, "#");
		productExpYearField.setEditor(yearEditor);
		yearEditor.getTextField().setEnabled(false);
		yearEditor.getTextField().setDisabledTextColor(Color.black);
		productExpYearField.setBounds(135, 265, 75, 20);
		frame.add(productExpYearField);

		JLabel productExpYearErrorLabel = new JLabel("");
		productExpYearErrorLabel.setBounds(215, 225, 200, 100);
		frame.add(productExpYearErrorLabel);

		// Display fields

		// Cupboard
		JLabel displayCupboardLabel = new JLabel("Currently in Cupboard:");
		displayCupboardLabel.setBounds(400, 25, 150, 60);
		frame.add(displayCupboardLabel);

		JComboBox displayCupboardField = new JComboBox();
		displayCupboardField.setBounds(400, 80, 450, 30);
		frame.add(displayCupboardField);

		// GroceryList
		JLabel displayListLabel = new JLabel("Currently on Grocery List:");
		displayListLabel.setBounds(400, 110, 150, 60);
		frame.add(displayListLabel);
		
		JLabel displayListExpLabel = new JLabel("*Only items that expire in 10 days or less");
		displayListExpLabel.setBounds(420, 128, 350, 60);
		frame.add(displayListExpLabel);

		JTextArea displayListField = new JTextArea();
		JScrollPane scroll = new JScrollPane(displayListField, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(400, 170, 500, 200);
		displayListField.setBorder(new EmptyBorder(1, 10, 1, 1));
		displayListField.setEditable(false);

		frame.add(scroll);

		// Buttons
		
		// Add item to cupboard
		JButton submitButton = new JButton("Add to Cupboard");
		submitButton.setBounds(60, 400, 150, 30);
		frame.add(submitButton);
		submitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {

					// ArrayList<Integer> monthsWith31Days = new ArrayList<Integer>();
					// monthsWith31Days.addAll(Arrays.asList(1,3,5,7,8,10,12));
					ArrayList<Integer> monthsWith30Days = new ArrayList<Integer>();
					monthsWith30Days.addAll(Arrays.asList(4, 6, 9, 11));

					int converted_month = (int) (productExpMonthField.getValue());
					int converted_day = (int) (productExpDateField.getValue());
					int converted_year = (int) (productExpYearField.getValue());

					if (converted_day > 30 && monthsWith30Days.contains(converted_month)) {
						productExpMonthErrorLabel.setText("This month only has 30 days");
					} else if (converted_day > 29 && converted_month == 2) {
						productExpMonthErrorLabel.setText("This month only has 29 days");
					}
					if (productSectionField.getSelectedIndex() == -1) {
						productSectionFieldErrorLabel.setText("Please select a section for this item");
					} else {
						productSectionFieldErrorLabel.setText("");
					}
					if (LocalDate.of(converted_year, converted_month, converted_day).isBefore(current)) {
						productExpMonthErrorLabel.setText("Can not expire before today.");
						throw new InvalidAttributeValueException();
					}
					if(productNameField.getText().length() == 0) {
						productNameFieldErrorLabel.setText("Please enter a name for the item.");
						throw new InvalidAttributeValueException();
					} else {
						productNameFieldErrorLabel.setText("");
					}
					if(productUPCField.getText().length() == 0) {
						productUPCFieldErrorLabel.setText("Please enter a UPC for the item.");
						throw new InvalidAttributeValueException();
					} else {
						productUPCFieldErrorLabel.setText("");
					}

					newInv.addItemBack(new GroceryItem(productNameField.getText(), productSectionField.getSelectedItem().toString(),
							productUPCField.getText(), LocalDate.of(converted_year, converted_month, converted_day)));

					displayCupboardField.addItem(newInv.checkLast());

					productNameField.setText("");
					productSectionField.setSelectedIndex(-1);
					productUPCField.setText("");
					productExpMonthField.setValue(LocalDate.now().getMonthValue());
					productExpDateField.setValue(LocalDate.now().getDayOfMonth());
					productExpYearField.setValue(LocalDate.now().getYear());
					productExpMonthErrorLabel.setText("");
					productExpDateErrorLabel.setText("");
					productExpYearErrorLabel.setText("");
					productSectionFieldErrorLabel.setText("");
					productNameFieldErrorLabel.setText("");
					productUPCFieldErrorLabel.setText("");

				} catch (Exception e2) {
					
				}
			}
		});

		// remove item from cupboard
		JButton removeItemButton = new JButton("Remove From Cupboard");
		removeItemButton.setBounds(208, 400, 180, 30);
		frame.add(removeItemButton);
		
		removeItemButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				GroceryItem toRemoveItem = (GroceryItem)displayCupboardField.getSelectedItem();			
				displayCupboardField.removeItem(toRemoveItem);
				newInv.removeItemObject(toRemoveItem);
				
				// This section clears the current list and makes a new one based off updated cupboard
				newList.clearList();
				String text = "";
				for (int i = 0; i < newInv.length(); i++) {
					if (newInv.getItemAtIndex(i).getExpirationDate().isBefore(LocalDate.now().plusDays(10))) {
						newList.addToList(newInv.getItemAtIndex(i));
					}
				}
				newList.sortList();
				text = newList.printInventory();
				displayListField.setText(text);
				
			}
		});
		
		// Adds items from cupboard to GroceryList
		JButton updateListButton = new JButton("Update Grocery List");
		updateListButton.setBounds(400, 400, 160, 30);
		frame.add(updateListButton);

		updateListButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (newList.length() > 0) {
					newList.clearList();
				}
				String text = "";
				for (int i = 0; i < newInv.length(); i++) {
					if (newInv.getItemAtIndex(i).getExpirationDate().isBefore(LocalDate.now().plusDays(10))) {
						newList.addToList(newInv.getItemAtIndex(i));
					}
				}
				newList.sortList();
				text = newList.printInventory();
				displayListField.setText(text);
			}
		});

		// Clears everything everywhere
		JButton resetButton = new JButton("Reset");
		resetButton.setBounds(550, 400, 150, 30);
		frame.add(resetButton);

		resetButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				productNameField.setText("");
				productSectionField.setSelectedIndex(-1);
				productUPCField.setText("");
				productExpMonthField.setValue(LocalDate.now().getMonthValue());
				productExpDateField.setValue(LocalDate.now().getDayOfMonth());
				productExpYearField.setValue(LocalDate.now().getYear());
				displayCupboardField.removeAllItems();
				displayListField.setText("");
				productExpMonthErrorLabel.setText("");
				productExpDateErrorLabel.setText("");
				productExpYearErrorLabel.setText("");
				productSectionFieldErrorLabel.setText("");
				productNameFieldErrorLabel.setText("");
				productUPCFieldErrorLabel.setText("");

				newInv.clearInv();
				newList.clearList();

			}
		});

		// button I made to insert stuff for easier/quicker testing
		// Comments in block comment section can be uncommented to add back
		
		  JButton testInsertButton = new JButton("Insert for Testing");
		  testInsertButton.setBounds(800, 400, 150, 30); frame.add(testInsertButton);
		  
		  testInsertButton.addActionListener(new ActionListener() {
		  
		  @Override public void actionPerformed(ActionEvent e) { GroceryItem item1 =
		  new GroceryItem("eggs", "Dairy", "111111111111",
		  LocalDate.now().plusDays(14)); GroceryItem item2 = new GroceryItem("milk",
		  "Dairy", "222222222222", LocalDate.now().plusDays(7)); GroceryItem item3 =
		  new GroceryItem("brat buns", "Bread", "333333333333",
		  LocalDate.now().plusDays(7)); GroceryItem item4 = new GroceryItem("cheese",
		  "Dairy", "444444444444", LocalDate.now().plusDays(21)); GroceryItem item5 =
		  new GroceryItem("Ham", "Meat", "555555555555", LocalDate.now().plusDays(10));
		  GroceryItem item6 = new GroceryItem("TP", "General", "666666666666",
		  LocalDate.now().plusYears(2)); GroceryItem item7 = new
		  GroceryItem("sliced bread", "Bread", "777777777777",
		  LocalDate.now().plusDays(6)); GroceryItem item8 = new GroceryItem("Beef",
		  "Meat", "888888888888", LocalDate.now().plusDays(4));
		  
		  newInv.addItemBack(item1); displayCupboardField.addItem(newInv.checkLast());
		  newInv.addItemBack(item2); displayCupboardField.addItem(newInv.checkLast());
		  newInv.addItemBack(item3); displayCupboardField.addItem(newInv.checkLast());
		  newInv.addItemBack(item4); displayCupboardField.addItem(newInv.checkLast());
		  newInv.addItemBack(item5); displayCupboardField.addItem(newInv.checkLast());
		  newInv.addItemBack(item6); displayCupboardField.addItem(newInv.checkLast());
		  newInv.addItemBack(item7); displayCupboardField.addItem(newInv.checkLast());
		  newInv.addItemBack(item8); displayCupboardField.addItem(newInv.checkLast());
		  
		  } });
		 

		
		// display the frame
		frame.setVisible(true);

	}

}