import java.util.*;
class ShoppingCart{
    ArrayList<String> products = new ArrayList<>();

    public void addProduct(String productName)
    {
        products.add(productName);
        System.out.println(productName + "Added Successfully");
    }
    public void insertProduct(int index, String productName)
    {
        if(index >=0 || index <products.size())
        {
            products.add(index, productName);
            System.out.println(productName + "added at index :" + index);
        }
        else{
            System.out.println("Invalid Index");
        }

    }
    public void display()
    {
        for(int i=0;i<products.size();i++)
        {
            System.out.println(products.get(i));
        }
    }
    public void updateProduct(String old, String New)
    {
        if(products.contains(old))
        {
            int index = products.indexOf(old);
            products.set(index, New);
        }
        else{
            System.out.println(old + " Not found in list");
        }
    }
}
public class ArrayList_Ques{
    public static void main(String[] args)
    {
        ShoppingCart cart = new ShoppingCart();
        cart.addProduct("Laptop");
        cart.addProduct("Mouse");
        cart.addProduct("Keyboard");
        cart.addProduct("Desktop");
        cart.addProduct("TV");

        cart.insertProduct(3, "Tablet");

        cart.updateProduct("Mouse", "Wireless Mouse");
        cart.display();
    }
}