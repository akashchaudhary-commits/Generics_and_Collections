// Collection - an interface provided in java.util.pacakages

// - helps in managing , storing and manipulation different data structures

// provides the programmers diffrent types of data structures so that
// they dont have to built everthing from scratch.

import java.util.*;

public class List_ArrayList{
    public static void main(String[] args)
    {
//        Collection<Integer> lis2 = new ArrayList<>();
//        List<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();

        // Adding Elemennts
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);

        System.out.println(list);

        // adding at Specific positions
        list.add(3, 45);
        System.out.println(list);

        // accessing an element
        System.out.println(list.get(3));

        // set() - replace a particular element
        list.set(3, 60);
        System.out.println(list);

        //remove() - to delete an element
        list.remove(3);
        list.remove(Integer.valueOf(40));
        System.out.println(list);

        // contains() - searches for an element
        System.out.println(list.contains(19));

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
        System.out.println(list.subList(2, 5));

        // toArray() to convert list into array
        Object[] arr = list.toArray();
        System.out.println(list);
        for(int i=0;i<arr.length;i++)
        {
            System.out.println(arr[i]);
        }

        // sort() - to sort list
        Collections.sort(list2);
        System.out.println(list2);
        Collections.sort(list2, Collections.reverseOrder());
        System.out.println(list2);



    }
}