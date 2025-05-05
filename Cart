// Cart.java
public class Cart {
    private int cartId;
    private CartItem[] cartItems;
    private String dateCreated;
    private double totalAmount;

    public Cart() {
        cartItems = new CartItem[20];
        dateCreated = java.time.LocalDate.now().toString();
    }

    // Getters and Setters
    public CartItem[] getCartItems() { return cartItems; }
    public void setCartItems(CartItem[] cartItems) { this.cartItems = cartItems; }
    public double getTotalAmount() { return totalAmount; }

    public void addItem(CartItem item) {
        for (int i = 0; i < cartItems.length; i++) {
            if (cartItems[i] == null) {
                cartItems[i] = item;
                break;
            }
        }
        calculateTotal();
        System.out.println("Item added to cart.");
    }

    public void removeItem(int productId) {
        boolean found = false;
        for (int i = 0; i < cartItems.length; i++) {
            if (cartItems[i] != null && cartItems[i].getProduct().getProductId() == productId) {
                cartItems[i] = null;
                found = true;
                break;
            }
        }
        calculateTotal();
        if (found) System.out.println("Item removed from cart.");
        else System.out.println("Product not found in cart.");
    }

    public void updateItemQuantity(int productId, int quantity) {
        boolean found = false;
        for (CartItem item : cartItems) {
            if (item != null && item.getProduct().getProductId() == productId) {
                item.setQuantity(quantity);
                found = true;
            }
        }
        calculateTotal();
        if (found) System.out.println("Item quantity updated.");
        else System.out.println("Product not found in cart.");
    }

    public double calculateTotal() {
        totalAmount = 0.0;
        for (CartItem item : cartItems) {
            if (item != null)
                totalAmount += item.getProduct().getPrice() * item.getQuantity();
        }
        return totalAmount;
    }

    public void clearCart() {
        for (int i = 0; i < cartItems.length; i++) cartItems[i] = null;
        totalAmount = 0.0;
        System.out.println("Cart cleared.");
    }

    public boolean isEmpty() {
        for (CartItem item : cartItems) if (item != null) return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Cart Contents:\n");
        for (CartItem item : cartItems) {
            if (item != null)
                sb.append(item).append("\n");
        }
        sb.append("Total: $").append(String.format("%.2f", totalAmount));
        return sb.toString();
    }
}
