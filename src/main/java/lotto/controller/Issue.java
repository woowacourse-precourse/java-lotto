package lotto.controller;

import static lotto.view.InputView.InputPrice;


public class Issue {
    public int count;

    public Issue() {
        int userPrice = InputPrice();
        this.count = CountLotto(userPrice);
    }

    private int CountLotto(int userPrice) {
        int count = userPrice/1000;
        return count;
    }

}
