package lotto.ui;

import lotto.utils.OutputMessage;

public class Output {
    public static void inputPurchaseAmountMessage() {
        System.out.println(OutputMessage.INPUT_PURCHASE_AMOUNT);
    }

    public static void lottoCount(Integer count) {
        System.out.println(count.toString() + OutputMessage.LOTTO_COUNT);
    }
}
