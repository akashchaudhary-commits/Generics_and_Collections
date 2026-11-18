// Set Interface - used for random storage and insertion of elements
// avoiding data duplicacy

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Set_TreeSet {
    public static void main(String[] args)
    {
        Set<Integer> set1 = new TreeSet<>();
        // TreeSet<Integer> set1 = new TreeSet<>();

        // insertion // adds data in random order
        set1.add(45);
        set1.add(13);
        set1.add(67);
        set1.add(24);
        set1.add(24);
        set1.add(58);
        System.out.println(set1);


        // addAll()
        Set<Integer> set2 = new TreeSet<>();
        set2.add(73);
        set2.add(71);
        set2.add(76);
        set2.add(73);
        set2.add(78);
        set1.addAll(set2);
        System.out.println("Set 1: " + set1);
        System.out.println("Set 2: " + set2);

        // retainAll() - intersection of two collections
        System.out.println("Set 1: " + set1);
        System.out.println("Set 2: " + set2);
        set1.retainAll(set2);
        System.out.println("After InterSection: " + set1);

        // containsAll() -
        set2.add(47);
        set2.add(86);
        set2.remove(71);// to delete an element
        System.out.println("Set 1: " + set1);
        System.out.println("Set 2: " + set2);
        System.out.println(set2.containsAll(set1));

        // size()
        System.out.println(set1.size());
        System.out.println(set2.size());

        // isEmpty()
        System.out.println(set1.isEmpty());

        // hashcode() - returns hashcode value(address of element in list)
        System.out.println("Set 1: " + set1);
        System.out.println(("Hashcode of 73: " + Integer.valueOf(73).hashCode()));
        System.out.println("HashCode of Set1: " + set1.hashCode());

    }
    // Internal Working of Sets
    // 1.Java calls hashcode() for object to be added
    // 2. HashSet uses the hashcode to check for appropriate hashtable
    // 3. If another object is already in the Hashtable, check using equals()
    // 4. then does not add the element in the hashtable
}