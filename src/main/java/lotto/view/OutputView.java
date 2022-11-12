package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

public class OutputView {
    private static final String PURCHASE = "개를 구매했습니다.";

    private OutputView() {}

    public static void printPurchase(int count, List<Lotto> lottos) {
        System.out.println(count + PURCHASE);
        lottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }
}
