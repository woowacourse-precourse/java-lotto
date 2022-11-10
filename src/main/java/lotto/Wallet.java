package lotto;

import java.util.List;

public class Wallet {
    List<Lotto> myLottos;
    private final int money;
    private int profit;

    Wallet(int money) {
        this.money = money;
        profit = 0;
    }

    public void getLottos(List<Lotto> boughtLottos) {
        myLottos = boughtLottos;
    }
}
