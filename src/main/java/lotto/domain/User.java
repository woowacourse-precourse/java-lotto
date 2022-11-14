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
    private Map<Integer, Integer> ranks = new HashMap<>();
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

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void setLottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public double getWinningAmount() {
        return winningAmount;
    }

    public void setWinningAmount(double winningAmount) {
        this.winningAmount = winningAmount;
    }

    public Map<Integer, Integer> getRanks() {
        return ranks;
    }

    public double getYield() {
        return yield;
    }

    public void setYield(double yield) {
        this.yield = yield;
    }

    public int getLottoCount() {
        return this.lottos.size();
    }

    public void addWinningAmount(int winningAmount) {
        this.winningAmount += winningAmount;
    }

    public void setRankFifth() {
        ranks.put(Number.FIVE, ranks.get(Number.FIVE) + Number.ONE);
        addWinningAmount(Number.FIFTH_WINNING_AMOUNT);
    }

    public void setRankFourth() {
        ranks.put(Number.FOUR, ranks.get(Number.FOUR) + Number.ONE);
        addWinningAmount(Number.FOURTH_WINNING_AMOUNT);
    }

    public void setRankThird() {
        ranks.put(Number.THREE, ranks.get(Number.THREE) + Number.ONE);
        addWinningAmount(Number.THIRD_WINNING_AMOUNT);
    }

    public void setRankSecond() {
        ranks.put(Number.TWO, ranks.get(Number.TWO) + Number.ONE);
        addWinningAmount(Number.SECOND_WINNING_AMOUNT);
    }

    public void setRankFirst() {
        ranks.put(Number.ONE, ranks.get(Number.ONE) + Number.ONE);
        addWinningAmount(Number.FIRST_WINNING_AMOUNT);
    }
}
