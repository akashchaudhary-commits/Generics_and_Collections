// Set Interface - used to store and access data randomly

// Duplicate values are not allowed

// HashSet - class Used to implement Set Interface

import java.util.HashSet;
import java.util.Set;

public class Set_HashSet {
    public static void main(String[] main)
    {
        Set<Integer> set1 = new HashSet<>();
        //HashSet<Integer> set2 = new HashSet<>();

        // insertion order is not maintained
        set1.add(24);
        set1.add(56);
        set1.add(47);
        set1.add(27);
        set1.add(78);
        System.out.println("Set1:  " + set1);

        // addAll() -
        Set<Integer> set2 = new HashSet<>();
        //HashSet<Integer> set2 = new HashSet<>();

        // insertion order is not maintained
        set2.add(57);
        set2.add(1);
        set2.add(24);
        set2.add(3);
        set2.add(4);
        System.out.println("Set 2: " + set2);

        set1.addAll(set2);
        System.out.println("Set 1 after adding Set2: " + set1);

        // delete -
        set2.remove(24);
        System.out.println("Set 2 after removing 24: " + set2);

        // contains() - search an element
        System.out.println(set1.contains(35));

        // retainAll()  - intersection of two sets
        System.out.println("Set 1: " + set1);
        System.out.println("Set2 : " + set2);
        //set1.retainAll(set2);
        System.out.println("After Intersection: " + set1);

        //containsAll() -
        System.out.println("Set 1: " + set1);
        System.out.println("Set 2: " +set2);
        System.out.println(set1.containsAll(set2));

        // size()  - length
        System.out.println("Size of set1 : " + set1.size());

        // isEmpty - checks if set is empty or not
        System.out.println(set1.isEmpty());

        // hashcode()
        set2.add(56);

        System.out.println("Hashcode of 56 in Set 1: "+ Integer.valueOf(56).hashCode());
        System.out.println("Hashcode of 56 in Set 2: " + Integer.valueOf(56).hashCode());
        System.out.println("HashCode of Set1: " + set1.hashCode());

        Set<String> set3 = new HashSet<>();
        set3.add("123");
        System.out.println("HashCode of akash in set3: " + Integer.valueOf("123").hashCode()) ;






    }
}