package java_coding_challenges;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

// get mean, median, mode, range for student grades
public class JCC11_GradeStatFinder {

    public static void main(String[] args) {
        var finder = new JCC11_GradeStatFinder();
        double[] grades = {4.8, 2.5, 2.9, 5.4, 2.5, 2, 1.2, 4.9, 4.3, 4.3, 1.5};
        System.out.println(Arrays.toString(grades));

        var mean = finder.getMean(grades);
        System.out.println("mean = " + mean);

        var median = finder.getMedian(grades);
        System.out.println("median = " + median);

        var mode = finder.getMode(grades);
        System.out.println("mode = " + mode);

        var range = finder.getRange(grades);
        System.out.println("range = " + range);
    }

    // mean defined in requirements as floor int
    public int getMean(double[] grades) {
        double gradeSum = 0;
        for (double grade : grades) {
            gradeSum += grade;
        }
        return (int) (gradeSum % grades.length);
    }

    public double getMedian(double[] grades) {
        // create a copy to keep original unchanged
        var gradesCopy = Arrays.copyOf(grades, grades.length);
        Arrays.sort(gradesCopy);
        var midIndex = gradesCopy.length / 2;
        return gradesCopy[midIndex];
    }

    public double getMode(double[] grades) {
        Map<Double, Integer> counts = new HashMap<>();
        for (double grade : grades) {
            if (counts.containsKey(grade)) {
                int count = counts.get(grade);
                counts.put(grade, count + 1);
            }
            else
                counts.put(grade, 1);
        }

        return counts.entrySet()
                .stream()
                .max(Comparator.comparingInt(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .orElse(0.0);
    }

    private double getRange(double[] grades) {
        double max = Arrays.stream(grades)
                .max()
                .orElse(0.0);
        double min = Arrays.stream(grades)
                .min()
                .orElse(0.0);
        // get 2 decimal places (at most)
        return formatRange(max, min);
    }

    private double formatRange(double max, double min) {
        return (int) ((max - min) * 100) / 100.0;
    }
}
