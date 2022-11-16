package domain;

import java.util.Map;

public class LottoResult {
    private final Map <LottoRank,Integer> result = LottoRank.initializeMap();

    public LottoResult(LotteryMachine lotteryMachine, WinningNumber winningNumber) {
        for (Lotto lotto : lotteryMachine.getLottos()) {
            LottoRank lottoRank = LottoRank.findRank(lotto.sameNumberCount(winningNumber),
                    lotto.containBonusNumber(winningNumber));
            result.put(lottoRank, result.getOrDefault(lottoRank, 0) + 1);
        }
    }

    public double profitPercent(int purchaseMoney) {
        return  ((double)allWinning() / (double)purchaseMoney) * 100;
    }

    private long allWinning() {
        return result.entrySet().stream().filter(e -> e.getValue() >= 1
        ).map(e -> e.getKey().getPrize() * e.getValue()).mapToLong(e -> e).sum();
    }

    public Map <LottoRank,Integer> getResult() {
        return this.result;
    }
}
