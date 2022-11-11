package lotto;

import java.util.List;

public class Wallet {
    private List<Lotto> myLottos;
    private final int money;
    private int profit;

    Wallet(int money) {
        this.money = money;
        profit = 0;
    }

    public int getMoney() {
        return money;
    }

    public void getLottos(List<Lotto> boughtLottos) {
        myLottos = boughtLottos;
    }

    public void showMyLottos() {
        for(Lotto l : myLottos) {
            System.out.println(l.getNumbers().toString());
        }
    }
}
