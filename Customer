// Customer.java
public class Customer {
    //  Encapsulation
    private int userId;
    private String name;
    private int age;
    private String username;
    private String password;
    private String email;
    private String address;
    private boolean enabled = true;

    public Customer() {}

    public Customer(int userId, String name, int age, String username, String password, String email, String address) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.username = username;
        this.password = password;
        this.email = email;
        this.address = address;
    }

    // Getters and Setters
    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public boolean isEnabled() { return enabled; }
    public void setEnabled(boolean enabled) { this.enabled = enabled; }

    @Override
    public String toString() {
        return String.format("Customer: %s (Username: %s, Email: %s, Address: %s, Status: %s)",
                name, username, email, address, enabled ? "Active" : "Disabled");
    }

    public boolean login(String username, String password) {
        return enabled && this.username.equals(username) && this.password.equals(password);
    }

    public void logout() {
        System.out.println("Logout successful.");
    }

    // Exception Handling
    public void updateProfile(java.util.Scanner sc) {
        while (true) {
            try {
                System.out.print("Enter new name (current: " + name + "): ");
                String newName = sc.nextLine();
                if (!newName.isEmpty()) this.name = newName;
                System.out.print("Enter new email (current: " + email + "): ");
                String newEmail = sc.nextLine();
                if (!newEmail.isEmpty() && newEmail.contains("@")) this.email = newEmail;
                System.out.print("Enter new password (leave blank to keep current): ");
                String newPassword = sc.nextLine();
                if (!newPassword.isEmpty()) this.password = newPassword;
                System.out.print("Enter new address (current: " + address + "): ");
                String newAddress = sc.nextLine();
                if (!newAddress.isEmpty()) this.address = newAddress;
                System.out.println("Profile updated successfully!");
                break;
            } catch (Exception e) {
                System.out.println("Invalid input. Try again.");
            }
        }
    }
}

