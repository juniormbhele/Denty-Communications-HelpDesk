package com.helpdesk;

/**
 * Created by Sphiwe.Mbhele on 2017/09/18.
 */
public class PrimeNumber {
    public static boolean checkIfPrime(int values) {
        if (values == 2) {
            return true;
        }
        if (values % 2 == 0 || values == 1) {
            return false;
        }

        long limit = (long) Math.sqrt(values);
        for (int i = 3; i <= limit; i += 2) {
            if (values % i == 0) {
                return false;
            }

        }
        return true;
    }

    public static void main(String args[]) {
        int count = 1;
        int i = 3;
        while (count < 1001) {
            if (checkIfPrime(i)) ++count;
            {
                i += 2;
            }
        }

        i = i - 2;
        System.out.println("10001st prime number is " + i);
    }
}
