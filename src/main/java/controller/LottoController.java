package controller;

import input.MoneyInput;
import view.RequestView;

public class LottoController {

    private RequestView requestView = new RequestView();
    private MoneyInput moneyInput = new MoneyInput();

    public void purchase() {
        requestView.displayEnterPurchaseAmount();
        int money = moneyInput.getPurchaseAmount();
    }

    public void winnerNumber() {
        requestView.displayEnterWinnerNumber();
    }

    public void bonusNumber() {
        requestView.displayEnterBonusNumber();
    }

}
