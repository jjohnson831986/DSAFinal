package test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import model.GroceryInventory;
import model.GroceryItem;
import model.GroceryList;

/**
* [Description]
*
* @author  Jeff Johnson
* @version 1.0
* @since   Nov 12, 2024 
*/
class ProjectUnitTests {

	// -----------------------------  GroceryItem Unit Tests  ----------------------------------------
	@Test
	void createNewObjectWithConstructor() {
		GroceryItem newItem = new GroceryItem("eggs","dairy","111111111111",LocalDate.of(2024, 11, 12));
		assertEquals(newItem.getExpirationDate(), LocalDate.of(2024, 11, 12));
	}
	@Test
	void testGroceryItemGetProductName() {
		GroceryItem item1 = new GroceryItem("eggs", "Dairy", "111111111111", LocalDate.of(2024, 11, 12));
		assertEquals(item1.getProductName(),"eggs");
	}
	@Test
	void testGroceryItemSetProductName() {
		GroceryItem item1 = new GroceryItem("eggs", "Dairy", "111111111111", LocalDate.of(2024, 11, 12));
		item1.setProductName("Cheese");
		assertEquals(item1.getProductName(),"Cheese");
	}
	@Test
	void testGroceryItemGetProductSection() {
		GroceryItem item1 = new GroceryItem("eggs", "Dairy", "111111111111", LocalDate.of(2024, 11, 12));
		assertEquals(item1.getProductSection(),"Dairy");
	}
	@Test
	void testGroceryItemSetProductSection() {
		GroceryItem item1 = new GroceryItem("eggs", "Dairy", "111111111111", LocalDate.of(2024, 11, 12));
		item1.setProductSection("meat");
		assertEquals(item1.getProductSection(),"meat");
	}
	@Test
	void testGroceryItemGetProductUPC() {
		GroceryItem item1 = new GroceryItem("eggs", "Dairy", "111111111111", LocalDate.of(2024, 11, 12));
		assertEquals(item1.getProductUPC(),"111111111111");
	}
	@Test
	void testGroceryItemSetProductUPC() {
		GroceryItem item1 = new GroceryItem("eggs", "Dairy", "111111111111", LocalDate.of(2024, 11, 12));
		item1.setProductUPC("222222222222");
		assertEquals(item1.getProductUPC(),"222222222222");
	}
	@Test
	void testGroceryItemGetExpirationDate() {
		GroceryItem item1 = new GroceryItem("eggs", "Dairy", "111111111111", LocalDate.of(2024, 11, 12));
		assertEquals(item1.getExpirationDate(),LocalDate.of(2024, 11, 12));
	}
	@Test
	void testGroceryItemSetExpirationDate() {
		GroceryItem item1 = new GroceryItem("eggs", "Dairy", "111111111111", LocalDate.of(2024, 11, 12));
		item1.setExpirationDate(LocalDate.of(2024, 11, 13));
		assertEquals(item1.getExpirationDate(),LocalDate.of(2024, 11, 13));
	}
	@Test
	void testGroceryItemToString() {
		GroceryItem item1 = new GroceryItem("eggs", "Dairy", "111111111111", LocalDate.of(2024, 11, 12));

		assertEquals(item1.toString(),"Name: eggs, Section: Dairy, UPC: 111111111111, Exp Date: 11/12/2024");
	}
	// -----------------------------  GroceryInventory Unit Tests  ---------------------------------------
	@Test
	void checkFrontOfInventory() {
		GroceryItem item1 = new GroceryItem("eggs", "Dairy", "111111111111", LocalDate.now().plusDays(14));
		GroceryItem item2 = new GroceryItem("milk", "Dairy", "222222222222", LocalDate.now().plusDays(7));
		GroceryItem item3 = new GroceryItem("brat buns", "Bread", "333333333333", LocalDate.now().plusDays(7));
		GroceryItem item4 = new GroceryItem("cheese", "Dairy", "444444444444", LocalDate.now().plusDays(21));
		GroceryInventory newList = new GroceryInventory();
		newList.addItemBack(item1);
		newList.addItemBack(item2);
		newList.addItemBack(item3);
		newList.addItemBack(item4);
		

		assertEquals(newList.checkFirst(), item1);
	}
	@Test
	void checkBackOfInventory() {
		GroceryItem item1 = new GroceryItem("eggs", "Dairy", "111111111111", LocalDate.now().plusDays(14));
		GroceryItem item2 = new GroceryItem("milk", "Dairy", "222222222222", LocalDate.now().plusDays(7));
		GroceryItem item3 = new GroceryItem("brat buns", "Bread", "333333333333", LocalDate.now().plusDays(7));
		GroceryItem item4 = new GroceryItem("cheese", "Dairy", "444444444444", LocalDate.now().plusDays(21));
		GroceryInventory newList = new GroceryInventory();
		newList.addItemBack(item1);
		newList.addItemBack(item2);
		newList.addItemBack(item3);
		newList.addItemBack(item4);
		

		assertEquals(newList.checkLast(), item4);
	}
	@Test
	void getItemAtIndexOfInventory() {
		GroceryItem item1 = new GroceryItem("eggs", "Dairy", "111111111111", LocalDate.now().plusDays(14));
		GroceryItem item2 = new GroceryItem("milk", "Dairy", "222222222222", LocalDate.now().plusDays(7));
		GroceryItem item3 = new GroceryItem("brat buns", "Bread", "333333333333", LocalDate.now().plusDays(7));
		GroceryItem item4 = new GroceryItem("cheese", "Dairy", "444444444444", LocalDate.now().plusDays(21));
		GroceryInventory newList = new GroceryInventory();
		newList.addItemBack(item1);
		newList.addItemBack(item2);
		newList.addItemBack(item3);
		newList.addItemBack(item4);
		

		assertEquals(newList.getItemAtIndex(2), item3);
	}
	@Test
	void addToFrontOfInventory() {
		GroceryItem item1 = new GroceryItem("eggs", "Dairy", "111111111111", LocalDate.now().plusDays(14));
		GroceryItem item2 = new GroceryItem("milk", "Dairy", "222222222222", LocalDate.now().plusDays(7));
		GroceryItem item3 = new GroceryItem("brat buns", "Bread", "333333333333", LocalDate.now().plusDays(7));
		GroceryItem item4 = new GroceryItem("cheese", "Dairy", "444444444444", LocalDate.now().plusDays(21));
		GroceryInventory newList = new GroceryInventory();
		newList.addItemFront(item1);
		newList.addItemFront(item2);
		newList.addItemFront(item3);
		newList.addItemFront(item4);
		

		assertEquals(newList.checkFirst(), item4);
	}
	@Test
	void addToBackOfInventory() {
		GroceryItem item1 = new GroceryItem("eggs", "Dairy", "111111111111", LocalDate.now().plusDays(14));
		GroceryItem item2 = new GroceryItem("milk", "Dairy", "222222222222", LocalDate.now().plusDays(7));
		GroceryItem item3 = new GroceryItem("brat buns", "Bread", "333333333333", LocalDate.now().plusDays(7));
		GroceryItem item4 = new GroceryItem("cheese", "Dairy", "444444444444", LocalDate.now().plusDays(21));
		GroceryInventory newList = new GroceryInventory();
		newList.addItemBack(item1);
		newList.addItemBack(item2);
		newList.addItemBack(item3);
		newList.addItemBack(item4);
		

		assertEquals(newList.checkLast(), item4);
	}
	@Test
	void addAtSpecificIndexOfInventory() {
		GroceryItem item1 = new GroceryItem("eggs", "Dairy", "111111111111", LocalDate.now().plusDays(14));
		GroceryItem item2 = new GroceryItem("milk", "Dairy", "222222222222", LocalDate.now().plusDays(7));
		GroceryItem item3 = new GroceryItem("brat buns", "Bread", "333333333333", LocalDate.now().plusDays(7));
		GroceryItem item4 = new GroceryItem("cheese", "Dairy", "444444444444", LocalDate.now().plusDays(21));
		GroceryInventory newList = new GroceryInventory();
		newList.addItemBack(item1);
		newList.addItemBack(item2);
		newList.addItemBack(item3);
		newList.addItemAt(1,item4);
		

		assertEquals(newList.getItemAtIndex(1), item4);
	}
	@Test
	void removeFromFrontOfInventory() {
		GroceryItem item1 = new GroceryItem("eggs", "Dairy", "111111111111", LocalDate.now().plusDays(14));
		GroceryItem item2 = new GroceryItem("milk", "Dairy", "222222222222", LocalDate.now().plusDays(7));
		GroceryItem item3 = new GroceryItem("brat buns", "Bread", "333333333333", LocalDate.now().plusDays(7));
		GroceryInventory newList = new GroceryInventory();
		newList.addItemBack(item1);
		newList.addItemBack(item2);
		newList.addItemBack(item3);		
		newList.removeItemFront();

		assertEquals(newList.checkFirst(), item2);
	}
	@Test
	void removeFromBackOfInventory() {
		GroceryItem item1 = new GroceryItem("eggs", "Dairy", "111111111111", LocalDate.now().plusDays(14));
		GroceryItem item2 = new GroceryItem("milk", "Dairy", "222222222222", LocalDate.now().plusDays(7));
		GroceryItem item3 = new GroceryItem("brat buns", "Bread", "333333333333", LocalDate.now().plusDays(7));
		GroceryInventory newList = new GroceryInventory();
		newList.addItemBack(item1);
		newList.addItemBack(item2);
		newList.addItemBack(item3);		
		newList.removeItemBack();

		assertEquals(newList.checkLast(), item2);
	}
	@Test
	void removeObjectFromInventory() {
		GroceryItem item1 = new GroceryItem("eggs", "Dairy", "111111111111", LocalDate.now().plusDays(14));
		GroceryItem item2 = new GroceryItem("milk", "Dairy", "222222222222", LocalDate.now().plusDays(7));
		GroceryItem item3 = new GroceryItem("brat buns", "Bread", "333333333333", LocalDate.now().plusDays(7));
		GroceryItem item4 = new GroceryItem("cheese", "Dairy", "444444444444", LocalDate.now().plusDays(21));
		GroceryInventory newList = new GroceryInventory();
		newList.addItemBack(item1);
		newList.addItemBack(item2);
		newList.addItemBack(item3);		
		newList.addItemBack(item4);

		newList.removeItemObject(item4);
		
		assertFalse(newList.checkForItem(item4));
	}
	@Test
	void removeObjectFromInventoryAtIndex() {
		GroceryItem item1 = new GroceryItem("eggs", "Dairy", "111111111111", LocalDate.now().plusDays(14));
		GroceryItem item2 = new GroceryItem("milk", "Dairy", "222222222222", LocalDate.now().plusDays(7));
		GroceryItem item3 = new GroceryItem("brat buns", "Bread", "333333333333", LocalDate.now().plusDays(7));
		GroceryItem item4 = new GroceryItem("cheese", "Dairy", "444444444444", LocalDate.now().plusDays(21));
		GroceryInventory newList = new GroceryInventory();
		newList.addItemBack(item1);
		newList.addItemBack(item2);
		newList.addItemBack(item3);		
		newList.addItemBack(item4);

		newList.removeItemAt(1);
		
		assertFalse(newList.checkForItem(item2));
	}
	@Test
	void testLengthOfList() {
		GroceryItem item1 = new GroceryItem("eggs", "Dairy", "111111111111", LocalDate.now().plusDays(14));
		GroceryItem item2 = new GroceryItem("milk", "Dairy", "222222222222", LocalDate.now().plusDays(7));
		GroceryItem item3 = new GroceryItem("brat buns", "Bread", "333333333333", LocalDate.now().plusDays(7));
		GroceryItem item4 = new GroceryItem("cheese", "Dairy", "444444444444", LocalDate.now().plusDays(21));
		GroceryInventory newList = new GroceryInventory();
		newList.addItemBack(item1);
		newList.addItemBack(item2);
		newList.addItemBack(item3);		
		newList.addItemBack(item4);
		
		assertEquals(newList.length(), 4);
	}
	@Test
	void testClearList() {
		GroceryItem item1 = new GroceryItem("eggs", "Dairy", "111111111111", LocalDate.now().plusDays(14));
		GroceryItem item2 = new GroceryItem("milk", "Dairy", "222222222222", LocalDate.now().plusDays(7));
		GroceryItem item3 = new GroceryItem("brat buns", "Bread", "333333333333", LocalDate.now().plusDays(7));
		GroceryItem item4 = new GroceryItem("cheese", "Dairy", "444444444444", LocalDate.now().plusDays(21));
		GroceryInventory newList = new GroceryInventory();
		newList.addItemBack(item1);
		newList.addItemBack(item2);
		newList.addItemBack(item3);		
		newList.addItemBack(item4);

		newList.clearInv();
		
		assertEquals(newList.length(), 0);
	}
	
