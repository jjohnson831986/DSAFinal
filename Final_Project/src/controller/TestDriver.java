package controller;

import java.time.LocalDate;

import model.GroceryItem;
import model.GroceryList;
import model.GroceryInventory;
/**
* [Description]
*
* @author  Jeff Johnson
* @version 1.0
* @since   Oct 25, 2024 
*/
public class TestDriver {

	public static void main(String[] args) {
		// Constructor, no purchase date
		// GroceryItem(int productID, String productName, double productPrice,
		//			   long productUPC, Date expirationDate)
		
		// Constructor, with purchase date
		// GroceryItem(int productID, String productName, double productPrice, long productUPC,
		// 			   Date purchaseDate, Date expirationDate)
		
		// LocalDate.of(2024, 11, 28)
		GroceryItem item1 = new GroceryItem("eggs", "Dairy", "111111111111", LocalDate.now().plusDays(14));
		GroceryItem item2 = new GroceryItem("milk", "Dairy", "222222222222", LocalDate.now().plusDays(7));
		GroceryItem item3 = new GroceryItem("brat buns", "Bread", "333333333333", LocalDate.now().plusDays(7));
		GroceryItem item4 = new GroceryItem("cheese", "Dairy", "444444444444", LocalDate.now().plusDays(21));
		GroceryItem item5 = new GroceryItem("Ham", "Meat", "555555555555", LocalDate.now().plusDays(10));
		GroceryItem item6 = new GroceryItem("TP", "General", "666666666666", LocalDate.now().plusYears(2));
		GroceryItem item7 = new GroceryItem("sliced bread", "Bread", "777777777777", LocalDate.now().plusDays(6));
		GroceryItem item8 = new GroceryItem("Beef", "Meat", "888888888888", LocalDate.now().plusDays(4));

		GroceryInventory newInv = new GroceryInventory();
		newInv.addItemBack(item1);
		newInv.addItemBack(item2);
		newInv.addItemBack(item3);
		newInv.addItemBack(item4);
		newInv.addItemBack(item5);
		newInv.addItemBack(item6);
		newInv.addItemBack(item7);
		newInv.addItemBack(item8);
		newInv.printInventory();
		System.out.println();
		GroceryList newList = new GroceryList();
		// adds items to list if expiring in X number of days
		for (int i=0;i<newInv.length();i++) {
			if(newInv.getItemAtIndex(i).getExpirationDate().isBefore(LocalDate.now().plusDays(10))) {
				newList.addToList(newInv.getItemAtIndex(i));
			}
		}
//		newList.addToList(newInv.getItemAtIndex(0));
//		newList.addToList(newInv.getItemAtIndex(3));
//		newList.addToList(newInv.getItemAtIndex(1));
//		newList.addToList(newInv.getItemAtIndex(2));
//		newList.addToList(newInv.getItemAtIndex(4));
//		newList.addToList(newInv.getItemAtIndex(6));
//		newList.printInventory();
//		newList.addToList(newInv.getItemAtIndex(5));
		System.out.println("----------------   NEW      -------------");
		newList.sortList();
		System.out.println(newList.printInventory());
		newList.clearList();
		newList.printInventory();

	}

}
