package primeNumbers;

import java.util.*;
import java.io.*;

/**
 * 
 * @author Bunrith Seng
 * due date: 10/10/2017
 * Implementation in Java for Sieve of Eratosthenes
 *finding all the prime numbers upto upper bound
 *print output to file
 */	

/**
 * 
 * @param args
 * main function to print out the prime numbers
 * as well as to print out to the output.txt
 */

public class sievePrimes {
	
public static void main(String[] args) {
	
	Scanner scanner = new Scanner(System.in);
	System.out.println("Enter an upper bound number: ");
	int maxNum = scanner.nextInt();
	sievePrimes prime = new sievePrimes();
	System.out.println("Prime number are: ");
	String str = prime.getPrimes(maxNum);
	
	
	FileWriter writer = null;
	BufferedWriter bwriter = null;
	try {
		writer = new FileWriter("D:\\MyJava\\PrimeNumbers\\output.txt");
		bwriter = new BufferedWriter(writer);
		bwriter.write(str);
		bwriter.close();
	}catch (IOException e1) {	
		System.err.println("Error.." + e1.getMessage());
	}
}


/**
 * 
 * @param maxNum
 * @return
 * Calculate to get prime numbers
 */


	
	public String getPrimes(int maxNum) {
		
		boolean[] isPrime = new boolean[maxNum + 1];
		Arrays.fill(isPrime, true);

		int primeRange = (int) Math.sqrt(maxNum);
		for (int number = 2; number <= primeRange; number++) {
			if (isPrime[number]) {
				for (int i = number * number; i <= maxNum; i += number) {
					isPrime[i] = false;
				}
			}
		}
		
		String str = "";
		for(int number = 2; number < maxNum; number++) {
			if(isPrime[number]) {
				System.out.println(number);
				str += number + " ";
			}
		}
		
		return str;
	}
}