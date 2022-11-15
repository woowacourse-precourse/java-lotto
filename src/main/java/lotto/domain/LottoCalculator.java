package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.Lotto;
import lotto.util.Result;

public class LottoCalculator {
    private static final int LOTTO_PRICE = 1_000;
    private static final Map<Integer, Integer> RATING_TABLE = new HashMap<>() {{
        put(3, 5);
        put(4, 4);
        put(5, 3);
        put(6, 2);
        put(7, 1);
    }};

    public long getLottoQuantity(long playerMoney) {
        return playerMoney / LOTTO_PRICE;
    }

    public double getRate(long rewardMoney, long playerMoney) {
        double rate = (double) rewardMoney / playerMoney;
        return Math.round(rate * 1000) / 10.0;
    }

    public int getEqualsCount(List<Integer> winningNumbers, int bonusNumber, Lotto playerLotto) {
        int equalsCount = playerLotto.getCompareResult(winningNumbers);
        if (equalsCount == 6) {
            equalsCount = 7;
        }
        if (equalsCount == 5 && playerLotto.isBonusContained(bonusNumber)) {
            equalsCount = 6;
        }
        return equalsCount;
    }

    public int getRank(int equalsCount) {
        return RATING_TABLE.get(equalsCount);
    }

    public long getRewardMoney(Map<Integer, Integer> resultBoard) {
        long rewardMoney = 0L;
        rewardMoney += Result.RANK_ONE.getReward() * resultBoard.get(1);
        rewardMoney += Result.RANK_TWO.getReward() * resultBoard.get(2);
        rewardMoney += Result.RANK_THREE.getReward() * resultBoard.get(3);
        rewardMoney += Result.RANK_FOUR.getReward() * resultBoard.get(4);
        rewardMoney += Result.RANK_FIVE.getReward() * resultBoard.get(5);
        return rewardMoney;
    }
}
