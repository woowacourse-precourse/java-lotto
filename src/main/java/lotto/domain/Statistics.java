package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Statistics {
    private final Map<Rank, Integer> result;
    private final long reward;
    private final double yield;

    public Statistics(List<Lotto> lottos, WinLotto winLotto, Money money) {
        this.result = calculateResult(lottos, winLotto);
        this.reward = calculateReward(this.result);
        this.yield = calculateYield(money.getMoney());
    }

    public Map<Rank, Integer> initResult() {
        Map<Rank, Integer> result = new HashMap<>();
        for (Rank rank : Rank.values()) {
            result.put(rank, 0);
        }
        return result;
    }

    private Integer checkMatchNumbers(Lotto lotto, WinLotto winLotto) {
        Integer winLottoBonusNumber = winLotto.getBonusNumber();
        int matchCount = 0;
        for (Integer number : winLotto.getWinNumbers()) {
            if (lotto.getNumbers().contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    private boolean checkBonusNumber(Lotto lotto, WinLotto winLotto) {
        return lotto.getNumbers().contains(winLotto.getBonusNumber());
    }

    private Rank checkRank(int matchCount, boolean matchBonus) {
        for (Rank rank : Rank.values()) {
            if (rank.getMatchCount() == matchCount && rank.getMatchBonus() == matchBonus) {
                return rank;
            }
        }
        return Rank.ETC;
    }

    private Map<Rank, Integer> calculateResult(List<Lotto> lottos, WinLotto winLotto) {
        Map<Rank, Integer> result = initResult();
        for (Lotto lotto : lottos) {
            int matchCount = checkMatchNumbers(lotto, winLotto);
            boolean matchBonus = checkBonusNumber(lotto, winLotto);
            Rank rank = checkRank(matchCount, matchBonus);
            result.put(rank, result.get(rank) + 1);
        }
        return result;
    }

    private long calculateReward(Map<Rank, Integer> result) {
        long reward = 0;
        for (Rank rank : Rank.values()) {
            reward += rank.getReward() * result.get(rank);
        }
        return reward;
    }

    private double calculateYield(int money) {
        return Math.round((double) this.reward / (double) money * 1000) / 10.0;
    }

    public Map<Rank, Integer> getResult() {
        return result;
    }

    public long getReward() {
        return reward;
    }

    public double getYield() {
        return yield;
    }
}
