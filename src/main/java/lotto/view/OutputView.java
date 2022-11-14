package lotto.view;

import java.util.List;

public class OutputView {

    private static final String PURCHASE_GUIDE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String PURCHASE_RESULT_MESSAGE = "\n%d개를 구매했습니다.\n";
    private static final String WINNING_NUMBERS_ENTERING_GUIDE_MESSAGE = "\n당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_ENTERING_GUIDE_MESSAGE = "\n보너스 번호를 입력해 주세요.";
    private static final String YIELD_MESSAGE = "총 수익률은 %.1f%입니다.\n";

    public static void printPurchaseGuideMessage() {
        System.out.println(PURCHASE_GUIDE_MESSAGE);
    }

    public static void printPurchaseResultMessage(int numberOfPurchasedLottery) {
        System.out.printf(PURCHASE_RESULT_MESSAGE, numberOfPurchasedLottery);
    }

    public static void printLottoNumbers(List<Integer> lottoNumbers) {
        System.out.println(lottoNumbers.toString());
    }

    public static void printWinningNumbersEnteringGuideMessage() {
        System.out.println(WINNING_NUMBERS_ENTERING_GUIDE_MESSAGE);
    }

    public static void printBonusNumbersEnteringGuideMessage() {
        System.out.println(BONUS_NUMBER_ENTERING_GUIDE_MESSAGE);
    }

    public static void printYieldMessage(double yield) {
        System.out.printf(YIELD_MESSAGE, yield);
    }
}