	// -----------------------------  GroceryList Unit Tests  ----------------------------------------
	@Test
	void addGroceryItemToList() {
		GroceryItem newItem = new GroceryItem("eggs","dairy","111111111111",LocalDate.now().plusDays(1));
		GroceryList newList = new GroceryList();
		newList.addToList(newItem);

		assertEquals(newList.length(),1);
		assertTrue(newList.checkListForItem(newItem));
	}
	@Test
	void removeFrontGroceryItemFromList() {
		GroceryItem item1 = new GroceryItem("eggs", "Dairy", "111111111111", LocalDate.now().plusDays(14));
		GroceryItem item2 = new GroceryItem("milk", "Dairy", "222222222222", LocalDate.now().plusDays(7));
		GroceryItem item3 = new GroceryItem("brat buns", "Bread", "333333333333", LocalDate.now().plusDays(7));
		GroceryItem item4 = new GroceryItem("cheese", "Dairy", "444444444444", LocalDate.now().plusDays(21));
		GroceryList newList = new GroceryList();
		newList.addToList(item1);
		newList.addToList(item2);
		newList.addToList(item3);
		newList.addToList(item4);
		newList.removeFromFrontOfList();

		assertEquals(newList.length(),3);
	}
	@Test
	void removeSpecificGroceryItemFromList() {
		GroceryItem item1 = new GroceryItem("eggs", "Dairy", "111111111111", LocalDate.now().plusDays(14));
		GroceryItem item2 = new GroceryItem("milk", "Dairy", "222222222222", LocalDate.now().plusDays(7));
		GroceryItem item3 = new GroceryItem("brat buns", "Bread", "333333333333", LocalDate.now().plusDays(7));
		GroceryItem item4 = new GroceryItem("cheese", "Dairy", "444444444444", LocalDate.now().plusDays(21));
		GroceryList newList = new GroceryList();
		newList.addToList(item1);
		newList.addToList(item2);
		newList.addToList(item3);
		newList.addToList(item4);
		newList.removeItemFromList(item4);

		assertEquals(newList.length(),3);
	}
	@Test
	void removeAllGroceryItemsFromList() {
		GroceryItem item1 = new GroceryItem("eggs", "Dairy", "111111111111", LocalDate.now().plusDays(14));
		GroceryItem item2 = new GroceryItem("milk", "Dairy", "222222222222", LocalDate.now().plusDays(7));
		GroceryItem item3 = new GroceryItem("brat buns", "Bread", "333333333333", LocalDate.now().plusDays(7));
		GroceryItem item4 = new GroceryItem("cheese", "Dairy", "444444444444", LocalDate.now().plusDays(21));
		GroceryList newList = new GroceryList();
		newList.addToList(item1);
		newList.addToList(item2);
		newList.addToList(item3);
		newList.addToList(item4);
		newList.clearList();;

		assertEquals(newList.length(),0);
	}
	@Test
	void checkForSpecificGroceryItemInList() {
		GroceryItem item1 = new GroceryItem("eggs", "Dairy", "111111111111", LocalDate.now().plusDays(14));
		GroceryItem item2 = new GroceryItem("milk", "Dairy", "222222222222", LocalDate.now().plusDays(7));
		GroceryItem item3 = new GroceryItem("brat buns", "Bread", "333333333333", LocalDate.now().plusDays(7));
		GroceryItem item4 = new GroceryItem("cheese", "Dairy", "444444444444", LocalDate.now().plusDays(21));
		GroceryList newList = new GroceryList();
		newList.addToList(item1);
		newList.addToList(item2);
		newList.addToList(item3);
		newList.addToList(item4);
		

		assertTrue(newList.checkListForItem(item4));
	}
	@Test
	void checkForSpecificGroceryItemNotInList() {
		GroceryItem item1 = new GroceryItem("eggs", "Dairy", "111111111111", LocalDate.now().plusDays(14));
		GroceryItem item2 = new GroceryItem("milk", "Dairy", "222222222222", LocalDate.now().plusDays(7));
		GroceryItem item3 = new GroceryItem("brat buns", "Bread", "333333333333", LocalDate.now().plusDays(7));
		GroceryItem item4 = new GroceryItem("cheese", "Dairy", "444444444444", LocalDate.now().plusDays(21));
		GroceryItem item5 = new GroceryItem("Ham", "Meat", "555555555555", LocalDate.now().plusDays(10));
		GroceryList newList = new GroceryList();
		newList.addToList(item1);
		newList.addToList(item2);
		newList.addToList(item3);
		newList.addToList(item4);
		

		assertFalse(newList.checkListForItem(item5));
	}
	@Test
	void checkFrontOfList() {
		GroceryItem item1 = new GroceryItem("eggs", "Dairy", "111111111111", LocalDate.now().plusDays(14));
		GroceryItem item2 = new GroceryItem("milk", "Dairy", "222222222222", LocalDate.now().plusDays(7));
		GroceryItem item3 = new GroceryItem("brat buns", "Bread", "333333333333", LocalDate.now().plusDays(7));
		GroceryItem item4 = new GroceryItem("cheese", "Dairy", "444444444444", LocalDate.now().plusDays(21));
		GroceryList newList = new GroceryList();
		newList.addToList(item1);
		newList.addToList(item2);
		newList.addToList(item4);
		

		assertEquals(newList.checkFrontOfList(), item2);
	}
	@Test
	void testPrintEmptyList() {
		GroceryList newList = new GroceryList();

		assertEquals(newList.printInventory(),"List is currently empty.");
	}
	
	
	

}
