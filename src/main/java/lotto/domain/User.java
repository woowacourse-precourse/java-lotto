package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class User {

    private List<Lotto> lottos = new ArrayList<>();
    private Long money;
    private Long winningAmount;
    private int rank;
    private double yield;

    public User(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void setLottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Long getMoney() {
        return money;
    }

    public void setMoney(Long money) {
        this.money = money;
    }

    public Long getWinningAmount() {
        return winningAmount;
    }

    public void setWinningAmount(Long winningAmount) {
        this.winningAmount = winningAmount;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public double getYield() {
        return yield;
    }

    public void setYield(double yield) {
        this.yield = yield;
    }

    public double calculateYield() {
        return (double)(winningAmount / money);
    }
}
