package model;

import java.util.LinkedList;

/**
* [Description]
*
* @author  Jeff Johnson
* @version 1.0
* @since   Oct 29, 2024 
*/
public class GroceryInventory {

	private LinkedList<GroceryItem> inventoryList = new LinkedList<GroceryItem>();
	
	/**
	 * @return the inventoryList
	 */
	public LinkedList<GroceryItem> getInventoryList() {
		return inventoryList;
	}

	public void addItemFront(GroceryItem item) {
		inventoryList.push(item);
	}
	
	public void addItemBack(GroceryItem item) {
		inventoryList.addLast(item);
	}
	
	public void addItemAt(int index, GroceryItem item) {
		inventoryList.add(index, item);
	}
	
	public void removeItemFront() {
		inventoryList.pop();
	}
	
	public void removeItemBack() {
		inventoryList.removeLast();
	}
	
	public void removeItemObject(GroceryItem toRemove) {
		inventoryList.remove(toRemove);
	}
	
	public void removeItemAt(int index) {
		inventoryList.remove(index);
	}
	
	public GroceryItem checkFirst() {
		return inventoryList.peekFirst();
	}
	
	public GroceryItem checkLast() {
		return inventoryList.peekLast();
	}
	
	public boolean checkForItem(GroceryItem check) {
		return inventoryList.contains(check);
	}
	
	public GroceryItem getItemAtIndex(int index) {
		return inventoryList.get(index);
	}
	
	public int length() {
		return inventoryList.size();
	}
	
		public void clearInv() {
		this.inventoryList.clear();
		
	}
		
	public void printInventory() {
		System.out.println("Items in store inventory:"); // probably remove this when converted to webapp
		for (GroceryItem item : inventoryList) {
			System.out.println(item.toString());
		}
	}



}
