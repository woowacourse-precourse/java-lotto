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
    private Map<Number, Integer> ranks = new HashMap<>();
    private double yield;

    public User() {
        lottos = new ArrayList<>();
        winningAmount = 0;
        initRank();
        yield = 0;
    }

    private void initRank() {
        ranks.put(Number.FIVE, 0);
        ranks.put(Number.FOUR, 0);
        ranks.put(Number.THREE, 0);
        ranks.put(Number.TWO, 0);
        ranks.put(Number.ONE, 0);
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

    public Map<Number, Integer> getRanks() {
        return ranks;
    }

    public void setRanks(Map<Number, Integer> rank) {
        this.ranks = rank;
    }

    public double getYield() {
        return yield;
    }

    public void calculateYield() {
        double yield = this.winningAmount / this.money;
        yield *= 1000;
        yield = Math.round(yield);
        yield /= 10;
        this.yield = yield;
    }

    public int getLottoCount() {
        return this.lottos.size();
    }

    public void updateRankAndWinningAmount(int rank) {
        if (rank == Number.FIVE.getValue()) {
            ranks.put(Number.FIVE, ranks.get(Number.FIVE) + 1);
            this.winningAmount += Number.FIFTH_WINNING_AMOUNT.getValue();
        }
        if (rank == Number.FOUR.getValue()) {
            ranks.put(Number.FOUR, ranks.get(Number.FOUR) + 1);
            this.winningAmount += Number.FOURTH_WINNING_AMOUNT.getValue();
        }
        if (rank == Number.THREE.getValue()) {
            ranks.put(Number.THREE, ranks.get(Number.THREE) + 1);
            this.winningAmount += Number.THIRD_WINNING_AMOUNT.getValue();
        }
        if (rank == Number.TWO.getValue()) {
            ranks.put(Number.TWO, ranks.get(Number.TWO) + 1);
            this.winningAmount += Number.SECOND_WINNING_AMOUNT.getValue();
        }
        if (rank == Number.ONE.getValue()) {
            ranks.put(Number.ONE, ranks.get(Number.ONE) + 1);
            this.winningAmount += Number.FIRST_WINNING_AMOUNT.getValue();
        }
    }
}
