import java.math.BigInteger;
import java.util.Scanner;

public class Day9Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int lim = scan.nextInt();
		for (int count = 0; count < lim; count++) {
			int A = scan.nextInt();
			int B = scan.nextInt();
			int X = scan.nextInt();

			System.out.println(solve(A, B, X));
		}

		scan.close();
	}

	static int solve(int A, int B, int X) {
		if (B >= 0) {
			return powerMod(A, B, X);
		} else {
			return powerMod(inverseMod(A, X), -B, X);
		}
	}

	static int powerMod(int base, int exp, int mod) {
		int res = 1;
		while (exp != 0) {
			if ((exp & 1) != 0) {
				res = multiplyMod(res, base, mod);
			}

			base = multiplyMod(base, base, mod);
			exp >>= 1;
		}
		return res;
	}

	static int multiplyMod(int x, int y, int mod) {
		return (int) ((long) x * y % mod);
	}

	static int inverseMod(int x, int mod) {
		return BigInteger.valueOf(x).modInverse(BigInteger.valueOf(mod)).intValue();
	}
}