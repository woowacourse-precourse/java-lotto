package lotto.domain;


import java.util.ArrayList;
import java.util.List;

public class Score {

    public static List<Integer> count = new ArrayList<>();

    public static int bonusCount = 0;

    public static void increaseBonusCount() {
        bonusCount ++;
    }

    public static Integer firstCount() {
        return count.get(3);
    }

    public static Integer thirdCount() {
        return count.get(2);
    }

    public static Integer fourthCount() {
        return count.get(1);
    }

    public static Integer fifthCount() {
        return count.get(0);
    }

}
