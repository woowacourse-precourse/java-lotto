package lotto.view;

import lotto.util.constants.GameConstants;

public class GameMessage {

    public void printInputPurchaseAmount() {
        print(GameConstants.INPUT_PURCHASE_AMOUNT);
    }

    public void printLottoTicketCount(int lottoTicketCount) {
        print("\n" + lottoTicketCount + GameConstants.OUTPUT_PURCHASE_LOTTO_COUNT);
    }

    public void print(String printString) {
        System.out.println(printString);
    }
}
