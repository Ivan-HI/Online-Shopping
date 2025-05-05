// OrderItem.java
public class OrderItem {
    private Product product;
    private int quantity;
    private double priceAtPurchase;

    public OrderItem() {}

    public OrderItem(Product product, int quantity, double priceAtPurchase) {
        this.product = product;
        this.quantity = quantity;
        this.priceAtPurchase = priceAtPurchase;
    }

    // Getters and Setters
    public Product getProduct() { return product; }
    public void setProduct(Product product) { this.product = product; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public double getPriceAtPurchase() { return priceAtPurchase; }
    public void setPriceAtPurchase(double priceAtPurchase) { this.priceAtPurchase = priceAtPurchase; }

    @Override
    public String toString() {
        return product.getName() + " x" + quantity + " @ $" + String.format("%.2f", priceAtPurchase);
    }
}
