package model;

import java.util.Comparator;

/**
* Comparator for priority queue based on section within the store
*
* @author  Jeff Johnson
* @version 1.0
* @since   Oct 25, 2024 
*/
public class GroceryItemComparator implements Comparator<GroceryItem>{
	@Override
	public int compare(GroceryItem gi1, GroceryItem gi2) {
		return gi1.getProductSection().compareTo(gi2.getProductSection());
	}
}
