package lotto.ui;

public class OutputView {
    private static String BUYING_N_AMOUNT = "개를 구매헸습니다.";

    public static void outputBuyingAmount(int buyingMoney) {
        System.out.println(buyingMoney/1000 + BUYING_N_AMOUNT);
    }
}
