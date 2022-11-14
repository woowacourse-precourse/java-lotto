package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {

    private List<Lotto> lottos = new ArrayList<>();
    private double money;
    private double winningAmount;
    private Map<Number, Integer> rank = new HashMap<>();
    private double yield;

    public User() {
    }

    public User(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void setLottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Double getWinningAmount() {
        return winningAmount;
    }

    public void setWinningAmount(Double winningAmount) {
        this.winningAmount = winningAmount;
    }

    public Map<Number, Integer> getRank() {
        return rank;
    }

    public void setRank(Map<Number, Integer> rank) {
        this.rank = rank;
    }

    public double getYield() {
        return yield;
    }

    public void setYield(double yield) {
        this.yield = yield;
    }

    public double calculateYield() {
        double yield = this.winningAmount / this.money;
        yield *= 1000;
        yield = Math.round(yield);
        yield /= 10;
        return yield;
    }

    public int getLottoCount() {
        return this.lottos.size();
    }
}
