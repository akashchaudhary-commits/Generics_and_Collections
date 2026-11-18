import java.util.ArrayList;
import java.util.List; // why both imports?


//There are several situations where primitive data types
// are insufficient.
// Reason 1: Collections work with objects, not primitive types
// Reason 2: Wrapper Classes provide useful methods, primitive data type
// cannot call methods
// Reason 3: Wrapper Classes can represent the absence of a value
public class Wrapper_Class {
    public static void main(String[] args)
    {
//         List<int> list new ArrayList<>();// Compilation Error
        // Because Java collections such as ArrayList work with
        // reference types, not primitive types.

        // so we use wrapper class

         List<Integer> list  = new ArrayList<>();
         list.add(101);
         list.add(102);

         System.out.println(list);

//         int num = 101;
//         System.out.println(num.toString(num));

        Integer num = 101;
        System.out.println(num.toString());
        String str = "123";
        System.out.println(Integer.parseInt(str));
        System.out.println(Integer.valueOf(str));

        // Example code wrapper class methods
        // 1. toString()
        Integer num1 = 100;
        String strr = num1.toString();
        System.out.println("1. toString(): " + strr);

        // 2. compareTo()
        Integer a = 100;
        Integer b = 200;
        System.out.println("2. compareTo(): " + a.compareTo(b));


        // 3. equals()
        Integer x = 150;
        Integer y = 150;
        System.out.println("3. equals(): " + x.equals(y));


        // 4. parseInt()
        String value = "500";
        int number = Integer.parseInt(value);
        System.out.println("4. parseInt(): " + number);


        // 5. valueOf()
        Integer obj = Integer.valueOf("250");
        System.out.println("5. valueOf(): " + obj);

        // difference between Integer.parseInt() and Integer.valueOf()
        // Integer.parseInt() - return primitive int value
        // Integer.valueOf() - return wrapper object integer


        // int age = null; - compilation error

        Integer age = null;
        System.out.println(age);


        // Boxing in Java
        // converting primitive data type into wrapper class object
        int n = 100;
        Integer objj = Integer.valueOf(n);

        // Unboxing in java
        // converting wrapper class object in to primitive data types
        Integer obj1 = 102;
        int n2 = obj.intValue();
        System.out.println(n2);

        // Autoboxing - automatic convertion of primitive data type
        // into wrapper class object
        int n3 = 102;
        Integer obj4 = n3;

        // Auto-unboxing - automatic convertion of wrapper class object
        // in to primitive data types
        Integer obj5 = 106;
        int n4 = obj5;

    }
}
