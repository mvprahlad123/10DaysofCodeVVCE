import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Day3Solution {
    
    /*
     * Complete the equalStacks function below.
     */
    static int equalStacks(int[] h1, int[] h2, int[] h3, int n1, int n2, int n3) {
        /*
         * Write your code here.
         */ 
        Stack<Integer> stackA = new Stack<Integer>();
		Stack<Integer> stackB = new Stack<Integer>();
		Stack<Integer> stackC = new Stack<Integer>();

		int stackAValue = 0, stackBValue = 0, stackCValue = 0;

		
		for (int i = h1.length - 1; i >= 0; i--) {
			stackAValue += h1[i];
			stackA.push(stackAValue);
		}
		for (int i = h2.length - 1; i >= 0; i--) {
			stackBValue += h2[i];
			stackB.push(stackBValue);
		}
		for (int i = h3.length - 1; i >= 0; i--) {
			stackCValue += h3[i];
			stackC.push(stackCValue);
		}

		while (true) {

			
			if (stackA.isEmpty() || stackB.isEmpty() || stackC.isEmpty())
				return 0;

			stackAValue = stackA.peek();
			stackBValue = stackB.peek();
			stackCValue = stackC.peek();

			// If sum of all three stack are equal.
			if (stackAValue == stackBValue && stackBValue == stackCValue)
				return stackAValue;

			if (stackAValue >= stackBValue && stackAValue >= stackCValue)
				stackA.pop();
			else if (stackBValue >= stackAValue && stackBValue >= stackCValue)
				stackB.pop();
			else if (stackCValue >= stackBValue && stackCValue >= stackAValue)
				stackC.pop();
		}
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] n1N2N3 = scanner.nextLine().split(" ");

        int n1 = Integer.parseInt(n1N2N3[0].trim());

        int n2 = Integer.parseInt(n1N2N3[1].trim());

        int n3 = Integer.parseInt(n1N2N3[2].trim());

        int[] h1 = new int[n1];

        String[] h1Items = scanner.nextLine().split(" ");

        for (int h1Itr = 0; h1Itr < n1; h1Itr++) {
            int h1Item = Integer.parseInt(h1Items[h1Itr].trim());
            h1[h1Itr] = h1Item;
        }

        int[] h2 = new int[n2];

        String[] h2Items = scanner.nextLine().split(" ");

        for (int h2Itr = 0; h2Itr < n2; h2Itr++) {
            int h2Item = Integer.parseInt(h2Items[h2Itr].trim());
            h2[h2Itr] = h2Item;
        }

        int[] h3 = new int[n3];

        String[] h3Items = scanner.nextLine().split(" ");

        for (int h3Itr = 0; h3Itr < n3; h3Itr++) {
            int h3Item = Integer.parseInt(h3Items[h3Itr].trim());
            h3[h3Itr] = h3Item;
        }

        int result = equalStacks(h1, h2, h3, n1-1, n2-1, n3-1);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}