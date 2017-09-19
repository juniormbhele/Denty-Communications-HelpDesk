package com.helpdesk;

import java.util.ArrayList;

/**
 * Created by Sphiwe.Mbhele on 2017/09/18.
 */
public class SumOfTwoIntegers {
    public static void main(String[] args) {
        ArrayList<Integer> total;
        total = new ArrayList<Integer>();
        int totalOfIntegers = 0;
        for (int number = 0; number < 100; number++) {

            if (number % 3 == 0) {
                total.add(number);
                totalOfIntegers = totalOfIntegers + number;
            } else if (number % 5 == 0) {
                total.add(number);
                totalOfIntegers = totalOfIntegers + number;
            }
        }

        System.out.print("The total of multiples of 3 and 5 under 10 is " + totalOfIntegers);
    }
}
