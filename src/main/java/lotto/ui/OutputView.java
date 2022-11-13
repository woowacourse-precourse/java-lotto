package lotto.ui;

import java.util.List;

public class OutputView {
    private static final String BUYING_N_AMOUNT = "개를 구매헸습니다.";

    public static void outputBuyingAmount(int buyingMoney) {
        System.out.println(buyingMoney/1000 + BUYING_N_AMOUNT);
    }
    public static void outputLotto(List<Integer> numbers) {
        System.out.println(numbers);
    }
}
