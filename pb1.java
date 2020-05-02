package infoTheory;

import java.io.*;
import java.util.*;

public class pb1 {
	public static void main(String[] args) {
		/*
		 * 1번문제
		 */
		int dimension = 0; // 차수
		String dividor = ""; // 계수

		System.out.println("---------------------1번 문제---------------------");
		Scanner input = new Scanner(System.in);
		System.out.println("차수를 입력하세요.");
		dimension = input.nextInt();

		System.out.println("계수를 입력하세요.");
		dividor = input.next();

		int sqrt = (int) Math.pow(2, dimension); // 총 계산횟수
		int toB = 0;

		for (int i = 0; i <= dimension; i++) {
			if (dividor.charAt(i) == '1')
				toB += (int) Math.pow(2, (dimension - i));
		}

		byte divisor = (byte) toB;

		byte multi[] = new byte[sqrt];
		multi[0] = 0;
		for (int i = 1; i < sqrt; i++)
			multi[i] = (byte) Math.pow(2, i - 1);

		for (int i = dimension + 1; i < sqrt; i++) {
			int counter = dimension;

			while (multi[i] >= Math.pow(2, dimension)) {
				byte b = divisor;
				if (multi[i] > Math.pow(2, counter)) {
					counter++;
				} else {
					if (counter - dimension <= 0)
						counter = dimension;
					else
						counter--;
					b = (byte) (b << counter - 3);
					multi[i] = (byte) (multi[i] ^ b);
					counter = dimension;
				}
			}
		}

		for (int i = 0; i < sqrt; i++) {
			String bts = Integer.toBinaryString(multi[i]);
			if (i == 0)
				System.out.print(0 + " = ");
			else if (i == 1)
				System.out.print(1 + " = ");
			else
				System.out.print("a" + (i - 1) + " = ");

			for (int j = bts.length() - 1; j >= 0; j--) {
				System.out.print(bts.charAt(j));
			}

			for (int j = 0; j < 3 - bts.length(); j++)
				System.out.print("0");

			System.out.println();
		}

		/*
		 * 2번문제
		 */

		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("---------------------2번 문제---------------------");
		System.out.println("Multiplicative Representation을 할 A 값을 입력해주세요.");
		String aIn = input.next();
		System.out.println("Multiplicative Representation을 할 B 값을 입력해주세요.");
		String bIn = input.next();
		int aInt = Integer.parseInt(String.valueOf(aIn.charAt(1)));
		int bInt = Integer.parseInt(String.valueOf(bIn.charAt(1)));
		byte total = (byte) (multi[aInt + 1] ^ multi[bInt + 1]);

		int index = 0;
		for (int i = 0; i < sqrt; i++) {
			if (multi[i] == total)
				index = i;
		}

		System.out.print("답은 a" + (index - 1) + ", ");
		String bts = Integer.toBinaryString(multi[index]);
		for (int j = bts.length() - 1; j >= 0; j--) {
			System.out.print(bts.charAt(j));
		}
		for (int j = 0; j < 3 - bts.length(); j++)
			System.out.print("0");
		System.out.println(" 입니다.");
		/*
		 * 3번문제
		 */

		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("---------------------3번 문제---------------------");
		System.out.println("Additive Representation을 할 A 값을 입력해주세요.");
		String aIn1 = input.next();
		System.out.println("Additive Representation을 할 B 값을 입력해주세요.");
		String bIn1 = input.next();
		int aInt1 = Integer.parseInt(String.valueOf(aIn1.charAt(1)));
		int bInt1 = Integer.parseInt(String.valueOf(bIn1.charAt(1)));
		int t = (aInt1 + bInt1) % sqrt;

		System.out.print("답은 a" + (t + 1) + ", ");
		
		String bts1 = Integer.toBinaryString(multi[t +2]);
		for (int j = bts1.length() - 1; j >= 0; j--) {
			System.out.print(bts1.charAt(j));
		}
		for (int j = 0; j < 3 - bts1.length(); j++)
			System.out.print("0");
		System.out.println(" 입니다.");
	}
}
