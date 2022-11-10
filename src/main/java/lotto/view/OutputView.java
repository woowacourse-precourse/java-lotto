package lotto.view;

public class OutputView {

    private static final String PURCHASE_LOTTO = "%d개를 구매했습니다.";

    public void printPurchaseLotto(int count) {
        System.out.printf(PURCHASE_LOTTO, count);
    }
}
