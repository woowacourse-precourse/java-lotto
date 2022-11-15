package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Statistics;

import java.text.DecimalFormat;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final int LOTTO_PRICE = 1000;
    private static final int NO_WINNING_LOTTO = 0;
    private static final String PURCHASE_LOTTO = "\n%d개를 구매했습니다.\n";
    private static final String SHOW_STATISTICS = "\n당첨 통계\n---";
    private static final String SHOW_YIELD = "총 수익률은 %.1f%%입니다.\n";
    private static final String WINNING_RESULT = "%d개 일치%s (%s원) - %d개\n";
    private static final String HAS_BONUS_BALL = ", 보너스 볼 일치";
    private static final String NO_HAS_BONUS_BALL = "";
    private static final String COMMA_EVERY_3_DIGITS = "###,###";
    private static final String OPEN_BRACKET = "[";
    private static final String CLOSE_BRACKET = "]";
    private static final String SEPARATOR = ", ";

    public void printPurchaseLottoCount(int money) {
        System.out.printf(PURCHASE_LOTTO, money / LOTTO_PRICE);
    }

    public void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            printLotto(lotto);
        }
    }

    private void printLotto(Lotto lotto) {
        String lottoNumbers = lotto.getNumbers()
                .stream()
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(SEPARATOR));
        System.out.println(OPEN_BRACKET + lottoNumbers + CLOSE_BRACKET);
    }

    public void printStatistics(Statistics statistics) {
        System.out.println(SHOW_STATISTICS);

        statistics.getLottosResult()
                .entrySet()
                .stream()
                .filter(rankEntry -> rankEntry.getKey().getMatchingCnt() != NO_WINNING_LOTTO)
                .forEach(rankEntry -> {
                    String bonusBall = NO_HAS_BONUS_BALL;
                    String reward = new DecimalFormat(COMMA_EVERY_3_DIGITS).format(rankEntry.getKey().getReward());
                    if (rankEntry.getKey().isBonusBall()) {
                        bonusBall = HAS_BONUS_BALL;
                    }
                    System.out.printf(WINNING_RESULT, rankEntry.getKey().getMatchingCnt(), bonusBall, reward, rankEntry.getValue());
                });
    }

    public void printYield(Statistics statistics, int money) {
        double yield = statistics.getYield(money);
        System.out.printf(SHOW_YIELD, yield);
    }
}
