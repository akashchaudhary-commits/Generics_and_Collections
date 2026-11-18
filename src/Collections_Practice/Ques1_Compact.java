package Collections_Practice;

import java.util.ArrayList;
import java.util.Scanner;

class Item{
    protected int itemID;
    protected String title;
    Item(int itemID, String title)
    {
        this.itemID = itemID;
        this.title = title;
    }
    public void displayInfo()
    {
        System.out.println("Item Id: " + itemID + " Title: " + title);
    }
}
class Book extends Item{
    private String author;
    Book(int itemID, String title, String author)
    {
        super(itemID, title);
        this.author = author;
    }
    @Override
    public void displayInfo()
    {
        super.displayInfo();
        System.out.println("Author: " + author);
    }
}
public class Ques1_Compact{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no of books: ");
        int n = sc.nextInt();
        ArrayList<Book> list = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            System.out.println("Enter ItemID: ");
            int itemID = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter Title: ");
            String title = sc.nextLine();
            System.out.println("Enter author: ");
            String author = sc.nextLine();

            list.add(new Book(itemID, title, author));

        }
//        Book b = new Book();
//        b.displayInfo();
//        for(int i: list)
//        {
//
//        }
        for(Book b: list)
        {
            b.displayInfo();
        }

    }
}