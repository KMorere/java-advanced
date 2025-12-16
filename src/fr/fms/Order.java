package fr.fms;

import java.time.LocalDateTime;

public class Order {
	private Product[] order;
	private float price;
	private LocalDateTime date;
	
	public Order(Product[] order, float price, LocalDateTime date) {
		this.setOrder(order);
		this.setPrice(price);
		this.setDate(date);
	}
	
	public Order(Product[] order) {
		this.setOrder(order);
		this.setPrice(0);
		this.setDate(LocalDateTime.now());
	}

	public Product[] getOrder() {
		return order;
	}

	public void setOrder(Product[] order) {
		this.order = order;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price += price;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}
}
