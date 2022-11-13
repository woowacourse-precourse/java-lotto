package lotto.controller;

import lotto.model.EarningRate;
import lotto.model.Purchase;
import lotto.view.InputView;
import lotto.view.OutputView;

public class PurchaseController extends Controller{
    public int inputMoneyByUser() {
        outputView.printInputPurchaseMoneySentence();

        String moneyInput = inputView.input();
        validate(moneyInput);

        return Integer.parseInt(moneyInput);
    }

    private void validate(String input) {
        // TODO: 검증 기능
    }
}
