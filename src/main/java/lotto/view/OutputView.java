package lotto.view;

import lotto.constant.OutputMessage;
import lotto.domain.Lotto;
import lotto.domain.PurchasedLottos;

public class OutputView {
    public static void printPriceInputMessage(){
        System.out.println(OutputMessage.PRICE_INPUT_MESSAGE);
    }

    public static void printPurchasedLottos(PurchasedLottos purchasedLottos){
        System.out.printf(OutputMessage.PURCHASED_LOTTO_MESSAGE,purchasedLottos.getLottoCount());
        for (Lotto lotto:purchasedLottos.getLottos()) {
            System.out.println(lotto.getNumbers().toString());
        }
    }

    public static void printWinningNumbersInputMessage(){
        System.out.println(OutputMessage.WINNING_NUMBERS_INPUT_MESSAGE);
    }
}
