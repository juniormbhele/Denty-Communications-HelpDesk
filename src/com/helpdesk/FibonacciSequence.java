package com.helpdesk;

/**
 * Created by Sphiwe.Mbhele on 2017/09/18.
 */
public class FibonacciSequence {
    public static void main(String[] args) {
        int rangeLimit = 4000000;
        int sumOflastTwoNumber = 0;
        int currentNumber = 1;
        int previousNumber = 0;
        int evenNumbersSum = 0;
        while (evenNumbersSum < rangeLimit) {
            sumOflastTwoNumber = previousNumber + currentNumber;
            previousNumber = currentNumber;
            currentNumber = sumOflastTwoNumber;
            if (sumOflastTwoNumber % 2 == 0) {
                evenNumbersSum = evenNumbersSum + sumOflastTwoNumber;
            }
        }
        System.out.println("This is the sum of the last two numbers " + sumOflastTwoNumber);
        System.out.println("This is the sum of the even numbers " + evenNumbersSum);
    }
}
