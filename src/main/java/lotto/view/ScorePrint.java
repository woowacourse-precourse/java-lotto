package lotto.view;

import java.text.DecimalFormat;

import static lotto.domain.Score.*;
import static lotto.domain.Prize.*;


/**
 * 당첨 통계
 * ---
 * 3개 일치 (5,000원) - 1개
 * 4개 일치 (50,000원) - 0개
 * 5개 일치 (1,500,000원) - 0개
 * 5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
 * 6개 일치 (2,000,000,000원) - 0개
 */
public class ScorePrint {

    DecimalFormat formatter = new DecimalFormat("###,###.##");

    public void printScoreBoard() {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (" + formatter.format(FIFTH_PRIZE.getPrize()) + "원) - " + count.get(0) + "개");
        System.out.println("4개 일치 (" + formatter.format(FOURTH_PRIZE.getPrize()) + "원) - " + count.get(1) + "개");
        System.out.println("5개 일치 (" + formatter.format(THIRD_PRIZE.getPrize()) + "원) - " + count.get(2) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (" + formatter.format(SECOND_PRIZE.getPrize()) + "원) - " + bonusCount + "개");
        System.out.println("6개 일치 (" + formatter.format(FIRST_PRIZE.getPrize()) + "원) - " + count.get(3) + "개");
    }
}
