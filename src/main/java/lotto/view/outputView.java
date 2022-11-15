package lotto.view;

import lotto.game.rank;
import lotto.game.user;

import java.util.List;
public class outputView {
    public static final String BUY_RESULT_MESSAGE = "개를 구매했습니다.";
    public static final String STATISTIC_RESULT_MESSAGE = "당첨 통계";
    public static final String LINE_CHANGE_MESSAGE = "---";

    public static void showPurchasedLotto(user user) {
        System.out.println(user.getQuantity() + BUY_RESULT_MESSAGE);
        user.getLottos().stream()
                .forEach(lotto -> System.out.println(lotto));
    }

    public static void showGameResult(user user, List<rank> results) {
        System.out.println(STATISTIC_RESULT_MESSAGE);
        System.out.println(LINE_CHANGE_MESSAGE);

        for (rank rank : rank.getValidRanks()) {
            System.out.println(rank.getMessage() + rank.calculateCount(results) + "개");
        }

        System.out.println("총 수익률은 " + String.format("%,.1f", getEarningRate(rank.calculateEarning(results), user.getInputMoney())) + "%입니다.");
    }

    private static double getEarningRate(long profit, long inputMoney) {
        return (double) (profit * 100) / inputMoney;
    }
}
