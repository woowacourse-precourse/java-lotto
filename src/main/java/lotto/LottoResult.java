package lotto;

import java.util.Map;

public class LottoResult {
    private final Map<LottoPrize, Integer> result;

    public LottoResult(Map<LottoPrize, Integer> result) {
        validate(result);
        addKey(result);

        this.result = result;
    }

    private void addKey(Map<LottoPrize, Integer> result) {
        for (LottoPrize prize : LottoPrize.values()) {
            result.put(prize, result.getOrDefault(prize, 0));
        }
    }

    private void validate(Map<LottoPrize, Integer> result) {
        if (result == null) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }

    public int getPrize(LottoPrize prize) {
        return result.get(prize);
    }

    public double getRate() {
        int spendMoneyAll = 0;
        int rewardAll = 0;

        for (LottoPrize prize : LottoPrize.values()) {
            int prizeNum = result.get(prize);
            spendMoneyAll += prizeNum * 1000;
            rewardAll += prize.getTotalReward(prizeNum);
        }

        return (double) rewardAll / spendMoneyAll;
    }
}
