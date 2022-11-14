package lotto.view;

import lotto.domain.Policy;

import java.text.DecimalFormat;


/**
 * 당첨 통계
 * ---
 * 3개 일치 (5,000원) - 1개
 * 4개 일치 (50,000원) - 0개
 * 5개 일치 (1,500,000원) - 0개
 * 5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
 * 6개 일치 (2,000,000,000원) - 0개
 */
public class PrintScore {

    DecimalFormat formatter = new DecimalFormat("###,###.##");

    public void printScoreBoard() {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (" + formatter.format(Policy.FIFTH_PRIZE) + "원) - " + Policy.count.get(0) + "개");
        System.out.println("4개 일치 (" + formatter.format(Policy.FOURTH_PRIZE) + "원) - " + Policy.count.get(1) + "개");
        System.out.println("5개 일치 (" + formatter.format(Policy.THIRD_PRIZE) + "원) - " + Policy.count.get(2) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (" + formatter.format(Policy.SECOND_PRIZE) + "원) - " + Policy.bonusCount + "개");
        System.out.println("6개 일치 (" + formatter.format(Policy.FIRST_PRIZE) + "원) - " + Policy.count.get(3) + "개");
    }
}
