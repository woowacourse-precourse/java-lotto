package lotto.view;

import java.text.DecimalFormat;

import static lotto.domain.Constants.SECOND_PRIZE;
import static lotto.domain.Score.*;
import static lotto.domain.Prize.*;

public class ScorePrint {

    DecimalFormat formatter = new DecimalFormat("###,###.##");

    public void printScoreBoard() {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (" + formatter.format(FIFTH_PRIZE.getPrize()) + "원) - " + fifthCount() + "개");
        System.out.println("4개 일치 (" + formatter.format(FOURTH_PRIZE.getPrize()) + "원) - " + fourthCount() + "개");
        System.out.println("5개 일치 (" + formatter.format(THIRD_PRIZE.getPrize()) + "원) - " + thirdCount() + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (" + formatter.format(SECOND_PRIZE) + "원) - " + bonusCount + "개");
        System.out.println("6개 일치 (" + formatter.format(FIRST_PRIZE.getPrize()) + "원) - " + firstCount() + "개");
    }


}
