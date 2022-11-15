package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Statistics {

    private final Player player;
    private final List<LottoReward> lottoRewards;
    private final Map<LottoReward, Integer> winningHistory;
    private int usedMoney;
    private long awardMoney;
    private float rateOfReturn;

    public Statistics(List<LottoReward> lottoRewards, Player player) {
        this.player = player;
        this.lottoRewards = lottoRewards;
        this.winningHistory = new HashMap<>();
        winningHistory.put(LottoReward.EMPTY, 0);
        winningHistory.put(LottoReward.FIRST, 0);
        winningHistory.put(LottoReward.SECOND, 0);
        winningHistory.put(LottoReward.THIRD, 0);
        winningHistory.put(LottoReward.FOURTH, 0);
        winningHistory.put(LottoReward.FIFTH, 0);
    }

    public void analysis() {
        usedMoney = player.getMoney();
        setAwardMoney();
        setRateOfReturn();
        setWinningsHistory();
    }

    public int getUsedMoney() {
        return usedMoney;
    }

    public long getAwardMoney() {
        return awardMoney;
    }

    public float getRateOfReturn() {
        return rateOfReturn;
    }

    public Map<LottoReward, Integer> getWinningHistory() {
        return winningHistory;
    }

    private void setWinningsHistory() {
        for (LottoReward lottoReward : lottoRewards) {
            winningHistory.put(lottoReward, winningHistory.get(lottoReward) + 1);
        }
    }

    private void setAwardMoney() {
        for (LottoReward lottoReward : lottoRewards) {
            awardMoney += lottoReward.REWARD;
        }
    }

    public void setRateOfReturn() {
        rateOfReturn = awardMoney / (float) usedMoney * 100;
    }
}
