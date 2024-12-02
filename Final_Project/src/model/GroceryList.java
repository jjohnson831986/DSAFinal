package model;


import java.util.PriorityQueue;

/**
* [Description]
*
* @author  Jeff Johnson
* @version 1.0
* @since   Oct 28, 2024 
*/
// priority queue, sorted by section then exp date
public class GroceryList {

	private PriorityQueue<GroceryItem> groceryList = new PriorityQueue<GroceryItem>(new GroceryListComparator());

	/**
	 * @return the groceryList
	 */
	public PriorityQueue<GroceryItem> getGroceryList() {
		return this.groceryList;
	}
	
	public void clearList() {
		this.groceryList.clear();
	}
	
	public void addToList(GroceryItem item) {
		this.groceryList.add(item);
	}
	public void removeFromFrontOfList() {
		this.groceryList.remove();
	}
	public void removeItemFromList(GroceryItem item) {
		this.groceryList.remove(item);
	}
	public Boolean checkListForItem(GroceryItem item) {
		return this.groceryList.contains(item);
	}
	public GroceryItem checkFrontOfList() {
		return this.groceryList.peek();
	}
	public int length() {
		return this.groceryList.size();
	}
	// code copied and modified from: https://www.geeksforgeeks.org/insertion-sort-algorithm/
	public GroceryList sortList() {
		GroceryItem[] array = this.groceryList.toArray(new GroceryItem[this.groceryList.size()]);

        for (int i = 1; i < array.length; ++i) {
            GroceryItem key = array[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            // array[j].getExpirationDate().isBefore(key.getExpirationDate())
            while (j >= 0 && array[j].getExpirationDate().isAfter(key.getExpirationDate())) {
            	array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
        GroceryList updatedList = new GroceryList();
        for (GroceryItem groceryItem : array) {
			updatedList.addToList(groceryItem);
		}
        return updatedList;
    }
	
	public String printInventory() {
		String text = "";
		if (groceryList.isEmpty()) {
			text = "List is currently empty.";
		}else {
		for (GroceryItem item : groceryList) {
			text += item.toString() + "\n";
		}
	}
	return text;
}
}
