package view;

import java.util.List;

public class OutputView {
    public static final String SHOW_MADE_PURCHASE = "개를 구매했습니다.";

    public static void showMadePurchase(int chance) {
        System.out.println(chance+SHOW_MADE_PURCHASE);
    }

    public static void showRandomLottoNumbers(List<Integer> randomLotto) {
        System.out.println(randomLotto);
    }
}
