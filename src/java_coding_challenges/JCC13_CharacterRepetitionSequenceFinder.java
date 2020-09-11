package java_coding_challenges;

import java.util.*;

// find character with longest sequence of consecutive repeated instances in a string
// is string is empty, consider it invalid
public class JCC13_CharacterRepetitionSequenceFinder {

    public static void main(String[] args) {
        var executor = new JCC13_CharacterRepetitionSequenceFinder();
        char result = executor.findLongestRepChar("aaaabbccccc");
        System.out.println("result = " + result);
    }

    public char findLongestRepChar(String input) {
        validateInput(input);

        //save repetition sequences (char and no. of repetitions) in (improvised) "tuples"
        List<Object[]> tuples = new ArrayList<>();

        //find repetition sequences by checking current element against previous elements for identity
        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);
            //current already constitutes a 1 in count
            int count = 1;
            int echoIndex = i - 1;
            while (echoIndex >= 0) {
                if (current == input.charAt(echoIndex)) {
                    count++;
                    echoIndex--;
                }
                //if element not the same character as previous, break
                else break;
            }
            tuples.add(new Object[]{current, count});
        }

        return getTarget(tuples);
    }

    private void validateInput(String input) {
        Objects.requireNonNull(input);
        if (input.length() == 0) {
            throw new IllegalArgumentException("Invalid input: empty string");
        }
    }

    private char getTarget(List<Object[]> tuples) {
        int maxCount = 0;
        //default max repeated char
        char maxCountChar = '~';
        for (var tuple : tuples) {
            char ch = (char) tuple[0];
            int count = (int) tuple[1];
            if (count > maxCount) {
                maxCount = count;
                maxCountChar = ch;
            }
        }
        return maxCountChar;
    }
}
