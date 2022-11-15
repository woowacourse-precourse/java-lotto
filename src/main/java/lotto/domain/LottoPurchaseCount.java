package lotto.domain;

import lotto.validation.Validator;

public class LottoPurchaseCount {

    public static int getLottoPurchaseCount(int money) {
        Validator.isDividedByThousand(money);
        return calculateLottoPurchaseCount(money);
    }

    private static int calculateLottoPurchaseCount(int money) {
        int lottoPurchaseCount = money / 1000;
        return lottoPurchaseCount;
    }
}
