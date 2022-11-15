package lotto.ui;

import lotto.domain.Lotto;
import lotto.utils.OutputMessage;

import java.util.List;

public class Output {
    public static void inputPurchaseAmountMessage() {
        System.out.println(OutputMessage.INPUT_PURCHASE_AMOUNT);
    }

    public static void lottoCount(int count) {
        System.out.println(String.valueOf(count) + OutputMessage.LOTTO_COUNT);
    }

    public static void sortedLotto(List<Lotto> lottos) {
        System.out.println(lottos);
    }

    public static void inputWinningNumberMessage() {
        System.out.println(OutputMessage.INPUT_WINNING_NUMBER);
    }
}
