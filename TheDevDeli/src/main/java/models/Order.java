package models;

import utils.Utils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {

	int order_id;
	String customerName;
	int quantityOrdered;
	double totalPrice;
	LocalDateTime timeOfOrder;
	List<MenuItem> itemsOrdered = new ArrayList<>();

	public Order() {}

	public Order(int order_id, String customerName, int quantityOrdered, double totalPrice, LocalDateTime timeOfOrder) {
		this.order_id = order_id;
		this.customerName = customerName;
		this.quantityOrdered = quantityOrdered;
		this.totalPrice = totalPrice;
		this.timeOfOrder = timeOfOrder;
	}

	public Order(int order_id, String customerName, int quantityOrdered, double totalPrice, LocalDateTime timeOfOrder, List<MenuItem> itemsOrdered) {
		this.order_id = order_id;
		this.customerName = customerName;
		this.quantityOrdered = quantityOrdered;
		this.totalPrice = totalPrice;
		this.timeOfOrder = timeOfOrder;
		this.itemsOrdered = itemsOrdered;
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

	public List<MenuItem> getItemsOrdered() {
		return itemsOrdered;
	}

	public void setItemsOrdered(List<MenuItem> itemsOrdered) {
		this.itemsOrdered = itemsOrdered;
	}

	public void addToOrder(MenuItem item) {
		itemsOrdered.add(item);
	}
	//endregion

	public double getValue() {
		double value = 0.0;

		for(MenuItem item : this.itemsOrdered) {
			value += item.getValue();
		}
		return value;
	}

	public void print() {
		System.out.printf("\n\t\t\t%s---ORDER FOR %s %s---\n", Utils.BLUE, customerName.toUpperCase(), Utils.RESET);
		Utils.designLine(60, true, "_");

		for(MenuItem item : itemsOrdered) {
			item.print();
		}
		System.out.println("Total Items Ordered: " + this.getQuantityOrdered());
		System.out.println("Total Price: $" + this.getTotalPrice());
		Utils.designLine(35, false, Utils.sandwich);
	}
}
