package lotto.domain;

import lotto.domain.enums.Number;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {

    private List<Lotto> lottos;
    private double money;
    private double winningAmount;
    private Map<Number, Integer> rankResult = new HashMap<>();
    private double yield;

    public User() {
        lottos = new ArrayList<>();
        winningAmount = 0;
        initRank();
        yield = 0;
    }

    private void initRank() {
        rankResult.put(Number.FIVE, 0);
        rankResult.put(Number.FOUR, 0);
        rankResult.put(Number.THREE, 0);
        rankResult.put(Number.TWO, 0);
        rankResult.put(Number.ONE, 0);
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
        return rankResult;
    }

    public void setRank(Map<Number, Integer> rank) {
        this.rankResult = rank;
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

    public void updateRankAndWinningAmount(int rank) {
        if (rank == Number.FIVE.getValue()) {
            rankResult.put(Number.FIVE, rankResult.get(Number.FIVE) + 1);
            this.winningAmount += Number.FIFTH_WINNING_AMOUNT.getValue();
        }
        if (rank == Number.FOUR.getValue()) {
            rankResult.put(Number.FOUR, rankResult.get(Number.FOUR) + 1);
            this.winningAmount += Number.FOURTH_WINNING_AMOUNT.getValue();
        }
        if (rank == Number.THREE.getValue()) {
            rankResult.put(Number.THREE, rankResult.get(Number.THREE) + 1);
            this.winningAmount += Number.THIRD_WINNING_AMOUNT.getValue();
        }
        if (rank == Number.TWO.getValue()) {
            rankResult.put(Number.TWO, rankResult.get(Number.TWO) + 1);
            this.winningAmount += Number.SECOND_WINNING_AMOUNT.getValue();
        }
        if (rank == Number.ONE.getValue()) {
            rankResult.put(Number.ONE, rankResult.get(Number.ONE) + 1);
            this.winningAmount += Number.FIRST_WINNING_AMOUNT.getValue();
        }
    }
}
