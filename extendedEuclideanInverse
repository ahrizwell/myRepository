package moduloInverse;

import java.util.Scanner;

public class extendedEuclidean {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("A를 입력하세요.");
		int a = input.nextInt();
		System.out.println("B를 입력하세요.");
		int b = input.nextInt();

		int t[] = new int[100];
		t[0] = 0;
		t[1] = 1;
		int s[] = new int[100];
		s[0] = 1;
		s[1] = 0;

		int q[] = new int[100];
		int r[] = new int[100];
		r[0] = b;
		int divisor = a;
		int index = 0;
		for (int i = 1; i < 100; i++) {
			if (divisor != 0) {
				q[i] = r[i - 1] / divisor;
				r[i] = divisor;
				divisor = r[i - 1] % r[i];
			} else
				q[i] = 0;

			if (i >= 3) {
				t[i - 1] = t[i - 3] - q[i - 2] * t[i - 2];
				s[i - 1] = s[i - 3] - q[i - 2] * s[i - 2];
			}
			if (q[i] == 0) {
				index = i;
				break;
			}
		}
		if (t[index] > 0)
			System.out.println(a + " 의 모듈러 역원은 " + t[index - 1] + " 입니다.");
		else
			System.out.println(a + " 의 모듈러 역원은 " + (b + t[index - 1]) + " 입니다.");
	}
}
