package lotto.view;

import java.util.List;

public class OutputView {

    private static final String PURCHASE_GUIDE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String PURCHASE_RESULT_MESSAGE = "%d개를 구매했습니다.\n";
    private static final String WINNIG_NUMBERS_ENTERING_GUIDE_MESSAGE = "당첨 번호를 입력해 주세요.";

    public static void printPurchaseGuideMessage() {
        System.out.println(PURCHASE_GUIDE_MESSAGE);
    }

    public static void printPurchaseResultMessage(int numberOfPurchasedLottey) {
        System.out.printf(PURCHASE_RESULT_MESSAGE, numberOfPurchasedLottey);
    }

    public static void printLottoNumbers(List<Integer> lottoNumbers) {
        System.out.println(lottoNumbers.toString());
    }

    public static void printWinningNumbersEnteringGuideMessage() {
        System.out.println(WINNIG_NUMBERS_ENTERING_GUIDE_MESSAGE);
    }
}
