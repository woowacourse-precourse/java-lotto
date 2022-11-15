package lotto.viewer;

import lotto.domain.History;
import lotto.domain.Result;
import java.util.EnumSet;

public class OutputView {
    public static final String WINNING_STATISTICS = "당첨 통계";
    public static final String PERFORATION = "---";
    public static final String SEPERATOR = " - ";
    public static final String TOTAL_PROFIT = "총 수익률은 ";
    public static final String EXPLANATION_PROFIT = "%입니다.";

    public static void showHistory(History history) {
        EnumSet<Result> allResult = EnumSet.complementOf(EnumSet.of(Result.NONE));
        System.out.println(WINNING_STATISTICS);
        System.out.println(PERFORATION);
        for (Result result: allResult) {
            System.out.println(result + SEPERATOR + history.showNumber(result));
        }
    }
    public static void showProfitRate(History history) {
        System.out.println(TOTAL_PROFIT + history.calculateProfitRate() + EXPLANATION_PROFIT);
    }
}
