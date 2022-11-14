package lotto.view;

public class OutputView {

    private static final String LINE_FEED = "\n";
    private static final String PURCHASE_NUM_MESSAGE = "개를 구매했습니다.";

    public static void printPurchaseNum(int number) {
        System.out.println(LINE_FEED + number + PURCHASE_NUM_MESSAGE);
    }
}
