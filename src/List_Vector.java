// Collection - an interface provided in java.util.pacakages

// - helps in managing , storing and manipulation different data structures

// provides the programmers diffrent types of data structures so that
// they dont have to built everthing from scratch.

import java.util.*;

public class List_Vector{
    public static void main(String[] args)
    {
//        Collection<Integer> lis2 = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        Vector<Integer> list = new Vector<>();

        // Adding Elemennts
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);

        System.out.println(list);

        // adding at Specific positions
        list.add(3, 45);
        System.out.println("After Adding at index 3: " + list);

        list.addFirst(46);
        list.addLast(68);
        System.out.println("Adding first and last: " + list);

        System.out.println("get first and Get last: ");
        System.out.println(list.getFirst());
        System.out.println(list.getLast());


        // accessing an element
        System.out.println("get method: ");
        System.out.println(list.get(3));

        // set() - replace a particular element
        list.set(3, 60);
        System.out.println("USing set methos: " + list);

        //remove() - to delete an element
        list.remove(3);
        list.remove(Integer.valueOf(40));
        System.out.println("After removing: "+ list);

        // contains() - searches for an element
        System.out.println("element in list found: " + list.contains(19));

        // addAll() - merging two list elements into one another
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(70);
        list2.add(80);
        list2.add(10);
        list2.add(20);
        System.out.println("List: " + list);
        System.out.println("List2: " + list2);

        list.addAll(list2);
        System.out.println("Mergedlist: " + list);

        // retainAll() - to find common elements in the list
//        list.retainAll(list2);
//        System.out.println("list after intersectio: " + list);

        //sublist() - get particular range elements
        System.out.println("List from 2 to 5" + list.subList(2, 5));

        // toArray() to convert list into array
        Object[] arr = list.toArray();
        System.out.println("After converting to array: " + list);
        for(int i=0;i<arr.length;i++)
        {
            System.out.println(arr[i]);
        }

        System.out.println("list : " + list);
        Collections.sort(list);
        System.out.println("List in Ascending order: " + list);
        Collections.sort(list, Collections.reverseOrder());
        System.out.println("List in descending order: " + list);





    }
}