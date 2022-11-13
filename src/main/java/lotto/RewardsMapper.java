package lotto;

public class RewardsMapper {

    private WinningNumbers winningNumbers;

    private final int SECOND_OR_THIRD_PlACE_MATCHING_NUMBER = 5;

    public RewardsMapper(WinningNumbers winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public Rewards getReward(Lotto lotto) {
        int matchingNumberCount = getMatchingNumberCount(lotto);
        boolean isBonusNumberMatches = isBonusNumberMatches(lotto);
        if (matchingNumberCount != SECOND_OR_THIRD_PlACE_MATCHING_NUMBER) {
            isBonusNumberMatches = false;
        }
        return Rewards.getReward(matchingNumberCount, isBonusNumberMatches);
    }

    private int getMatchingNumberCount(Lotto lotto) {
        int matchingNumberCounts = 0;
        for (int idx = 0; idx < winningNumbers.getWinningNumbers().size(); idx++) {
            if (this.winningNumbers.getWinningNumbers().contains(lotto.getLottoNumber(idx))) {
                matchingNumberCounts++;
            }
        }
        return matchingNumberCounts;
    }

    private boolean isBonusNumberMatches(Lotto lotto) {
        return this.winningNumbers.getWinningBonusNumber() == lotto.getBonusNumber();
    }
}
