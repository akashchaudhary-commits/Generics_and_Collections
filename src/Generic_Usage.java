// Generics - Used for creating classes , methods and interfaces
// with different data types .

// Using Object class
//class Demo{
////    private int id;
////    private String name;
////    private boolean isValid;
////    private double marks;
////    private Object data;
//    Object data;
//    Demo(Object data)
//    {
//
////        this.id = id;
////        this.name = name;
////        this.isValid = isValid;
////        this.marks = marks;
//
//        this.data = data;
//    }
//    public Object getData()
//    {
//
//        return data;
//    }
//}
//public class Generic_Usage{
//    public static void main(String[] args)
//    {
//        Demo d = new Demo(101);
////        int a = (Integer)d.getData(); // Have to explicitly type cast
////        System.out.println(a);
//        d.data = "Akash";// Type safety;
//
//        //System.out.println(d.getData());
//        Demo d1 = new Demo("Akash");
//        System.out.println(d1.getData());
//        Demo d2 = new Demo(true);
//        System.out.println(d2.getData());
//        Demo d3 = new Demo(86.565);
//        System.out.println(d3.getData());
//
//    }
//}
//Problems with Object class
// 1.Java doesnt automatically typecast data types
// 2. Data Type Safety

class Demo<T>{
    //    private int id;
//    private String name;
//    private boolean isValid;
//    private double marks;
//    private Object data;
    T data;
    Demo(T data)
    {

//        this.id = id;
//        this.name = name;
//        this.isValid = isValid;
//        this.marks = marks;

        this.data = data;
    }
    public T getData()
    {
        return data;
    }
}
public class Generic_Usage{
    public static void main(String[] args)
    {
        Demo<Integer> d = new Demo<>(101);
        int a = d.getData(); // No need to Explicitly type cast
        System.out.println(a);
        //d.data = "Akash";// Type safety;

        //System.out.println(d.getData());
        Demo<String> d1 = new Demo<>("Akash");
        System.out.println(d1.getData());
        Demo<Boolean> d2 = new Demo<>(true);
        System.out.println(d2.getData());
        Demo<Double> d3 = new Demo(86.565);
        System.out.println(d3.getData());

    }
}