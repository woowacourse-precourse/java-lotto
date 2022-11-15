package lotto.view;

import lotto.domain.Rank;
import lotto.values.Hit;

import java.util.LinkedHashMap;

import static lotto.values.Constants.Digit.FIFTH_PLACE;
import static lotto.values.Constants.Digit.FIRST_PLACE;
import static lotto.values.Hit.getHit;

public class RankUi {

    public static void printRanking(Rank rank) {
        LinkedHashMap<Integer, Integer> ranking = rank.getRank();
        for (int i = FIFTH_PLACE; i <= FIRST_PLACE; i++) {
            Hit hit = getHit(i);
            Integer cnt = ranking.get(i);
            System.out.printf(hit.getMessage(), cnt);
        }
    }
}
