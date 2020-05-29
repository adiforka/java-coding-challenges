package java_coding_challenges;

public class JCC6_IntegerToRomanNumeral {
    public static void main(String[] args) {

        System.out.println(intToRomanNum(2537));
        System.out.println(intToRomanNum(3313));
    }

    private static String intToRomanNum(int input) {

        String[] thousands =
                {"", "M", "MM", "MMM"};
        String[] hundreds =
                {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] tens =
                {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] units =
                {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};


        return thousands[input / 1000] +
                hundreds[(input %= 1000) / 100] +
                tens[(input %= 100) / 10] +
                units[input % 10];
    }
}
