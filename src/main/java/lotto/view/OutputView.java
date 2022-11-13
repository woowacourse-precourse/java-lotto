package lotto.view;

import java.util.List;

public class OutputView {

    private static final String PURCHASE_GUIDE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String PURCHASE_RESULT_MESSAGE = "%d개를 구매했습니다.\n";

    public static void printPurchaseGuideMessage() {
        System.out.println(PURCHASE_GUIDE_MESSAGE);
    }

    public static void printPurchaseResultMessage(int numberOfPurchasedLottey) {
        System.out.printf(PURCHASE_RESULT_MESSAGE, numberOfPurchasedLottey);
    }

    public static void printLottoNumbers(List<Integer> lottoNumbers) {
        System.out.println(lottoNumbers.toString());
    }
}
