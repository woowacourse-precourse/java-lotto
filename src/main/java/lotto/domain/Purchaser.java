package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Purchaser {
    private int money;
    private int numberOfLotto;
    private List<Lotto> lottos;

    public Purchaser(int money) {
        this.money = money;
        this.numberOfLotto = computeNumberOfLotto(money);
        lottos = new ArrayList<>();
    }

    private int computeNumberOfLotto(int money) {
        return money % 1000;
    }
}