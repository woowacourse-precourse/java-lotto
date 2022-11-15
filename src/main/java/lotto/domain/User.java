package lotto.domain;

import lotto.domain.constant.ConstantValue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {

    private List<Lotto> lottos;
    private double money;
    private double totalPrize;
    private Map<Integer, Integer> ranks = new HashMap<>();
    private double yield;

    public User() {
        lottos = new ArrayList<>();
        totalPrize = 0;
        initRank();
        yield = 0;
    }

    private void initRank() {
        ranks.put(ConstantValue.FIVE, 0);
        ranks.put(ConstantValue.FOUR, 0);
        ranks.put(ConstantValue.THREE, 0);
        ranks.put(ConstantValue.TWO, 0);
        ranks.put(ConstantValue.ONE, 0);
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

    public double getTotalPrize() {
        return totalPrize;
    }

    public void setTotalPrize(double totalPrize) {
        this.totalPrize = totalPrize;
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
        this.totalPrize += winningAmount;
    }

    public void setRankFifth() {
        ranks.put(ConstantValue.FIVE, ranks.get(ConstantValue.FIVE) + ConstantValue.ONE);
        addWinningAmount(ConstantValue.FIFTH_WINNING_AMOUNT);
    }

    public void setRankFourth() {
        ranks.put(ConstantValue.FOUR, ranks.get(ConstantValue.FOUR) + ConstantValue.ONE);
        addWinningAmount(ConstantValue.FOURTH_WINNING_AMOUNT);
    }

    public void setRankThird() {
        ranks.put(ConstantValue.THREE, ranks.get(ConstantValue.THREE) + ConstantValue.ONE);
        addWinningAmount(ConstantValue.THIRD_WINNING_AMOUNT);
    }

    public void setRankSecond() {
        ranks.put(ConstantValue.TWO, ranks.get(ConstantValue.TWO) + ConstantValue.ONE);
        addWinningAmount(ConstantValue.SECOND_WINNING_AMOUNT);
    }

    public void setRankFirst() {
        ranks.put(ConstantValue.ONE, ranks.get(ConstantValue.ONE) + ConstantValue.ONE);
        addWinningAmount(ConstantValue.FIRST_WINNING_AMOUNT);
    }
}
