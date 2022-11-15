package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.RandomLottoNumberGenerator;

import java.util.List;

public class LottoService {
    private final RandomLottoNumberGenerator randomLottoNumberGenerator;

    public LottoService() {
        this.randomLottoNumberGenerator = new RandomLottoNumberGenerator();
    }

    public List<List<Integer>> makeRandomLottoNumbers(int lottoCount) {
        List<List<Integer>> lottoNumbersList = randomLottoNumberGenerator.makeRandomLottoNumberList(lottoCount);
        return lottoNumbersList;
    }

    public int[] compareUserNumbersAndWinningNumber(List<List<Integer>> lottoNumbersList, List<Integer> winningNumberList, int bonusNumber) {
        Lotto lotto = new Lotto(winningNumberList);
        int[] ranks = new int[6];
        for(List<Integer> userLottoList : lottoNumbersList) {
            int rank = lotto.compareWinningNumberAndUserNumber(userLottoList);
            if(rank == 2) {
                rank--;
                ranks[rank]++;
            }
            if(rank == 3) {
                rank = compareUserNumberSAndBonusNumber(lotto, userLottoList, bonusNumber);
                ranks[rank]++;
            }
            if(rank < 6 && rank > 3) {
                ranks[rank]++;
            }
        }
        return ranks;
    }

    private int compareUserNumberSAndBonusNumber(Lotto lotto, List<Integer> userNumbers, int bonusNumber) {
        int rank = lotto.compareUserNumberAndBonusNumber(userNumbers, bonusNumber);
        return rank;
    }

    public String calculateProfit(int[] ranks, int lottoCount) {
        double totalReward = ranks[1] * Reward.FIRST.getRewardPrice()
                + ranks[2] * Reward.SECOND.getRewardPrice()
                + ranks[3] * Reward.THIRD.getRewardPrice()
                + ranks[4] * Reward.FORTH.getRewardPrice()
                + ranks[5] * Reward.FIFTH.getRewardPrice();

        double profit = totalReward / (lottoCount * 1000) * 100;
        String result = String.format("%.1f", profit);
        return result;
    }



}
