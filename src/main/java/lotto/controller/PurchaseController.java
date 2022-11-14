package lotto.controller;

import lotto.model.Purchase;

public class PurchaseController extends Controller{
    public int inputMoneyByUser() {
        outputView.printInputPurchaseMoneySentence();

        String moneyInput = inputView.input();
        validate(moneyInput);

        return Integer.parseInt(moneyInput);
    }

    private void validate(String input) {
        String regex = "^[0-9]{1,3}000$";
        if (!input.matches(regex)) {
            throw new IllegalArgumentException(FORMAT_ERROR_MESSAGE);
        }
    }

    public int purchaseLotto(int money) {
        Purchase purchase = new Purchase();
        return purchase.changeToLotto(money);
    }
}
