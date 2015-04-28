package org.diekema.codeeval.sumofprimes;

/**
 * Created by rdiekema on 4/27/15.
 */
public class Main {
    public static void main(String[] args) {
        int countOfPrimes = 0;
        int sumOfPrimes = 0;

        for(int i = 2; countOfPrimes < 1000; i++){
            if(isPrime(i)){
                sumOfPrimes += i;
                countOfPrimes++;
            }
        }



        System.out.println(sumOfPrimes);
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
