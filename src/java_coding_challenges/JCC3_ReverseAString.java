package java_coding_challenges;

public class JCC3_ReverseAString {
    public static void main(String[] args) {

        System.out.println(reverseStringWithStringBuilder("Something"));
        System.out.println(reverseStringWithStringBuilder("Nothing"));
        System.out.println(reverseStringWithStringBuilder("brotherhood"));
        System.out.println(reverseStringWithStringBuilder("brotherhood"));

        System.out.println(reverseStringManual("Something"));
        System.out.println(reverseStringManual("Nothing"));
        System.out.println(reverseStringManual("brotherhood"));
    }

    private static String reverseStringWithStringBuilder(String s) {

        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }


    private static String reverseStringManual(String s) {

        char[] chars = new char[s.length()];
        for (int i = 0, j = s.length() - 1; j >= 0; i++, j--) {
            chars[i] = s.charAt(j);
        }
        return new String(chars);
    }
}
