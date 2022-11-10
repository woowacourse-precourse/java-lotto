package lotto;

import java.util.Arrays;
import java.util.List;

public class Calculation {
    public static String profitRate(int cost, int earn) {
        double rate = (double) earn / (double) cost * 100;
        return String.format("%.1f%%", rate);
    }

    public static List<Integer> compareLotto(List<Integer> winNumbers, int bonus, List<Integer> lotto) {
        int[] result = new int[2];
        for (int number : lotto) {
            if (winNumbers.contains(number)) {
                result[0]++;
            }
            else if(number == bonus){
                result[1]++;
            }
        }
        return List.of(result[0], result[1]);
    }
}