package models;

import java.awt.*;

public class OrderLineItem {

	int orderLineItemId;
	int orderId;
	MenuItem itemOrdered;
	String nameOfItemOrdered;
	double price;

	public OrderLineItem() {}

	public OrderLineItem(int orderLineItemId, int orderId, MenuItem itemOrdered, double price) {
		this.orderLineItemId = orderLineItemId;
		this.orderId = orderId;
		this.itemOrdered = itemOrdered;
		this.price = price;
	}

	public OrderLineItem(int orderLineItemId, int orderId, String nameOfItemOrdered, double price) {
		this.orderLineItemId = orderLineItemId;
		this.orderId = orderId;
		this.nameOfItemOrdered = nameOfItemOrdered;
		this.price = price;
	}

	//region Getters and Setter
	public int getOrderLineItemId() {
		return orderLineItemId;
	}

	public void setOrderLineItemId(int orderLineItemId) {
		this.orderLineItemId = orderLineItemId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public MenuItem getItemOrdered() {
		return itemOrdered;
	}

	public void setItemOrdered(MenuItem itemOrdered) {
		this.itemOrdered = itemOrdered;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	//endregion

	public void print() {
		System.out.println("-----ORDER ITEM-----");
		System.out.println("Order Item ID: " + this.orderLineItemId);
		System.out.println("Order ID: " + this.orderId);
		System.out.println("Item Ordered: " + this.itemOrdered);
		System.out.println("Price: $" + this.price);
		System.out.println("__________________________________________");
	}
}
