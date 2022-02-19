package com.vamshi.proj;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {

	private static final Long UPPERLIMIT = 10000L;
	private static final Long LOWERLIMIT = 1L;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("please enter a number for Narcissistic Generator");
		Long num = sc.nextLong();
		if (num >= UPPERLIMIT || num <= LOWERLIMIT) {
			System.out.println("please enter number in between " + LOWERLIMIT + " and" + UPPERLIMIT);
		} else {
			if (verify(num)) {
				System.out.println("the given number is Narcissistic number");
			} else {
				System.out.println("the given number is not a Narcissistic number");
			}
		}
	}

	static boolean verify(Long num) {
		String number = String.valueOf(num);
		int length = number.length();
		int sum = 0;
		for (int i = 0; i < length; i++) {
			sum = sum + (int) Math.pow(number.charAt(i) - '0', length);
		}
		return (num == sum);
	}
}
