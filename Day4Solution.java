import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


public class Solution {
    public static void main(String[] args) {
       
            Scanner scan = new Scanner(System.in);
            int size = scan.nextInt();
            
            Stack<Integer> stackA = new Stack<Integer>();
            Stack<Integer> stackB = new Stack<Integer>();
            
            int choice;
            
            for (int i = 0 ; i < size ; i++) {
                choice = scan.nextInt();

                switch (choice) {
                    case 1:
                        stackA.push(scan.nextInt());
                        break;

                    case 2:

                        if(stackB.isEmpty())

                            while(!stackA.isEmpty())
                                stackB.push(stackA.pop());

                        if(!stackB.isEmpty())
                            stackB.pop();

                                break;
                    
                    case 3:

                        if (stackB.isEmpty()) {

                            while(!stackA.isEmpty())
                                stackB.push(stackA.pop());

                            System.out.println(stackB.peek());

                        } else

                            System.out.println(stackB.peek());
                        
                        break;
                    default:
                        break;
                    
                }
                
            }
            scan.close();
        }       
}  
