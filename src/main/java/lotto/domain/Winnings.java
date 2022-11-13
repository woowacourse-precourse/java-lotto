package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class Winnings {
    static Map map;
    static double[] correctNums = {3, 4, 5, 5.5, 6};
    static int[] cash = {5000, 50000, 1500000, 30000000, 2000000000};

    public static void setWinnings() {
        map = new HashMap<Double, Integer>();

        for (int i = 0; i < correctNums.length; i++) {
            map.put(correctNums[i], cash[i]);
        }
    }

    public static int getWinnings(double num) {
        return (int) map.get(num);
    }

    public static double[] getCorrectNums() {
        return correctNums;
    }

    public static int[] getCash() {
        return cash;
    }
}
