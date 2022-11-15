package view;

import java.util.List;

public class OutputView {
    public static final String SHOW_MADE_PURCHASE = "개를 구매했습니다.";
    public static final String SHOW_WINNING_STATISTICS = "당첨 통계\n" + "---";

    public static void showMadePurchase(int chance) {
        System.out.println(chance+SHOW_MADE_PURCHASE);
    }

    public static void showRandomLottoNumbers(List<Integer> randomLotto) {
        System.out.println(randomLotto);
    }

    public static void showWinningStatistics() {
        System.out.println(SHOW_WINNING_STATISTICS);
    }
}
