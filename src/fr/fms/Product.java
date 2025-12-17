package fr.fms;

public class Product {
	private String name;
	private float price;
	
	public Product(String name, float price) {
		this.setName(name);
		this.setPrice(price);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	/**
	 * Simple display of a product.
	 * @return A String with a product's name and price.
	 */
	public String getProduct() {
		return this.getName() + " : " + this.getPrice() + " €";
	}
	
	/**
	 * Display a product with a space format.
	 * @param size Size of the space before the price.
	 * @return A String with a product's name and price separated by spaces.
	 */
	public String getProductf(int size) {
		return "%-"+size+"s : %5s €";
	}
}
