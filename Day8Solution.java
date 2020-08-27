import java.io.*;
import java.util.*;
import java.math.BigInteger;
import java.util.Map.Entry;

import static java.lang.Math.*;

public class Day8Solution extends PrintWriter {
    static Scanner scanner = new Scanner(System.in);


    void run() {

        int m = 100001;

        boolean[] isPrime = new boolean[m];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 0; i * i < m; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < m; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int[] less = new int[m];
        for (int i = 1; i < m; i++) {
            less[i] = less[i - 1];
            if (isPrime[i]) {
                ++less[i];
            }
        }

        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();

            if (less[n] % 2 == 0) {
                println("Bob");
            } else {
                println("Alice");
            }
        }

    }

    int[][] nextMatrix(int n, int m) {
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                matrix[i][j] = scanner.nextInt();
        return matrix;
    }

    String next() {
        while (!tokenizer.hasMoreTokens())
            tokenizer = new StringTokenizer(scanner.nextLine());
        return tokenizer.nextToken();
    }

    boolean hasNext() {
        while (!tokenizer.hasMoreTokens()) {
            String line = scanner.nextLine();
            if (line == null) {
                return false;
            }
            tokenizer = new StringTokenizer(line);
        }
        return true;
    }

    int[] nextArray(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        return array;
    }

    public Day8Solution(OutputStream outputStream) {
        super(outputStream);
    }

    static BufferedReader reader;
    static StringTokenizer tokenizer = new StringTokenizer("");
    static Random rnd = new Random();

    public static void main(String[] args) throws IOException {
        reader = new BufferedReader(new InputStreamReader(System.in));
        Day8Solution solution = new Day8Solution(System.out);
        solution.run();
        solution.close();
        reader.close();
    }
}