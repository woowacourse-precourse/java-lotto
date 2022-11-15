package lotto.view;

import lotto.domain.Lottery;
import lotto.domain.Rank;
import lotto.domain.Result;
import lotto.domain.WinningLotto;

import java.util.ArrayList;
import java.util.List;

public class OutputView {

    private static final String PURCHASE_GUIDE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String PURCHASE_RESULT_MESSAGE = "\n%d개를 구매했습니다.\n";
    private static final String WINNING_NUMBERS_ENTERING_GUIDE_MESSAGE = "\n당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_ENTERING_GUIDE_MESSAGE = "\n보너스 번호를 입력해 주세요.";
    private static final String RESULT_MESSAGE = "\n당첨 통계\n---";
    private static final String WINNING_MESSAGE = "%d개 일치 (%s원) - %d개\n";
    private static final String SECOND_MESSAGE = "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n";
    private static final String YIELD_MESSAGE = "총 수익률은 %.1f%%입니다.\n";

    public static void printPurchaseGuideMessage() {
        System.out.println(PURCHASE_GUIDE_MESSAGE);
    }

    public static void printPurchaseResultMessage(int numberOfPurchasedLottery) {
        System.out.printf(PURCHASE_RESULT_MESSAGE, numberOfPurchasedLottery);
    }

    public static void printLottoNumbers(Lottery lottery) {
        lottery.getLottery()
                .forEach(lotto -> System.out.println(lotto.getLottoNumbers()));
    }

    public static void printWinningNumbersEnteringGuideMessage() {
        System.out.println(WINNING_NUMBERS_ENTERING_GUIDE_MESSAGE);
    }

    public static void printBonusNumbersEnteringGuideMessage() {
        System.out.println(BONUS_NUMBER_ENTERING_GUIDE_MESSAGE);
    }

    public static void printResultMessage(Lottery lottery, WinningLotto winningLotto) {
        System.out.println(RESULT_MESSAGE);

        List<Rank> ranks = new ArrayList<>();
        lottery.getLottery()
                .forEach(lotto -> ranks.add(winningLotto.getRank(lotto)));

        Result result = new Result(ranks);
        result.getResult()
                .forEach((key, value) -> {
                    if (key.equals(Rank.SECOND)) {
                        System.out.printf(SECOND_MESSAGE, value);
                    }

                    if (!key.equals(Rank.SECOND)) {
                        System.out.printf(WINNING_MESSAGE, key.getWinningNumberCount(), key.getWinningPrice(), value);
                    }
                });
    }

    public static void printYieldMessage(double yield) {
        System.out.printf(YIELD_MESSAGE, yield);
    }
}
