package lotto.controller;

import static lotto.view.InputView.InputPrice;


public class Issue {
    public int count;

    public Issue() {
        int userPrice = InputPrice();
        if (!Check1000(userPrice)) {
            throw new IllegalArgumentException("[ERROR] 구매 가격이 1,000원 단위가 아닙니다.");
        }
        this.count = CountLotto(userPrice);
    }

    private int CountLotto(int userPrice) {
        int count = userPrice/1000;
        return count;
    }

    private boolean Check1000(int userPrice) {
        if (userPrice%1000 == 0) {
            return true;
        }
        return false;
    }
}
