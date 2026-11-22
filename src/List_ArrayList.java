// Collection - an interface provided in java.util.pacakages

// - helps in managing , storing and manipulation different data structures

// provides the programmers diffrent types of data structures so that
// they dont have to built everthing from scratch.

import java.util.*;

public class List_ArrayList {
    public static void main(String[] args)
    {
        //Collection<Integer> list = new ArrayList<>();
        //List<Integer> list = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(79);
        list.add(3);
        list.add(54);
        System.out.println(list);

        // add at any Index -
        list.add(1,5);
        System.out.println("After insertion: " + list);

        // get() - access an element
        System.out.println("Element at Index 2: " + list.get(2));

        // set() - update an element
        list.set(0, 10);
        System.out.println("Updated list: " + list);

        // remove() - remove n element by index
        list.remove(3);
        System.out.println("After removing: " + list);

        // contains() - search for an element
        System.out.println("Contains 30: " + list.contains(30));

        // size - find the size of the list
        System.out.println("Size of list: " + list.size());

        // traverse the list
        for(int i:list)
        {
            System.out.println(i);
        }

        //addAll() - add one list elements to other
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(57);
        list2.add(48);
        list2.add(56);
        System.out.println("List2: " + list2);
        list.addAll(list2);
        System.out.println("list1 + list2: " + list);

        // removeAll - the other list elements
//        list.removeAll(list2);
//        System.out.println(list);

        // retainAll() - retain common elements
        list.retainAll(list2);
        System.out.println(list);

        // to Array() - converts list into array
        list2.toArray();
        System.out.println("List 2 Array: " + list2);

        // subList(from , to)
        System.out.println("List from 0 to 2 " + list.subList(0, 2));


        // Traversing the ArrayList -
        // 1. Using a for loop -
        System.out.println("USing For loop");
        for(int i=0;i<list.size();i++)
        {
            System.out.println(list.get(i));
        }

        // Using for - each loop
        System.out.println("USing For-each loop");
        for(int i: list)
        {
            System.out.println(i);
        }

        // USing Iterator
        // import java.util.Iterator
        list.add(79);
        list.add(3);
        list.add(54);
        System.out.println("USing Iterator");
        Iterator<Integer> itr = list.iterator();
//        while(itr.hasNext())
//        {
//            System.out.println(itr.next());
//        }
        System.out.println("List before remove: " + list);
//        for(int i: list)
//        {
//            if(i==48)
//            {
//                list.remove(Integer.valueOf(i));
//            }
//        }
//        System.out.println("List after removng: " + list);


        System.out.println("Remove using Iterator: ");
        while(itr.hasNext())
        {
            if(itr.next() == 48){
                itr.remove();
            }
        }
        System.out.println(list);
    }
}