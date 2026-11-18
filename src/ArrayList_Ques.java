import java.util.ArrayList;

// ShoppingCart class
class ShoppingCart {

    // Creating an ArrayList to store product names
    ArrayList<String> products = new ArrayList<>();

    // 1. Add a product to the shopping cart
    public void addProduct(String productName) {

        products.add(productName);

        System.out.println(productName + " added successfully.");
    }

    // 2. Insert a product at a specified index
    public void insertProduct(int index, String productName) {

        if (index >= 0 && index <= products.size()) {

            products.add(index, productName);

            System.out.println(productName + " inserted successfully.");

        } else {

            System.out.println("Invalid index!");
        }
    }

    // 3. Display all products
    public void displayProducts() {

        if (products.isEmpty()) {

            System.out.println("Shopping cart is empty.");

        } else {

            System.out.println("\nProducts in Shopping Cart:");

            for (int i = 0; i < products.size(); i++) {

                System.out.println((i + 1) + ". " + products.get(i));
            }
        }
    }

    // 4. Update an existing product
    public void updateProduct(String oldName, String newName) {

        if (products.contains(oldName)) {

            int index = products.indexOf(oldName);

            products.set(index, newName);

            System.out.println(oldName + " updated to " + newName);

        } else {

            System.out.println(oldName + " not found in cart.");
        }
    }

    // 5. Remove a product
    public void removeProduct(String productName) {

        if (products.contains(productName)) {
            products.remove(productName);
            System.out.println(productName + " removed successfully.");

        } else {

            System.out.println(productName + " not found in cart.");
        }
    }

    // 6. Search for a product
    public void searchProduct(String productName) {

        if (products.contains(productName)) {

            System.out.println(productName + " exists in the cart.");

        } else {

            System.out.println(productName + " does not exist in the cart.");
        }
    }

    // 7. Return total number of products
    public int getTotalProducts() {

        return products.size();
    }
}


// Main class
public class ArrayList_Ques {

    public static void main(String[] args) {

        // Creating ShoppingCart object
        ShoppingCart cart = new ShoppingCart();

        // 1. Adding products
        System.out.println("----- ADD PRODUCTS -----");

        cart.addProduct("Laptop");
        cart.addProduct("Mouse");
        cart.addProduct("Keyboard");
        cart.addProduct("Monitor");

        // 2. Inserting a product
        System.out.println("\n----- INSERT PRODUCT -----");

        cart.insertProduct(2, "Headphones");

        // 3. Displaying products
        System.out.println("\n----- DISPLAY PRODUCTS -----");

        cart.displayProducts();

        // 4. Updating a product
        System.out.println("\n----- UPDATE PRODUCT -----");

        cart.updateProduct("Mouse", "Wireless Mouse");

        // 5. Searching for a product
        System.out.println("\n----- SEARCH PRODUCT -----");

        cart.searchProduct("Laptop");
        cart.searchProduct("Mobile");

        // 6. Removing a product
        System.out.println("\n----- REMOVE PRODUCT -----");

        cart.removeProduct("Keyboard");
        cart.removeProduct("Mobile");

        // 7. Display final shopping cart
        System.out.println("\n----- FINAL SHOPPING CART -----");

        cart.displayProducts();

        // Display total number of products
        System.out.println("\nTotal Products: " + cart.getTotalProducts());
    }
}