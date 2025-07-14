package models;

import java.time.LocalDateTime;

public class Order {

	int order_id;
	String customerName;
	int quantityOrdered;
	double totalPrice;
	LocalDateTime timeOfOrder;

	public Order() {}

	public Order(int order_id, String customerName, int quantityOrdered, double totalPrice, LocalDateTime timeOfOrder) {
		this.order_id = order_id;
		this.customerName = customerName;
		this.quantityOrdered = quantityOrdered;
		this.totalPrice = totalPrice;
		this.timeOfOrder = timeOfOrder;
	}

	//region Getters and Setters
	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getQuantityOrdered() {
		return quantityOrdered;
	}

	public void setQuantityOrdered(int quantityOrdered) {
		this.quantityOrdered = quantityOrdered;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public LocalDateTime getTimeOfOrder() {
		return timeOfOrder;
	}

	public void setTimeOfOrder(LocalDateTime timeOfOrder) {
		this.timeOfOrder = timeOfOrder;
	}
	//endregion
}
