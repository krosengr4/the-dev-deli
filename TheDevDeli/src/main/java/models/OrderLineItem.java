package models;

public class OrderLineItem {

	int orderLineItemId;
	int orderId;
	Object itemOrdered;
	double price;

	public OrderLineItem() {}

	public OrderLineItem(int orderLineItemId, int orderId, String itemOrdered, double price) {
		this.orderLineItemId = orderLineItemId;
		this.orderId = orderId;
		this.itemOrdered = itemOrdered;
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

	public Object getItemOrdered() {
		return itemOrdered;
	}

	public void setItemOrdered(String itemOrdered) {
		this.itemOrdered = itemOrdered;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	//endregion
}
