package lotto.reward;

import lotto.lotto.Lotto;
import lotto.setting.LottoReward;
import lotto.winningnumber.WinningNumber;
import java.util.List;

public class RewardCoordinator {

    private final int NOT_REWARD = -1;

    private WinningNumber winningNumber;
    private List<LottoReward> rewards;

    public RewardCoordinator(WinningNumber winningNumber,
                             List<LottoReward> rewards) {
        this.winningNumber = winningNumber;
        this.rewards = rewards;
    }

    public String getRewardResult(List<Lotto> lottos) {
        int[] totalResult = new int[rewards.size()];
        long totalPrice = 0;

        for (Lotto lotto : lottos) {
            int index = getRewardIndex(lotto);
            if (index == NOT_REWARD){
                continue;
            }
            totalResult[index]++;
            totalPrice += rewards.get(index).getPrize();
        }
        return printResult(totalResult);
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

    private String printResult(int[] totalResult) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int index = totalResult.length-1; index >= 0; index--) {
            String result = rewards.get(index).getRewardInfo() + " - " + totalResult[index] + "개\n";
            stringBuilder.append(result);
        }
        return stringBuilder.toString();
    }
}
