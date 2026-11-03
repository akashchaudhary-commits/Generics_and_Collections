import java.util.*;

public class List_LinkedList{
    public static void main(String[] args)
    {
        LinkedList<String> fruits = new LinkedList<>();

        // Adding Elements -
        fruits.add("Mango");
        fruits.add("Apple");
        fruits.add("Grapes");
        fruits.add("Banana");

        System.out.println(fruits);

        // adding at specific locations
        fruits.add(2, "Orange");
        fruits.addFirst("Kiwi");
        fruits.addLast("PineApple");
        System.out.println(fruits);

        // accessing Elements
        System.out.println(fruits.get(2));
        System.out.println(fruits.getFirst());
        System.out.println(fruits.getLast());

        //set - replace element
        fruits.set(2, "Chiku");
        System.out.println(fruits);

        // remove() - delete the element from the list
        fruits.remove(2);
        fruits.removeFirst();
        fruits.removeLast();
        System.out.println(fruits);

        //searching for an element
        System.out.println(fruits.contains("Kiwi"));

        // Implementing Queue operation -

//        // peek to get the first element
//        System.out.println(fruits.peek());
//        // poll() - to get and remove the first element
//        fruits.poll();
//        System.out.println(fruits);


    }
}