import java.util.*;
public class Set_HashSet {
    public static void main(String[] args)
    {
        Set<Integer> hashset = new HashSet<>();

        hashset.add(69);
        hashset.add(20);
        hashset.add(40);
        hashset.add(45);
        hashset.add(60);
        hashset.add(16);
        System.out.println(hashset);

        // addall
        Set<Integer> hashset2 = new HashSet<>();
        hashset2.add(70);
        hashset2.add(71);
        hashset2.add(72);
        hashset2.add(73);
        hashset.addAll(hashset2);
        System.out.println(hashset);


        //remove()
        hashset.remove(71);
        System.out.println(hashset);


        //contains()
        System.out.println(hashset.contains(71));


        //retainall()
        System.out.println("Hashset: " + hashset);
        System.out.println("hashset2: " + hashset2);
        hashset.retainAll(hashset2);
        System.out.println("After intersection; " + hashset);


        //size()
        System.out.println(hashset.size());


        //isEmpty()
        System.out.println(hashset.isEmpty());

        // hashcode()
        // returns a hashcode value(address of element in the set)
        // used to access elements randomly

        //1. Java calls hashCode() for the object being added.
        //2. HashSet uses the hash code to determine the appropriate bucket.
        //3. If another object is already in that bucket, HashSet uses equals()
        // to check whether the values are equal.
        //4. If an equal element already exists, it does not add the duplicate.

        Set<Integer> set1 = new HashSet<>();
        set1.add(11);
        set1.add(20);
        set1.add(35);

        System.out.println("HashSet: " + set1);
        System.out.println("HashCode of 10: " + Integer.valueOf(11).hashCode());
        System.out.println("HashCode of 20: " + Integer.valueOf(20).hashCode());
        System.out.println("HashCode of 30: " + Integer.valueOf(35).hashCode());
        System.out.println("HashCode of HashSet: " + set1.hashCode());


    }
}