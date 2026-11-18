//package Collections_Practice;
//import java.util.*;
//class Item{
//    protected String itemId;
//    protected String title;
//    Item(String itemId, String title)
//    {
//        this.itemId = itemId;
//        this.title = title;
//    }
//    void displayInfo()
//    {
//        System.out.println("ItemId: " + itemId);
//        System.out.println("Title: " + title);
//    }
//}
//class Book extends Item{
//    private String author;
//    Book(List<String> bookList) // just like  passing int[] arr as argument
//    {
//        super(bookList.get(0), bookList.get(1));// justlike arr[0], arr[1]
//        this.author = bookList.get(2);
//    }
//    @Override
//    void displayInfo()
//    {
//        super.displayInfo();
//        System.out.println("Author: " + author);
//    }
//}
//
//public class Ques1 {
//    public static void main(String[] args)
//    {
//        Scanner sc = new Scanner(System.in);
//        List<Book> books = new ArrayList<>();
//        int n = sc.nextInt();
//        sc.nextLine();
//        for(int i=0;i<n;i++)
//        {
//            System.out.println("Enter ItemId: " );
//            String itemId = sc.nextLine();
//            System.out.println("Enter Title: " );
//            String title = sc.nextLine();
//            System.out.println("Enter Author: " );
//            String author = sc.nextLine();
//            List<String> booklist = new ArrayList<>();
//            booklist.add(itemId);
//            booklist.add(title);
//            booklist.add(author);
//            Book b = new Book(booklist);// just like Book b = new Book(itemId, title, author);
//            books.add(b);
//
//            //b.displayInfo();
//        }
//        for(Book b : books)
//        {
//            b.displayInfo();
//        }
//
//    }
//}
