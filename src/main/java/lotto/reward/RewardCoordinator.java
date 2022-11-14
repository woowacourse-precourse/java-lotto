package lotto.reward;

import lotto.lotto.Lotto;
import lotto.setting.LottoReward;
import lotto.winningnumber.WinningNumber;
import java.util.List;

public class RewardCoordinator {

    private final int NOT_REWARD = -1;

    private WinningNumber winningNumber;
    private List<LottoReward> rewards;
    private int purchasePrice;

    public RewardCoordinator(WinningNumber winningNumber,
                             List<LottoReward> rewards,
                             int purchasePrice) {
        this.winningNumber = winningNumber;
        this.rewards = rewards;
        this.purchasePrice = purchasePrice;
    }

    public String getRewardResult(List<Lotto> lottos) {
        int[] totalResult = new int[rewards.size()];
        long totalReward = 0;

        for (Lotto lotto : lottos) {
            int index = getRewardIndex(lotto);
            if (index == NOT_REWARD){
                continue;
            }
            totalResult[index]++;
            totalReward += rewards.get(index).getPrize();
        }
        return printResult(totalResult, totalReward);
    }

    private int getRewardIndex(Lotto lotto) {
        int currentMatch = winningNumber.countNumberMatched(lotto);
        int currentBonusMatch = winningNumber.countBonusNumberMatched(lotto);
        for (int index = 0; index < rewards.size(); index++) {
            LottoReward reward = rewards.get(index);
            if (reward.isSatisfyMatchingCondition(currentMatch, currentBonusMatch)) {
                return index;
            }
        }
        return NOT_REWARD;
    }

    private String printResult(int[] totalResult, long totalReward) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int index = totalResult.length-1; index >= 0; index--) {
            String result = rewards.get(index).getRewardInfo() + " - " + totalResult[index] + "개\n";
            stringBuilder.append(result);
        }
        stringBuilder.append("총 수익률은 " + formattedRate(totalReward) + "%입니다.");

        return stringBuilder.toString();
    }

    private String formattedRate(long totalReward) {
        return String.format("%.1f", (double) totalReward / purchasePrice * 100);
    }
}
