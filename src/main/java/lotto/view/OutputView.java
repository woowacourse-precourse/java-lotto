package lotto.view;

import java.text.DecimalFormat;
import java.util.Map;
import lotto.domain.Lottos;
import lotto.domain.WinningRank;

public class OutputView {

    private static final String HOW_MANY_LOTTO_USER_PURCHASED_MESSAGE = "%d개를 구매했습니다.\n";
    private static final String WINNING_STATISTICS_MESSAGE = "당첨 통계\n---";
    private static final String WINNING_DETAILS_MESSAGE = "%d개 일치 (%s원) - %d개\n";
    private static final String WINNING_DETAILS_WITH_BONUS_MESSAGE = "%d개 일치, 보너스 볼 일치 (%s원) - %d개\n";
    private static final String LOTTO_YIELD_MESSAGE = "총 수익률은 %.1f%%입니다.\n";
    private static final String SEPARATOR_PATTERN = "###,###";

    public static void printHowManyLottoUserPurchased(int lottoQuantity) {
        System.out.printf(HOW_MANY_LOTTO_USER_PURCHASED_MESSAGE, lottoQuantity);
    }

    public static void printLottos(Lottos lottos) {
        lottos.getLottos().stream()
                .forEach(lotto -> System.out.println(lotto.getNumbers().toString()));
    }

    public static void printWinningStatistics() {
        System.out.println(WINNING_STATISTICS_MESSAGE);
    }

    public static void printWinningDetails(Map<WinningRank, Integer> winningDetails) {
        winningDetails.entrySet().stream()
                .filter(entry -> entry.getKey() != WinningRank.LAST_PLACE)
                .forEach(entry -> {
                    if (entry.getKey() == WinningRank.SECOND_PLACE) {
                        printWinningDetailsWithBonus(entry);
                        return;
                    }
                    printWinningDetailsWithoutBonus(entry);
                });
    }

    private static void printWinningDetailsWithBonus(Map.Entry<WinningRank, Integer> entry) {
        System.out.printf(WINNING_DETAILS_WITH_BONUS_MESSAGE,
                entry.getKey().getMatchingCount(),
                getFormattingPrice(entry.getKey().getWinningPrice()),
                entry.getValue());
    }

    private static void printWinningDetailsWithoutBonus(Map.Entry<WinningRank, Integer> entry) {
        System.out.printf(WINNING_DETAILS_MESSAGE,
                entry.getKey().getMatchingCount(),
                getFormattingPrice(entry.getKey().getWinningPrice()),
                entry.getValue());
    }

    private static String getFormattingPrice(int winningPrice) {
        DecimalFormat df = new DecimalFormat(SEPARATOR_PATTERN);
        return df.format(winningPrice);
    }

    public static void printLottoYield(double lottoYield) {
        System.out.printf(LOTTO_YIELD_MESSAGE, lottoYield);
    }
}
