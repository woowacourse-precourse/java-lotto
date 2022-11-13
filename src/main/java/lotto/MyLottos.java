package lotto;

import java.util.List;

public class MyLottos {
    private int number;
    private List<Lotto> lotto;

    public MyLottos(int money) {
        this.number = money / 1000;
    }
}