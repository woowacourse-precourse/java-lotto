package lotto.view;

public class OutputView {
    static final String LOTTO_PURCHASE_MESSAGE = "개를 구매했습니다.";

    static final String LINE_BREAK = "\n";

    public static void printLottoPurchaseCount(long lottoCount) {
        System.out.printf(LINE_BREAK + "%d" + LOTTO_PURCHASE_MESSAGE + LINE_BREAK, lottoCount);
    }
}
