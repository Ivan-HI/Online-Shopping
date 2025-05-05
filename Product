// Product.java
public class Product {
    private int productId;
    private String name;
    private String category;
    private String description;
    private double price;
    private int stockQuantity;
    private String dateAdded;

    public Product() {}

    public Product(int productId, String name, String category, String description, double price, int stockQuantity, String dateAdded) {
        this.productId = productId;
        this.name = name;
        this.category = category;
        this.description = description;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.dateAdded = dateAdded;
    }

    // Getters and Setters
    public int getProductId() { return productId; }
    public void setProductId(int productId) { this.productId = productId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public int getStockQuantity() { return stockQuantity; }
    public void setStockQuantity(int stockQuantity) { this.stockQuantity = stockQuantity; }
    public String getDateAdded() { return dateAdded; }
    public void setDateAdded(String dateAdded) { this.dateAdded = dateAdded; }

    public void applyDiscount(double percent) {
        if (percent > 0 && percent < 100) {
            this.price -= this.price * percent / 100.0;
        }
    }

    @Override
    public String toString() {
        return String.format("%d. %s (%s): $%.2f, Stock: %d\nDescription: %s\n", productId, name, category, price, stockQuantity, description);
    }
}
