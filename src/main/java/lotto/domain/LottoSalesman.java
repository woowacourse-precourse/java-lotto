package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public enum LottoSalesman {
    INSTANCE;
    public static final int MONEY_UNIT = 1000;

    private static int countPurchasedLotto(int money) {
        return money / MONEY_UNIT;
    }

    public static List<Lotto> sales(int money) {
        List<Lotto> lotteries = new ArrayList<>();

        int quantity = countPurchasedLotto(money);
        while (quantity > 0) {
            Lotto lotto = LottoIssuer.issue();
            lotteries.add(lotto);
            quantity--;
        }

        return lotteries;
    }

}
