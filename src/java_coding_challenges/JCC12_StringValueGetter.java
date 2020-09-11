package java_coding_challenges;

import java.util.ArrayList;
import java.util.List;

/*
Given a string "abc" and assuming that each letter in the string has a value equal to its position
in the alphabet, our string will have a value of 1 + 2 + 3 = 6. This means that: a = 1, b = 2, c = 3 ....z = 26.
You will be given a list of strings and your task will be to return the values of the strings
as explained above multiplied by the position of that string in the list. For our purpose, position begins with 1.

nameValue ["abc","abc abc"] should return [6,24] because of [ 6 * 1, 12 * 2 ]. Note how spaces are ignored.
"abc" has a value of 6, while "abc abc" has a value of 12. Now, the value at position 1 is multiplied by 1
while the value at position 2 is multiplied by 2.

Input will only contain lowercase characters and spaces.
 */
public class JCC12_StringValueGetter {
    public static void main(String[] args) {
        var values = List.of("abc", "abc abc");
        var runner = new JCC12_StringValueGetter();
        var result = runner.getStringValues(values);
        System.out.println("result = " + result);

    }

    public List<Integer> getStringValues(List<String> elements) {
        var values = new ArrayList<Integer>();
        for (int i = 0; i < elements.size(); i++) {
            String element = elements.get(i);
            int adjustedPositionValue = i + 1;
            int stringValue = getStringValue(element, adjustedPositionValue);
            values.add(stringValue);
        }
        return values;
    }

    public int getStringValue(String element, int position) {
        var stringValue = 0;
        for (char ch : element.toCharArray()) {
            if (isValidLetter(ch)) {
                stringValue += getLetterValue(ch);
            }
        }
        return stringValue * position;
    }

    private int getLetterValue(char ch) {
        return ch - 'a' + 1;
    }

    private boolean isValidLetter(char ch) {
        return ch >= 'a' && ch <= 'z';
    }
}
