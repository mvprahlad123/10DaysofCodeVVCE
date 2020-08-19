import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Day1Solution{

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] nd = scanner.nextLine().split(" ");

        int size = Integer.parseInt(nd[0]);

        int rot = Integer.parseInt(nd[1]);

        int[] arr = new int[size];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < size; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            arr[i] = aItem;
        }

        for(int count = 0; count < rot; count++) {
            
            int temp = arr[0];

            for (int i = 0, j = 1; i < size && j < size; i++, j++) 
                arr[i] = arr[j];            
            
            arr[size-1] = temp;
        }

        for(int i = 0; i< size; i++)    
          System.out.print(arr[i] + " ");
        System.out.println();
        scanner.close();
    }
}
