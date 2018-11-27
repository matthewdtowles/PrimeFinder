package PrimeFinder;

//package discussion6;

import java.util.Scanner;

/**
 *
 * @author matthew.towles
 */
public class PrimeFinder {

    private static int current = 2;
    private static int index = 1;
    
    /**
     * Check if given number is a prime
     * 
     * @param num
     * @return 
     */
    public static boolean isPrime(int num) {
        for (int i = 2; i <= (num / 2); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Find nth Prime number in set of primes
     * 
     * @param n - nth Prime number to find
     * @return the nth Prime number
     */
    public static int findPrime(int n) {      
        // base case:
        if (n == index) {
            return current;
        }
        
        // check next number
        current++;
        if (isPrime(current)) {
            // we found next prime, increment index
            index++;
        }

        return findPrime(n);
    }
    
    /**
     * Find nth Prime number in set of primes iteratively
     * 
     * @param n
     * @return 
     */
    public static int findPrimeIterative(int n) {
        while (index < n) {
            current++;
            if (isPrime(current)) {
                index++;
            }
        }
        return current;
    }
    
    /**
     * Returns difference in nanoseconds
     * @param start in nanoseconds
     * @param end in nanoseconds
     * @return  
     */
    public static long getRuntime(long start, long end) {
        return (end - start);
    }

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int n = 0;
        while (n < 1) {
            Scanner scannerIn = new Scanner(System.in);
            System.out.println("Enter number to find nth prime number (1+)");
            n = scannerIn.nextInt();
        }
        
        long startRec = System.nanoTime();
        int recursive = findPrime(n);
        long endRec = System.nanoTime();
        
        long startIter = System.nanoTime();
        int iterative = findPrimeIterative(n);
        long endIter = System.nanoTime();
        
        System.out.println("the prime at index number " + n + "(recursive): " 
                + recursive);
        System.out.println("recursive run time: " + getRuntime(startRec, endRec)
                + " nanoseconds");
        System.out.println("\nthe prime at index number " + n + "(iterative): " 
                + iterative);
        System.out.println("iterative run time: " + getRuntime(startIter, endIter) 
                + " nanoseconds");
    }
    
}
