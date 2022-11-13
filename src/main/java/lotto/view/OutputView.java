package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Result;
import lotto.domain.ResultStatistics;
import lotto.domain.WinLotto;
import lotto.enums.ConstVariable;

import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

public class OutputView {

    public static final String STATISTIC_MESSAGE = "당첨 통계";
    public static final String BARS = "---";
    public static final String TOTAL_PROFIT_RATE_MESSAGE = "총 수익률은 {0}입니다.";
    public static final String TOTAL_PROFIT_PRINT_PATTERN = "###,###.#%";

    public static void showStatistics(List<Lotto> generatedLottos, WinLotto winLotto) {
        System.out.println(STATISTIC_MESSAGE);
        System.out.println(BARS);
        List<Result> results = getResults(generatedLottos, winLotto);
        ResultStatistics statistics = printResultStatistics(results);
        System.out.println(printTotalProfit(statistics, generatedLottos.size()));
    }

    protected static List<Result> getResults(List<Lotto> generatedLottos, WinLotto winLotto) {
        List<Result> results = new ArrayList<>();

        for (Lotto lotto : generatedLottos) {
            Result result = winLotto.getResult(lotto);
            results.add(result);
        }
        return results;
    }

    protected static ResultStatistics printResultStatistics(List<Result> results) {
        ResultStatistics statistics = new ResultStatistics(results);
        System.out.println(statistics.printResultStatistics());
        return statistics;
    }

    protected static String printTotalProfit(ResultStatistics statistics, int count) {
        DecimalFormat format = new DecimalFormat(TOTAL_PROFIT_PRINT_PATTERN);
        String totalProfitRate = getTotalProfitRate(statistics, count, format);
        return MessageFormat.format(TOTAL_PROFIT_RATE_MESSAGE, totalProfitRate);
    }

    private static String getTotalProfitRate(ResultStatistics statistics, int count, DecimalFormat format) {
        return format.format((float) (statistics.getTotalProfit()) / (count * ConstVariable.STANDARD.getValue()));
    }
}
