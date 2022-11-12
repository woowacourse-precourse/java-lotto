package lotto;

import static lotto.view.BuyerView.inputMoney;

public class Buyer {
    public int money;

    public Buyer() {
        this.money = getMoney();
    }

    public Buyer(int money) {
        this.money = money;
    }

    public int getMoney() {
        return inputMoney();
    }
}
