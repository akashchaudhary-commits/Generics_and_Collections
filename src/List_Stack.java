// Collection - an interface provided in java.util.pacakages

// - helps in managing , storing and manipulation different data structures

// provides the programmers diffrent types of data structures so that
// they dont have to built everthing from scratch.

import java.util.*;

public class List_Stack{
    public static void main(String[] args)
    {
        //List<Integer> stack = new Stack<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        System.out.println("Stack elements: " + stack);
        System.out.println("Removing from stack: " + stack.pop());
        System.out.println(stack.peek());
        System.out.println("Size of Stack: " + stack.size());
        System.out.println("Does 30 lie in stack: " + stack.contains(30));
        System.out.println("Is stack empty: "+ stack.isEmpty());

    }
}
