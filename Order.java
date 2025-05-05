// Order.java
public class Order {
    private int orderId;
    private String orderNo;
    private String dateOrdered;
    private Customer customer;
    private OrderItem[] orderItems;
    private Transaction transaction;
    private Shipping shipping;

    public Order() {}

    public Order(int orderId, String orderNo, String dateOrdered, Customer customer, OrderItem[] orderItems, Transaction transaction, Shipping shipping) {
        this.orderId = orderId;
        this.orderNo = orderNo;
        this.dateOrdered = dateOrdered;
        this.customer = customer;
        this.orderItems = orderItems;
        this.transaction = transaction;
        this.shipping = shipping;
    }

    // Getters and Setters
    public int getOrderId() { return orderId; }
    public void setOrderId(int orderId) { this.orderId = orderId; }
    public String getOrderNo() { return orderNo; }
    public void setOrderNo(String orderNo) { this.orderNo = orderNo; }
    public String getDateOrdered() { return dateOrdered; }
    public void setDateOrdered(String dateOrdered) { this.dateOrdered = dateOrdered; }
    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }
    public OrderItem[] getOrderItems() { return orderItems; }
    public void setOrderItems(OrderItem[] orderItems) { this.orderItems = orderItems; }
    public Transaction getTransaction() { return transaction; }
    public void setTransaction(Transaction transaction) { this.transaction = transaction; }
    public Shipping getShipping() { return shipping; }
    public void setShipping(Shipping shipping) { this.shipping = shipping; }

    public void placeOrder() {
        System.out.println("Order placed: " + orderNo + " for " + customer.getName());
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Order #" + orderNo + " (" + dateOrdered + ")\n");
        for (OrderItem item : orderItems) {
            if (item != null) sb.append(item).append("\n");
        }
        sb.append(transaction).append("\n").append(shipping);
        return sb.toString();
    }
}
