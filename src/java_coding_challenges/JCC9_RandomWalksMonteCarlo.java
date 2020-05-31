package java_coding_challenges;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

//What's the longest random walk you can take so that on *average* you will
//end up 4 blocks of fewer from home (and so can walk back sans taxi ride, it goes)?
public class JCC9_RandomWalksMonteCarlo {

    private static final int NUMBER_OF_WALKS = 20000;
    private static final int MAX_LENGTH_WALK_TESTED = 30;
    private static final Map<Integer, Double> walkLengthPercentages = new LinkedHashMap<>();

    public static void main(String[] args) {

        testWalks();
        printLongestValidWalk();

    }

    public static void testWalks() {

        for (int walkLength = 1; walkLength <= MAX_LENGTH_WALK_TESTED; walkLength++) {
            //a valid walk is such that ends in average (+ 50% cases) distance from home of 4 or fewer blocks
            int validWalkCount = 0;
            for (int walk = 0; walk < NUMBER_OF_WALKS; walk++) {
                int[] coordinates = executeRandomWalk(walkLength);
                if (getDistance(coordinates) <= 4) {
                    validWalkCount++;
                }
            }
            double validWalkPercentage = validWalkCount / (double) NUMBER_OF_WALKS * 100;
            walkLengthPercentages.put(walkLength, validWalkPercentage);
        }
    }

    public static void printLongestValidWalk() {

        int longestValidWalk = getLongestValidWalk();
        System.out.println("The longest walk resulting in an average of 4 or fewer blocks of distance " +
                "from home is " + longestValidWalk + " blocks");
    }

    private static int getLongestValidWalk() {

        int currentLongestValidWalk = 0;
        for (int i = 1; i < walkLengthPercentages.size(); i++) {
            if (i > currentLongestValidWalk && walkLengthPercentages.get(i) > 50.00) {
                currentLongestValidWalk = i;
            }
        }
        return currentLongestValidWalk;
    }

    private static int[] executeRandomWalk(int walkLength) {
        //0, 0 are home coordinates
        int x = 0, y = 0;
        for (int i = 0; i < walkLength; i++) {
            switch(new Random().nextInt(4)) {
                case 0 -> y += 1; //0 denotes North
                case 1 -> y -= 1; //1 denotes South
                case 2 -> x += 1; //2 denotes East
                case 3 -> x -= 1; //default (3) denotes West
            }
        }
        return new int[]{x, y};
    }

    private static int getDistance(int[] coordinates) {
        return Math.abs(coordinates[0]) + Math.abs(coordinates[1]);
    }
}
