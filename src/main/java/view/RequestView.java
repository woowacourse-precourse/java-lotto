package view;

import util.LottoMessage;

public class RequestView {

    public RequestView() {}

    public void displayEnterPurchaseAmount() {
        System.out.println(LottoMessage.ENTER_INPUT_AMOUNT);
    }

    public void displayEnterWinnerNumber() {
        System.out.println(LottoMessage.ENTER_WINNER_NUMBER);
    }

    public void displayEnterBonusNumber() {
        System.out.println(LottoMessage.ENTER_BONUS_NUMBER);
    }
}
