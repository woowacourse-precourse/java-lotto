package lotto.util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import lotto.model.Lotto;
import lotto.model.LottoRank;
import lotto.model.Lottos;
import lotto.model.WinningNumber;

public class LottoCalculator {

    public static Map<LottoRank, Integer> calculateWinCount(Lottos lottos, WinningNumber winningNumber) {
        Map<LottoRank, Integer> winCount = new HashMap<>();
        Arrays.stream(LottoRank.values())
            .filter(l -> l != LottoRank.NONE)
            .forEach(l -> winCount.put(l, 0));
        List<Integer> winningNumbers = winningNumber.getWinningNumbers();
        int bonusNumber = winningNumber.getBonusNumber();
        for(Lotto lotto : lottos.getLottos()) {
            int correctCount = calculateCorrectCount(winningNumbers, lotto.getNumbers());
            boolean isBonus = hasBonusNumber(lotto.getNumbers(), bonusNumber);
            LottoRank rank = LottoRank.findLottoRank(correctCount, isBonus);
            int preCount = getPreCount(winCount, rank);
            winCount.put(rank, preCount+1);
        }
        return winCount;
    }

    private static int calculateCorrectCount(List<Integer> winningNumbers, List<Integer> lottoNumbers) {
        int correctCount = 0;
        for(Integer number : lottoNumbers) {
            if(winningNumbers.contains(number)) {
                correctCount++;
            }
        }
        return correctCount;
    }

    private static boolean hasBonusNumber (List<Integer> lottoNumbers, int bonusNumber) {
        return lottoNumbers.contains(bonusNumber);
    }

    private static int getPreCount(Map<LottoRank, Integer> winCount, LottoRank rank) {
        if(winCount.containsKey(rank)) {
            return winCount.get(rank);
        }
        return 0;
    }

    public static double calculateYield(Map<LottoRank, Integer> winCount, int purchaseAmount) {
        long sum = 0;
        Set<LottoRank> lottoRanks = winCount.keySet();
        for(LottoRank lottoRank : lottoRanks) {
            sum += winCount.get(lottoRank) * lottoRank.getReward();
        }
        return (double) sum / purchaseAmount * 100;
    }
}
