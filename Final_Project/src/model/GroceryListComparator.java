package model;

import java.util.Comparator;

/**
 * Comparator for priority queue based on expiration date
 *
 * @author Jeff Johnson
 * @version 1.0
 * @since Oct 28, 2024
 */
public class GroceryListComparator implements Comparator<GroceryItem> {
	@Override
	public int compare(GroceryItem gi1, GroceryItem gi2) {
			return gi1.getExpirationDate().compareTo(gi2.getExpirationDate());
		}
	}