// CartItem.java
public class CartItem {
    private Product product;
    private int quantity;
    private String dateAdded;

    public CartItem() {}

    public CartItem(Product product, int quantity, String dateAdded) {
        this.product = product;
        this.quantity = quantity;
        this.dateAdded = dateAdded;
    }

    // Getters and Setters
    public Product getProduct() { return product; }
    public void setProduct(Product product) { this.product = product; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public String getDateAdded() { return dateAdded; }
    public void setDateAdded(String dateAdded) { this.dateAdded = dateAdded; }

    @Override
    public String toString() {
        return product.getName() + " x" + quantity + " (Added: " + dateAdded + ")";
    }
}
