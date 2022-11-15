package lotto.view;

import lotto.domain.ingame.Lotto;
import lotto.domain.result.Rank;
import lotto.domain.result.Statistic;

import java.text.DecimalFormat;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String PAYMENT_MESSAGE = System.lineSeparator() + "%d개를 구매했습니다." + System.lineSeparator();
    private static final String STAT_MESSAGE = System.lineSeparator() + "당첨 통계" + System.lineSeparator() + "---";
    private static final String RANK_MESSAGE = "%d개 일치%s(%s원) - %d개" + System.lineSeparator();
    private static final String BONUS_MESSAGE = ", 보너스 볼 일치 ";
    private static final String PROFIT_MESSAGE = "총 수익률은 %s%%입니다."+System.lineSeparator();
    private static final String ERROR_MESSAGE = "[ERROR] %s" + System.lineSeparator();

    public static void showLotto(List<Lotto> userLotto) {

        int ticketCount = userLotto.size();
        System.out.printf(PAYMENT_MESSAGE,ticketCount);

        for (Lotto lotto : userLotto) {
            System.out.println(lotto.getNumbers().stream().sorted().collect(Collectors.toList()));
        }

    }

    public static void showStatistic(Statistic stat) {
        System.out.println(STAT_MESSAGE);
        for (Rank rank : Rank.getAllRank()) {
            System.out.printf(RANK_MESSAGE, rank.getBallCount(), isSecond(rank),
                    formatDecimal(rank.getPrize()), stat.getRankCount(rank));
        }
        System.out.printf(PROFIT_MESSAGE, formatDecimal(stat.getProfitRate()));
    }

    private static String isSecond(Rank rank) {
        if (rank.equals(Rank.SECOND)) {
            return BONUS_MESSAGE;
        }
        return " ";
    }

    private static String formatDecimal(double number) {
        DecimalFormat formatter = new DecimalFormat("###,###.#");

        return formatter.format(number);
    }

    public static void showError(String message) {
        System.out.printf(ERROR_MESSAGE,message);
    }
}
