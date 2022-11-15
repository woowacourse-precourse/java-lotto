package lotto.view;

import lotto.domain.*;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OutputView {
    public static final String QUANTITY_MESSAGE = "%d개를 구매했습니다.\n";
    public static final String STATISTIC_MESSAGE  = "당첨 통계\n---";
    public static final String DECIMAL_FORMAT  = "###,###";
    public static final String WINNING_STATISTIC_MESSAGE  = "%d개 일치 (%s원) - %d개\n";
    public static final String BONUS_STATISTIC_MESSAGE  = "%d개 일치, 보너스 볼 일치 (%s원) - %d개\n";
    public static final String PROFIT_RATE_MESSAGE = "총 수익률은 %.1f%%입니다.";

    public static void printProfitRate(int money, WinningStatistics winningStatistics) {
        double profitRate = winningStatistics.calculateProfitRate(money);
        System.out.printf(PROFIT_RATE_MESSAGE,profitRate);
    }

    public static WinningStatistics printWinningStatistics(LottoList LottoPaper, WinningLotto winningLotto) {
        System.out.println(STATISTIC_MESSAGE);
        WinningStatistics winningStatistics = getWinningStatistics(LottoPaper, winningLotto);
        DecimalFormat formatter = new DecimalFormat(DECIMAL_FORMAT);
        printFormatStatistics(winningStatistics, formatter);
        return winningStatistics;
    }

    private static void printFormatStatistics(WinningStatistics winningStatistics, DecimalFormat formatter) {
        for (Map.Entry<Ranking, Integer> entry : winningStatistics.getWinningStatisticsMap().entrySet()) {
            if (entry.getKey() == Ranking.SIXTH) {
                continue;
            }
            if (entry.getKey() == Ranking.SECOND) {
                System.out.printf(BONUS_STATISTIC_MESSAGE, entry.getKey().getCountWinningNumbers(), formatter.format(entry.getKey().getWinningPrice()), entry.getValue());
                continue;
            }
            System.out.printf(WINNING_STATISTIC_MESSAGE, entry.getKey().getCountWinningNumbers(), formatter.format(entry.getKey().getWinningPrice()), entry.getValue());
        }
    }

    private static WinningStatistics getWinningStatistics(LottoList LottoPaper, WinningLotto winningLotto) {
        List<Ranking> rankingList = new ArrayList<>();
        for (Lotto lotto : LottoPaper.getLottoList()) {
            rankingList.add(winningLotto.calculateRanking(lotto));
        }
        WinningStatistics winningStatistics = new WinningStatistics(rankingList);
        return winningStatistics;
    }

    public static LottoList printQuantity(int money) {
        PriceQuantity priceQuantity = new PriceQuantity(money);
        System.out.printf(QUANTITY_MESSAGE,priceQuantity.getQuantity());
        LottoList LottoPaper = new LottoList();
        LottoPaper.createLotto(priceQuantity.getQuantity());
        for (Lotto lotto : LottoPaper.getLottoList()) {
            System.out.println(lotto.getNumbers().toString());
        }
        System.out.println();
        return LottoPaper;
    }

    public static void printException(Exception e) {
        System.out.println(e.getMessage());
    }
}
