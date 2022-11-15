package lotto.view;

import lotto.domain.*;

import java.util.stream.Collectors;

public class OutputView {

    private final static String COUNT_OF_LOTTO_MESSAGE = "%d개를 구매했습니다.\n";
    private static final String STATISTIC_RESULT_MESSAGE = "당첨 통계\n---";
    private static final String WINNING_MESSAGE = "%d개 일치 (%d원) - %d개\n";
    private static final String SECOND_MESSAGE = "%d개 일치, 보너스 볼 일치 (%d원)- %d개\n";
    private static final String PROFIT_RATE_MESSAGE = "총 수익률은 %.1f%%입니다.\n";
    private static final int ZERO = 0;

    public static void printCountOfLotto(int LottoCount) {
        System.out.println();
        System.out.printf(COUNT_OF_LOTTO_MESSAGE, LottoCount);
    }
    public static void viewLottos(Lottos lottos){
        printCountOfLotto(lottos.getCountOfLotto());
        for (Lotto lotto: lottos.getLottos()){
            printLotto(lotto);
        }
        System.out.println();
    }

    public static void printLotto(Lotto lotto){
        System.out.println(lotto.getLotto().toString());
    }

    public static void printStatistics(Statistic statistic) {
        System.out.println(STATISTIC_RESULT_MESSAGE);

        statistic.getStatistics()
                .entrySet()
                .stream()
                .filter(statistics -> statistics.getKey().getCount() != ZERO)
                .forEach(statistics -> {
                    if (statistics.getKey().hasBonusBall()) {
                        System.out.printf(SECOND_MESSAGE, Rank.SECOND.getCount(), Rank.SECOND.getWinningPrice(), statistics.getValue());
                        return;
                    }
                    System.out.printf(WINNING_MESSAGE, statistics.getKey().getCount(), statistics.getKey().getWinningPrice(), statistics.getValue());
                });
    }

    public static void printProfitRate(Statistic statistic, Price price) {
        double profitRate = statistic.getProfitRate(price);
        System.out.printf(PROFIT_RATE_MESSAGE, profitRate);
    }



}
