package lotto.ui;

import lotto.domain.Lotto;
import lotto.domain.LottoStatistics;

import java.util.List;

import static lotto.ui.LottoViewMessage.*;

public class LottoViewer {

    public static void showPurchaseAmountInputText() {
        System.out.println(INPUT_PURCHASE.getMessage());
    }

    public static void showCountOfLottoTickets(int count) {
        printLineFeed();
        System.out.println(count + LOTTO_COUNT.getMessage());
    }

    public static void showWinningLottoNumberInputText() {
        printLineFeed();
        System.out.println(INPUT_WINNING_LOTTO_NUMBERS.getMessage());
    }

    public static void showBonusLottoNumberInputText() {
        printLineFeed();
        System.out.println(INPUT_BONUS_LOTTO_NUMBER.getMessage());
    }

    public static void showYield(String yield) {
        System.out.println(YIELD.getMessage() + yield + SUFFIX.getMessage());
    }

    public static void showLottoTickets(List<Lotto> lottoTickets) {
        lottoTickets.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    private static void printLineFeed() {
        System.out.println();
    }

    public static void showWinningStatisticsText(LottoStatistics lottoStatistics) {
        printLineFeed();
        System.out.println(STATISTICS_HEAD_LINE.getMessage());
        System.out.println(lottoStatistics.toString());
        showYield(lottoStatistics.getYield());
    }
}
