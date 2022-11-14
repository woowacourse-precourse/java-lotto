package lotto.domain;


import java.util.ArrayList;
import java.util.List;

public class Score {

    public static List<Integer> count = new ArrayList<>();

    public static int bonusCount = 0;

    public static void increaseBonusCount() {
        bonusCount ++;
    }

}
