package lotto.domain;

import lotto.domain.constant.ConstantValue;
import lotto.domain.enums.Rank;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {

    private List<Lotto> lottos;
    private double money;
    private double totalPrize;
    private Map<Rank, Integer> ranks = new HashMap<>();
    private double yield;

    public User() {
        lottos = new ArrayList<>();
        totalPrize = 0;
        initRank();
        yield = 0;
    }

    private void initRank() {
        ranks.put(Rank.FIFTH, 0);
        ranks.put(Rank.FOURTH, 0);
        ranks.put(Rank.THIRD, 0);
        ranks.put(Rank.SECOND, 0);
        ranks.put(Rank.FIRST, 0);
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

    public Map<Rank, Integer> getRanks() {
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
        ranks.put(Rank.FIFTH, ranks.get(Rank.FIFTH) + ConstantValue.ONE);
        addWinningAmount(ConstantValue.FIFTH_WINNING_AMOUNT);
    }

    public void setRankFourth() {
        ranks.put(Rank.FOURTH, ranks.get(Rank.FOURTH) + ConstantValue.ONE);
        addWinningAmount(ConstantValue.FOURTH_WINNING_AMOUNT);
    }

    public void setRankThird() {
        ranks.put(Rank.THIRD, ranks.get(Rank.THIRD) + ConstantValue.ONE);
        addWinningAmount(ConstantValue.THIRD_WINNING_AMOUNT);
    }

    public void setRankSecond() {
        ranks.put(Rank.SECOND, ranks.get(Rank.SECOND) + ConstantValue.ONE);
        addWinningAmount(ConstantValue.SECOND_WINNING_AMOUNT);
    }

    public void setRankFirst() {
        ranks.put(Rank.FIRST, ranks.get(Rank.FIRST) + ConstantValue.ONE);
        addWinningAmount(ConstantValue.FIRST_WINNING_AMOUNT);
    }
}
