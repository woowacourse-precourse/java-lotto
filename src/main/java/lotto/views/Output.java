package lotto.views;

import lotto.domain.Prize;
import lotto.utils.Ranking;

public class Output {

    public void printPrize(Prize prize) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println(Ranking.FIFTH_PLACE.getPrintSentence() + " - " + prize.getValue(Ranking.FIFTH_PLACE));
        System.out.println(Ranking.FOURTH_PLACE.getPrintSentence() + " - " + prize.getValue(Ranking.FOURTH_PLACE));
        System.out.println(Ranking.THIRD_PLACE.getPrintSentence() + " - " + prize.getValue(Ranking.THIRD_PLACE));
        System.out.println(Ranking.SECOND_PLACE.getPrintSentence() + " - " + prize.getValue(Ranking.SECOND_PLACE));
        System.out.println(Ranking.FIRST_PLACE.getPrintSentence() + " - " + prize.getValue(Ranking.FIRST_PLACE));
    }
}
