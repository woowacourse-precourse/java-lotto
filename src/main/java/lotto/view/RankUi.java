package lotto.view;

import lotto.domain.Rank;
import lotto.domain.Hit;

import java.util.LinkedHashMap;

import static lotto.values.Constants.Digit.FIFTH_PLACE;
import static lotto.values.Constants.Digit.FIRST_PLACE;
import static lotto.domain.Hit.getHit;

public class RankUi {

    public static void printRanking(Rank rank) {
        LinkedHashMap<Integer, Integer> ranking = rank.getRank();
        Integer cnt;
        for (int i = FIFTH_PLACE; i <= FIRST_PLACE; i++) {
            Hit hit = getHit(i);
            cnt = ranking.get(i);
            System.out.printf(hit.getMessage(), cnt);
        }
    }
}
