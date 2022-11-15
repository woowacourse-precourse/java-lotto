package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Winnings {

    private Map<RewardType, Integer> rewardTable;

    public Winnings(List<Lotto> lottos, Win win, Bonus bonus) {
        Map<RewardType, Integer> rewardTable = new HashMap<>();

        for (Lotto lotto : lottos) {
            RewardType rewardType = matchLotto(lotto, win, bonus);
            if (rewardType != null) {
                rewardTable.put(rewardType, rewardTable.getOrDefault(rewardType, 0) + 1);
            }
        }

        this.rewardTable = rewardTable;
    }

    private RewardType matchLotto(Lotto lotto, Win win, Bonus bonus) {
        int matchingWinningCount = 0;
        int matchingBonusCount = 0;

        for (Integer winningNumber : win.getNumbers()) {
            if (lotto.getNumbers().contains(winningNumber)) {
                matchingWinningCount++;
            }
        }

        if (lotto.getNumbers().contains(bonus.getNumber())) {
            matchingBonusCount++;
        }

        return getRewardType(matchingWinningCount, matchingBonusCount);
    }

    private static RewardType getRewardType(int matchingWinningCount, int matchingBonusCount) {
        if (matchingWinningCount == 6) {
            return RewardType.SIX;
        }
        if (matchingWinningCount == 5 && matchingBonusCount == 1) {
            return RewardType.FIVE_WITH_BONUS;
        }
        if (matchingWinningCount + matchingBonusCount == 5) {
            return RewardType.FIVE;
        }
        if (matchingWinningCount + matchingBonusCount == 4) {
            return RewardType.FOUR;
        }
        if (matchingWinningCount + matchingBonusCount == 3) {
            return RewardType.THREE;
        }
        return null;
    }

    public void printResult(Money money) {
        int result = 0;
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + rewardTable.get(RewardType.THREE));
        result += RewardType.THREE.getReward();
        System.out.println("4개 일치 (50,000원) - " + rewardTable.get(RewardType.FOUR));
        result += RewardType.FOUR.getReward();
        System.out.println("5개 일치 (1,500,000원) - " + rewardTable.get(RewardType.FIVE));
        result += RewardType.FIVE.getReward();
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + rewardTable.get(RewardType.FIVE_WITH_BONUS));
        result += RewardType.FIVE_WITH_BONUS.getReward();
        System.out.println("6개 일치 (2,000,000,000원) - " + rewardTable.get(RewardType.SIX));
        result += RewardType.SIX.getReward();

        System.out.println("총 수익률은 " + Math.round(((result * 100) / money.getMoney())));
    }
}
