import java.util.Scanner;
import java.math.*;
public class RsaAlgorithm {
	public static Scanner sc = new Scanner(System.in);
	public static int gcd(int small, int large) {
		int remainder;
		while(true){
			remainder = large % small;
			if (remainder == 0) return small;
			large = small;
			small = remainder;
		}
	}

	public static int finde(int phiN) {
		int i = 2;
		while(i < phiN) {
			if (gcd(i,phiN) == 1) break;
			i++;
		}
		return i;
	}

	public static int findd(int e, int phiN) {
		int i = 2;
		while(true){
			if((i * e) % phiN == 1) break;
			i++;
		}
		return i;
	}

	public static void main(String args[]) {
		// let two prime numbers be p and q
		int p = 11;
		int q = 13;
		int n = p * q;
		int phiN = (p - 1) * (q - 1);
		int e = finde(phiN);
		int d = findd(e, phiN);
		int m = 15;
		//encryption

		BigInteger N = BigInteger.valueOf(n);
		BigInteger M = BigInteger.valueOf(m);
	 	BigInteger enc = M.pow(e).mod(N);
		System.out.println("Encypted text:" + enc);



		BigInteger dec = (enc.pow(d)).mod(N);
		System.out.println("Decrypted text:" + dec);
		// System.out.println("Enter the plaintext::");
		// String ptext = sc.next();
		// ptext = ptext.toUpperCase();
		// char [] pArr = ptext.toCharArray();
		// long [] nArr = new long [pArr.length];
		// for(int i = 0; i<pArr.length; i++) {
		// 	nArr[i] = (long) pArr[i];
		// 	nArr[i] = nArr[i] - 65 + 1;
		// 	System.out.println("your plain text is " + pArr[i] + " = " + nArr[i]);
		// }
		// System.out.print(nArr.length);
		// // encryption
		// long [] temp = new long [nArr.length];
		// for(int i= 0; i<nArr.length; i++) {
		// 	nArr[i] = Math.floorMod((int)Math.pow(nArr[i],e),n);
		// 	//System.out.println(nArr[i]);
		// 	temp[i] = (nArr[i] % 26);
		// 	System.out.println("Encypted text:"+ (char)(temp[i] + 65 - 1));
		// }
		//
		// //decryption
		// for(int i=0; i<nArr.length; i++) {
		// 	nArr[i] = Math.floorMod((int) Math.pow(nArr[i],d),n);
		// 	System.out.print(nArr[i]);
		// 	temp[i] = (nArr[i] % 26);
		// 	System.out.println(temp[i]);
		// 	System.out.println("Decrypted text:"+ (char)(temp[i] + 65 - 1));
		// }

	}
}
