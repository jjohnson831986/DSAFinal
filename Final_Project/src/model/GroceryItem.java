package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
* POJO for items that can be added to lists
*
* @author  Jeff Johnson
* @version 1.0
* @since   Oct 25, 2024 
*/
public class GroceryItem {
	
	private String productSection;
	private String productName;
	private String productUPC;
	private LocalDate expirationDate;
	/**
	 * 
	 */
	public GroceryItem() {
		super();
	}
	public GroceryItem(String productName, String productSection, String productUPC, LocalDate expirationDate) {
		super();
		this.productName = productName;
		this.productSection = productSection;
		this.productUPC = productUPC;
		this.expirationDate = expirationDate;
	}
	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}
	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	/**
	 * @return the productSection
	 */
	public String getProductSection() {
		return productSection;
	}
	/**
	 * @param productSection the productSection to set
	 */
	public void setProductSection(String productSection) {
		this.productSection = productSection;
	}
	/**
	 * @return the productUPC
	 */
	public String getProductUPC() {
		return productUPC;
	}
	/**
	 * @param productUPC the productUPC to set
	 */
	public void setProductUPC(String productUPC) {
		this.productUPC = productUPC;
	}
	/**
	 * @return the expirationDate
	 */
	public LocalDate getExpirationDate() {
		return expirationDate;
	}
	/**
	 * @param expirationDate the expirationDate to set
	 */
	public void setExpirationDate(LocalDate expirationDate) {
		this.expirationDate = expirationDate;
	}
	@Override
	public String toString() {
		String returnString = "";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/YYYY");

		returnString = "Name: " + productName + ", Section: " + productSection + ", UPC: " + productUPC + ", Exp Date: " + formatter.format(expirationDate);

		
		return returnString;
	}


}
