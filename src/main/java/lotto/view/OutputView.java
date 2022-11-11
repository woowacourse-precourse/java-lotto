package lotto.view;

import lotto.constant.Score;

import java.util.List;
import java.util.Map;

import static lotto.constant.Score.*;

public class OutputView {

    private static final String THREE_CORRECT = "3개 일치 (5,000원) - ";
    private static final String FOUR_CORRECT = "4개 일치 (50,000원) - ";
    private static final String FIVE_CORRECT = "5개 일치 (1,500,000원) - ";
    private static final String FIVE_BONUS_CORRECT = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    private static final String SIX_CORRECT = "6개 일치 (2,000,000,000원) - ";
    private static final String COUNT = "개";
    private static final String STATISTICS = "당첨 통계\n" + "---";
    private static final String TOTAL_PROFIT_RATE = "총 수익률은 ";
    private static final String PERCENT = "%입니다.";

    public static void printRandomLottoNumbers(List<List<Integer>> randomLottoNumbers) {
        randomLottoNumbers.forEach(System.out::println);
    }

    public static void printStatistics(Map<Score, Integer> scoreStore) {
        System.out.println(STATISTICS);
        System.out.println(THREE_CORRECT + scoreStore.get(THREE) + COUNT);
        System.out.println(FOUR_CORRECT + scoreStore.get(FOUR) + COUNT);
        System.out.println(FIVE_CORRECT + scoreStore.get(FIVE) + COUNT);
        System.out.println(FIVE_BONUS_CORRECT + scoreStore.get(FIVE_BONUS) + COUNT);
        System.out.println(SIX_CORRECT + scoreStore.get(SIX) + COUNT);
    }

    public static void printProfitRate(String profitRate) {
        System.out.println(TOTAL_PROFIT_RATE + profitRate + PERCENT);
    }
}
