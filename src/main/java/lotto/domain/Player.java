package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private List<Lotto> lottos;
    private int money;

    public Player() {
        lottos = new ArrayList<>();
        money = 0;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void setLottos(List<Lotto> lotteries) {
        this.lottos = lotteries;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

}
