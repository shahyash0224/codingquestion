package blind75.interval;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MergeInterval {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter number of intervals, from next line input intervals: ");
        int n = Integer.parseInt(br.readLine());

        List<List<Integer>> intervals = new ArrayList<>(n);
        List<Integer> interval;
        String temp;
        for (int i = 0; i < n; i++) {
            temp = br.readLine();
            interval = new ArrayList<Integer>(2);
            intervals.add(i, interval);
            interval.add(0, Integer.parseInt(temp.split(" ")[0]));
            interval.add(1, Integer.parseInt(temp.split(" ")[1]));
        }

        intervals.sort((a, b) -> Integer.compare(a.get(0), b.get(0)));

        LinkedList<List<Integer>> mergedIntervals = new LinkedList<>();
        System.out.println("Merged intervals: ");
        for (int i = 0; i < n; i++) {
            if (mergedIntervals.isEmpty() || mergedIntervals.getLast().get(1) < intervals.get(i).get(0)) {
                mergedIntervals.add(intervals.get(i));
            } else {
                mergedIntervals.getLast().set(1, Math.max(mergedIntervals.getLast().get(1), intervals.get(i).get(1)));
            }
        }

        mergedIntervals.forEach(a -> System.out.println(a.get(0) + " " + a.get(1)));
        br.close();
    }

}
