package lotto.View;

import java.util.List;

import static lotto.Model.LottoSystem.getFrequency;
import static lotto.Model.Money.calcYield;
import static lotto.Model.RandomLotto.getBundleOfLottoNumbers;


public class OutputView {

    private static final int COUNT_OF_FIRST = 6;
    private static final int COUNT_OF_SECOND = 7;
    private static final int COUNT_OF_THIRD = 5;
    private static final int COUNT_OF_FOURTH = 4;
    private static final int COUNT_OF_FIFTH = 3;

    public static void printBundleOfLottoNumbers() {
        for(List<Integer> lottoNumbers: getBundleOfLottoNumbers()) System.out.println(lottoNumbers);
    }

    public static void printResult() {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + getFrequency(COUNT_OF_FIFTH) + "개");
        System.out.println("4개 일치 (50,000원) - " + getFrequency(COUNT_OF_FOURTH) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + getFrequency(COUNT_OF_THIRD) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + getFrequency(COUNT_OF_SECOND) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + getFrequency(COUNT_OF_FIRST) + "개");
    }

    public static void printYield() {
        double sum = calcYield();
        String formatYield = formatting(sum);
        System.out.println("총 수익률은 " + formatYield + "%입니다.");
    }

    private static String formatting(double sum) {
        return String.format("%.1f", sum);
    }



}
