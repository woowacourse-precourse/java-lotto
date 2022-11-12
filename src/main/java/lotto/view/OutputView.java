package lotto.view;

public class OutputView {
    private static final String PURCHASE = "개를 구매했습니다.";

    private OutputView() {}

    public static void printPurchase(int count) {
        System.out.println(count + PURCHASE);
    }
}
