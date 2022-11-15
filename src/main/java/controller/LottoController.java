package controller;

import domain.Buyer;
import view.BuyerInputView;

public class LottoController {
    private Buyer buyer;

    public void lottoStart() {
        buyLotto();
    }

    private void buyLotto() {
        String inputNum = BuyerInputView.getInputPrice();
        buyer = new Buyer(inputNum);
    }
}
