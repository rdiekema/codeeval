package org.diekema.codeeval.primepalindrome;

public class Main {

    public static void main(String[] args) {
        int largestPrime = 0;
        for (int i = 1; i < 1000; i++) {

            if (isPrime(i) && isPalindrome(i) && i > largestPrime) {
                largestPrime = i;
            }
        }

        System.out.println(largestPrime);
    }

    public static boolean isPalindrome(int number) {
        String numberString = Integer.toString(number);
        String reverseString = new StringBuilder(numberString).reverse().toString();

        for (int i = 1; i < numberString.length(); i++) {
            if (numberString.charAt(i) != reverseString.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    public static boolean isPrime(int n) {
        if (n > 2 && (n & 1) == 0) {
            return false;
        }

        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}
