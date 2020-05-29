package java_coding_challenges;

public class JCC5_ReverseInteger {
    public static void main(String[] args) {

        //handling a positive integer
        System.out.println(reverseInteger(12345));

        //handling a negative integer
        System.out.println(reverseInteger(-689801));

        //handling overflow by returning 0
        System.out.println(reverseInteger(2140928343));
    }

    private static int reverseInteger(int input) {

        long reversed = 0;
        while (input != 0) {
            reversed = reversed * 10 + input % 10;
            input /= 10;
        }
        if (reversed > Integer.MAX_VALUE || reversed < Integer.MIN_VALUE) {
            return 0;
        }
        //we can return an int, having cast out value into one, since we previously checked
        //it's within the min-max range of values for int
        return (int) reversed;
    }
}
