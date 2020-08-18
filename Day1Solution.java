import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {



    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] nd = scanner.nextLine().split(" ");
        int rot_index;
        int size = Integer.parseInt(nd[0]);

        int rot = Integer.parseInt(nd[1]);

        int[] a = new int[size];
        int[] rot_arr = new int[size];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < size; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        for (int i = 0; i < size; i++) {
            rot_index = (i + size - rot) % size;
            rot_arr[rot_index] = a[i];
        }

        for(int i = 0; i< size; i++)    
          System.out.print(rot_arr[i] + " ");
        scanner.close();
    }
}
