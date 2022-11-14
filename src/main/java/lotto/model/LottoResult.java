package lotto.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LottoResult {

    private final Map<LottoRank, Integer> winCount;
    private final double yield;

    public LottoResult(Lottos lottos, WinningNumber winningNumber) {
        this.winCount = new HashMap<>();
        calculateWinCount(lottos, winningNumber);
        this.yield = calculateYield(lottos.getPurchaseAmount());
    }

    private void calculateWinCount(Lottos lottos, WinningNumber winningNumber) {
        Arrays.stream(LottoRank.values())
            .filter(l -> l != LottoRank.NONE)
            .forEach(l -> winCount.put(l, 0));
        List<Integer> winningNumbers = winningNumber.getWinningNumbers();
        int bonusNumber = winningNumber.getBonusNumber();
        for(Lotto lotto : lottos.getLottos()) {
            int correctCount = 0;
            boolean isBonus = false;
            for(Integer number : lotto.getNumbers()) {
                if(winningNumbers.contains(number)) {
                    correctCount++;
                }
                if(number == bonusNumber) {
                    isBonus = true;
                }
            }
            LottoRank rank = LottoRank.findLottoRank(correctCount, isBonus);
            int count = getCount(rank);
            winCount.put(rank, count+1);
        }
    }

    private int getCount(LottoRank rank) {
        if(winCount.containsKey(rank)) {
            return winCount.get(rank);
        }
        return 0;
    }

    private double calculateYield(int purchaseAmount) {
        long sum = 0;
        Set<LottoRank> lottoRanks = winCount.keySet();
        for(LottoRank lottoRank : lottoRanks) {
            sum += winCount.get(lottoRank) * lottoRank.getReward();
        }
        return (double) sum / purchaseAmount * 100;
//        return ((double)Math.round(sum / purchaseAmount * 1000)/10);
    }

    public Map<LottoRank, Integer> getWinCount() {
        return winCount;
    }

    public double getYield() {
        return yield;
    }
}
