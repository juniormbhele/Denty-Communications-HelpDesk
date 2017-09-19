package com.helpdesk;

import java.util.Scanner;

/**
 * Created by Sphiwe.Mbhele on 2017/09/18.
 */
public class ReversingSentence {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Please enter your sentence: ");
        String sentence = scan.nextLine();


        String[] words = sentence.split(" ");
        String reversedSentence = "";
        for (int i = words.length - 1; i >= 0; i--) {
            reversedSentence += (words[i] + " ");
        }
        System.out.println(reversedSentence.trim());
    }
}
