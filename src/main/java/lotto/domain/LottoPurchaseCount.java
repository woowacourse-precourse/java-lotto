package lotto.domain;

import lotto.validation.Validator;

public class LottoPurchaseCount {

    public static int getLottoCount(int money) {
        Validator.isDividedByThousand(money);
        return getMoney(money);
    }

    private static int getMoney(int money) {
        if (money % 1000 == 0) {
            money /= 1000;
        }
        return money;
    }
}
