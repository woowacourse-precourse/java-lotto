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
    private static final String LOTTO_YIELD_MESSAGE = "총 수익률은 %.2f%%입니다.\n";

    public static void printHowManyLottoUserPurchased(int lottoQuantity) {
        System.out.printf(HOW_MANY_LOTTO_USER_PURCHASED_MESSAGE, lottoQuantity);
    }

    public static void printLottos(Lottos lottos) {
        lottos.getLottos().stream()
                .map(Object::toString)
                .forEach(System.out::println);
    }

    public static void printWinningStatistics() {
        System.out.println(WINNING_STATISTICS_MESSAGE);
    }

    public static void printWinningDetails(Map<WinningRank, Integer> winningDetails) {
        winningDetails.entrySet().stream()
                .filter(entry -> entry.getKey() != WinningRank.LAST_PLACE)
                .forEach(entry -> {
                    DecimalFormat df = new DecimalFormat("###,###");
                    if (entry.getKey() == WinningRank.SECOND_PLACE) {
                        System.out.printf(WINNING_DETAILS_WITH_BONUS_MESSAGE,
                                entry.getKey().getMatchingCount(), df.format(entry.getKey().getWinningPrice()), entry.getValue());
                        return;
                    }
                    System.out.printf(WINNING_DETAILS_MESSAGE,
                            entry.getKey().getMatchingCount(), df.format(entry.getKey().getWinningPrice()), entry.getValue());
                });
    }

    public static void printLottoYield(double lottoYield) {
        System.out.printf(LOTTO_YIELD_MESSAGE, lottoYield);
    }
}
