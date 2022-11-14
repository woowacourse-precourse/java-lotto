package lotto.ui;

public class OutputView {
    private static final String PURCHASE_MESSAGE = "개를 구매했습니다.";

    public void printPurchaseMessage(int lottoGameCount) {
        System.out.println(lottoGameCount + PURCHASE_MESSAGE);
    }

}
