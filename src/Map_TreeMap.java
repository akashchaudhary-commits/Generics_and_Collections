// Map Interface-
//The Map interface in Java is used to store data in the form
// of Key-Value pairs.

//Unlike ArrayList and Set, where we store individual elements,
//a Map stores two associated values:
// - Key: Used to identify or access a value.
// - Value: The actual data associated with that key.

// Map can contain duplicate values but not duplicate keys

// HashMap - a class that implements the Map interface
// It does not maintain insertion order.
// It does not allow duplicate keys.
// It allows duplicate values.
// It allows one null key.
// It allows multiple null values.


import java.util.*;

public class Map_TreeMap {
    public static void main(String[] args)
    {
        Map<Integer, String> map = new TreeMap<>();

        // insertion -
        map.put(1, "asdf");
        map.put(2, "qwer");
        map.put(3, "zxcv");
        map.put(4, "ghjkl");

        System.out.println("Map: " + map);

        // putAll - insert another map elements into other
        Map<Integer, String> map2 = new TreeMap<>();
        map2.put(5, "asdfy");
        map2.put(6, "qwery");
        map2.put(7, "zxcvy");
        map2.put(8, "ghjkly");
        System.out.println("Map2: " + map2);

        map.putAll(map2);
        System.out.println("Updated map : " + map);

        // deletion
        map.remove(4);
        System.out.println("Updated map : " + map);

        // size()
        System.out.println("Size: " + map.size());

        //putIfAbsent() - if mapping not present already then only put new mapping
        map.putIfAbsent(5, "asdfy");
        System.out.println("Updated map : " + map);
        map.putIfAbsent(10, "asdfy");
        System.out.println("Updated map : " + map);

        // accessing using key
        System.out.println(map.get(2));

        // getOrdefault() - if value not provided return default value
        // provide by user
        System.out.println(map.getOrDefault(11, "ghyt"));

        // containsKey() - search using key
        System.out.println(map.containsKey(5));

        // containsValue() - search using value
        System.out.println(map.containsValue("hjvbc"));

        // replace(k, v) - replace respective key value
        System.out.println(map.replace(4, "asdfgh"));

        // replace(k, old, new) - replace respective old key value with new
        System.out.println(map.replace(4, "zxcv", "scvcv"));

        // keySet() - returns a set of all keys present int the map
        Set<Integer> st = map.keySet();
        System.out.println(st);

        // keyValues() - returns a set of all values present in the map
        Collection<String> stv = map.values();
        System.out.println(stv);

        // entrySet() - returns a set of all key-values present in the map
        Set<Map.Entry<Integer, String>> entryset = map.entrySet();
        System.out.println(entryset);


        // Iterating over a Map
        for(Map.Entry<Integer, String> entryset2: map.entrySet())
        {
            System.out.println(entryset2.getKey() + " " + entryset2.getValue());
        }
    }
}