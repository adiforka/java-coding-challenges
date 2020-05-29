package java_coding_challenges;

import java.util.*;

public class JCC1_FizzBuzz {
    public static void main(String[] args) {

        //print a list of numbers 1 to 100, one per line. if the number is a multiple of 3, print Fizz
        //instead of that number. if the number is a multiple of 5, print Buzz instead of the number.
        //if the number is a multiple of both 3 and 5, print FizzBuzz instead of the number.
        fizzBuzz(100);

    }

    public static void fizzBuzz(int n) {

        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("FizzBuzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            }
            else System.out.println(i);
        }
    }
}
