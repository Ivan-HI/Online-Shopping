import java.util.*;

/**
 * Main.java
 * Entry point and controller for the Online Shopping System.
 * Demonstrates: Completeness, exception handling, output design, OOP, cohesion, coupling, etc.
 */
public class Main {
    // In-memory "databases"
    private static ArrayList<Customer> customers = new ArrayList<>();
    private static ArrayList<Product> products = new ArrayList<>();
    private static ArrayList<Order> orders = new ArrayList<>();
    private static ArrayList<Seller> sellers = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    // Admin credentials (for demo)
    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "admin123";

    public static void main(String[] args) {
        // Seed products and seller
        seedDemoData();

        while (true) {
            System.out.println("\n===== Welcome to the Online Shopping System =====");
            System.out.println("Are you a Customer or Admin?");
            System.out.println("1. Customer");
            System.out.println("2. Admin");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    customerFlow();
                    break;
                case "2":
                    adminFlow();
                    break;
                case "3":
                    System.out.println("Thank you for visiting. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid input. Please try again.");
            }
        }
    }

    // ====== Customer Flow ======
    private static void customerFlow() {
        Customer currentCustomer = null;
        while (currentCustomer == null) {
            System.out.println("\nDo you have an account?");
            System.out.println("1. Yes, log in");
            System.out.println("2. No, create new account");
            System.out.println("3. Back to main menu");
            System.out.print("Enter choice: ");
            String choice = sc.nextLine();

            if (choice.equals("1")) {
                currentCustomer = customerLogin();
            } else if (choice.equals("2")) {
                currentCustomer = customerRegister();
            } else if (choice.equals("3")) {
                return;
            } else {
                System.out.println("Invalid input. Try again.");
            }
        }

        // Customer main menu
        Cart cart = new Cart();
        while (true) {
            System.out.println("\n===== Customer Menu =====");
            System.out.println("1. Edit Profile");
            System.out.println("2. Browse Products");
            System.out.println("3. View Cart");
            System.out.println("4. Place Order");
            System.out.println("5. View Order History");
            System.out.println("6. Logout");
            System.out.print("Enter choice: ");
            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    currentCustomer.updateProfile(sc);
                    break;
                case "2":
                    browseProducts(cart);
                    break;
                case "3":
                    cartMenu(cart);
                    break;
                case "4":
                    placeOrder(currentCustomer, cart);
                    break;
                case "5":
                    viewOrderHistory(currentCustomer);
                    break;
                case "6":
                    System.out.println("Logged out.");
                    return;
                default:
                    System.out.println("Invalid input. Try again.");
            }
        }
    }

    // ====== Admin Flow ======
    private static void adminFlow() {
        System.out.print("Enter admin username: ");
        String uname = sc.nextLine();
        System.out.print("Enter admin password: ");
        String pwd = sc.nextLine();

        if (!uname.equals(ADMIN_USERNAME) || !pwd.equals(ADMIN_PASSWORD)) {
            System.out.println("Invalid admin credentials.");
            return;
        }

        Seller admin = sellers.get(0); // For demo, one seller/admin

        while (true) {
            System.out.println("\n===== Admin Menu =====");
            System.out.println("1. Add Product");
            System.out.println("2. Update Product");
            System.out.println("3. Disable Customer Account");
            System.out.println("4. View All Customers");
            System.out.println("5. View All Orders");
            System.out.println("6. Logout");
            System.out.print("Enter choice: ");
            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    adminAddProduct();
                    break;
                case "2":
                    adminUpdateProduct();
                    break;
                case "3":
                    adminDisableCustomer();
                    break;
                case "4":
                    for (Customer c : customers) System.out.println(c);
                    break;
                case "5":
                    for (Order o : orders) System.out.println(o);
                    break;
                case "6":
                    System.out.println("Admin logged out.");
                    return;
                default:
                    System.out.println("Invalid input. Try again.");
            }
        }
    }

    // ====== Helper Methods ======

    // Customer login
    private static Customer customerLogin() {
        System.out.print("Enter username: ");
        String uname = sc.nextLine();
        System.out.print("Enter password: ");
        String pwd = sc.nextLine();
        for (Customer c : customers) {
            if (c.login(uname, pwd)) {
                System.out.println("Login successful. Welcome, " + c.getName() + "!");
                return c;
            }
        }
        System.out.println("Login failed. Please try again.");
        return null;
    }

    // Customer registration
    private static Customer customerRegister() {
        System.out.println("=== New Customer Registration ===");
        String username, password, email;
        while (true) {
            System.out.print("Enter username: ");
            username = sc.nextLine();
            if (findCustomerByUsername(username) != null) {
                System.out.println("Username already exists. Try another.");
                continue;
            }
            System.out.print("Enter password: ");
            password = sc.nextLine();
            System.out.print("Enter email: ");
            email = sc.nextLine();
            if (username.isEmpty() || password.isEmpty() || email.isEmpty() || !email.contains("@")) {
                System.out.println("All fields are required and email must be valid.");
                continue;
            }
            break;
        }
        Customer c = new Customer(customers.size() + 1, "", 0, username, password, email, "");
        customers.add(c);
        System.out.println("Account created. Please log in.");
        return c;
    }

    // Find customer by username
    private static Customer findCustomerByUsername(String username) {
        for (Customer c : customers) {
            if (c.getUsername().equals(username)) return c;
        }
        return null;
    }

    // Browse products and add to cart
    private static void browseProducts(Cart cart) {
        while (true) {
            System.out.println("\n=== Product Catalogue ===");
            for (Product p : products) System.out.println(p);
            System.out.println("1. View Product Details");
            System.out.println("2. Search by Name");
            System.out.println("3. Filter by Category");
            System.out.println("4. Add Product to Cart");
            System.out.println("5. Back");
            System.out.print("Enter choice: ");
            String choice = sc.nextLine();

            if (choice.equals("1")) {
                System.out.print("Enter Product ID: ");
                int pid = readInt();
                Product p = findProductById(pid);
                if (p != null) System.out.println(p);
                else System.out.println("Product not found.");
            } else if (choice.equals("2")) {
                System.out.print("Enter name keyword: ");
                String keyword = sc.nextLine().toLowerCase();
                for (Product p : products)
                    if (p.getName().toLowerCase().contains(keyword)) System.out.println(p);
            } else if (choice.equals("3")) {
                System.out.print("Enter category: ");
                String cat = sc.nextLine().toLowerCase();
                for (Product p : products)
                    if (p.getCategory().toLowerCase().equals(cat)) System.out.println(p);
            } else if (choice.equals("4")) {
                System.out.print("Enter Product ID to add: ");
                int pid = readInt();
                Product p = findProductById(pid);
                if (p == null) {
                    System.out.println("Product not found.");
                    continue;
                }
                System.out.print("Enter quantity: ");
                int qty = readInt();
                if (qty <= 0 || qty > p.getStockQuantity()) {
                    System.out.println("Invalid quantity.");
                    continue;
                }
                cart.addItem(new CartItem(p, qty, new Date().toString()));
                p.setStockQuantity(p.getStockQuantity() - qty);
                System.out.println("Added to cart.");
            } else if (choice.equals("5")) {
                break;
            } else {
                System.out.println("Invalid input.");
            }
        }
    }

    // Cart operations
    private static void cartMenu(Cart cart) {
        while (true) {
            System.out.println("\n=== Cart Menu ===");
            System.out.println(cart);
            System.out.println("1. Update Item Quantity");
            System.out.println("2. Remove Item");
            System.out.println("3. Clear Cart");
            System.out.println("4. Back");
            System.out.print("Enter choice: ");
            String choice = sc.nextLine();
            if (choice.equals("1")) {
                System.out.print("Enter Product ID: ");
                int pid = readInt();
                System.out.print("Enter new quantity: ");
                int qty = readInt();
                cart.updateItemQuantity(pid, qty);
            } else if (choice.equals("2")) {
                System.out.print("Enter Product ID: ");
                int pid = readInt();
                cart.removeItem(pid);
            } else if (choice.equals("3")) {
                cart.clearCart();
            } else if (choice.equals("4")) {
                break;
            } else {
                System.out.println("Invalid input.");
            }
        }
    }

    // Place order
    private static void placeOrder(Customer customer, Cart cart) {
        if (cart.isEmpty()) {
            System.out.println("Cart is empty.");
            return;
        }
        System.out.print("Enter shipping address: ");
        String address = sc.nextLine();
        System.out.print("Enter shipping type (Standard/Express): ");
        String type = sc.nextLine();
        Shipping shipping = new Shipping(orders.size() + 1, address, type);

        System.out.print("Enter payment details: ");
        String payDetails = sc.nextLine();
        Transaction transaction = new Transaction(orders.size() + 1, payDetails, new Date().toString());

        // Convert cart items to order items
        ArrayList<OrderItem> orderItems = new ArrayList<>();
        for (CartItem ci : cart.getCartItems()) {
            if (ci != null)
                orderItems.add(new OrderItem(ci.getProduct(), ci.getQuantity(), ci.getProduct().getPrice()));
        }

        OrderItem[] orderItemArr = new OrderItem[orderItems.size()];
        orderItems.toArray(orderItemArr);

        Order order = new Order(orders.size() + 1, "ORD" + (orders.size() + 1), new Date().toString(),
                customer, orderItemArr, transaction, shipping);
        orders.add(order);
        cart.clearCart();
        System.out.println("Order placed!\n" + order);
    }

    // View order history
    private static void viewOrderHistory(Customer customer) {
        System.out.println("\n=== Order History ===");
        for (Order o : orders) {
            if (o.getCustomer().equals(customer)) {
                System.out.println(o);
            }
        }
    }

    // Find product by ID
    private static Product findProductById(int id) {
        for (Product p : products) if (p.getProductId() == id) return p;
        return null;
    }

    // Read int with exception handling
    private static int readInt() {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.print("Invalid number. Try again: ");
            }
        }
    }

    // Admin add product
    private static void adminAddProduct() {
        System.out.print("Enter product name: ");
        String pname = sc.nextLine();
        System.out.print("Enter category: ");
        String cat = sc.nextLine();
        System.out.print("Enter description: ");
        String desc = sc.nextLine();
        System.out.print("Enter price: ");
        double price = readDouble();
        System.out.print("Enter stock quantity: ");
        int stock = readInt();
        Product p = new Product(products.size() + 1, pname, cat, desc, price, stock, new Date().toString());
        products.add(p);
        System.out.println("Product added: " + p);
    }

    // Admin update product
    private static void adminUpdateProduct() {
        System.out.print("Enter Product ID to update: ");
        int pid = readInt();
        Product p = findProductById(pid);
        if (p == null) {
            System.out.println("Product not found.");
            return;
        }
        System.out.print("Enter new name (current: " + p.getName() + "): ");
        String name = sc.nextLine();
        if (!name.isEmpty()) p.setName(name);
        System.out.print("Enter new price (current: " + p.getPrice() + "): ");
        String priceStr = sc.nextLine();
        if (!priceStr.isEmpty()) p.setPrice(Double.parseDouble(priceStr));
        System.out.print("Enter new stock (current: " + p.getStockQuantity() + "): ");
        String stockStr = sc.nextLine();
        if (!stockStr.isEmpty()) p.setStockQuantity(Integer.parseInt(stockStr));
        System.out.println("Product updated: " + p);
    }

    // Admin disable customer
    private static void adminDisableCustomer() {
        System.out.print("Enter customer username to disable: ");
        String uname = sc.nextLine();
        for (Customer c : customers) {
            if (c.getUsername().equals(uname)) {
                c.setEnabled(false);
                System.out.println("Customer " + uname + " disabled.");
                return;
            }
        }
        System.out.println("Customer not found.");
    }

    // Read double with exception handling
    private static double readDouble() {
        while (true) {
            try {
                return Double.parseDouble(sc.nextLine());
            } catch (Exception e) {
                System.out.print("Invalid number. Try again: ");
            }
        }
    }

    // Seed some demo data
    private static void seedDemoData() {
        products.add(new Product(1, "Laptop", "Electronics", "High performance laptop", 1200.0, 10, new Date().toString()));
        products.add(new Product(2, "Smartphone", "Electronics", "Latest model smartphone", 800.0, 15, new Date().toString()));
        products.add(new Product(3, "Book", "Books", "Java Programming Book", 50.0, 30, new Date().toString()));
        sellers.add(new Seller(1, "Admin", products.toArray(new Product[0])));
    }
}

