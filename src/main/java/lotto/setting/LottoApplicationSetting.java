package lotto.setting;

import lotto.lotto.LottoShop;
import lotto.reward.RewardCoordinator;
import lotto.winningnumber.WinningNumber;
import java.util.List;

public enum LottoApplicationSetting {
    NORMAL(1000, LottoSetting.NORMAL, WinningNumberSetting.NORMAL,
            List.of(LottoReward.FIRST, LottoReward.SECOND, LottoReward.THIRD, LottoReward.FOURTH, LottoReward.FIFTH));

    private int price;
    private LottoSetting lottoSetting;
    private WinningNumberSetting winningNumberSetting;
    private List<LottoReward> rewards;

    LottoApplicationSetting(int price,
                            LottoSetting lottoSetting,
                            WinningNumberSetting winningNumberSetting,
                            List<LottoReward> rewards) {
        this.price = price;
        this.lottoSetting = lottoSetting;
        this.winningNumberSetting = winningNumberSetting;
        this.rewards = rewards;
    }

    public LottoShop createLottoShop() {
        return new LottoShop(price, lottoSetting);
    }

    public WinningNumber createWinningNumber(List<Integer> numbers, List<Integer> bonusNumbers) {
        return new WinningNumber(numbers, bonusNumbers, winningNumberSetting);
    }

    public RewardCoordinator createRewardCoordinator(WinningNumber winningNumber, int purchasePrice) {
        return new RewardCoordinator(winningNumber, rewards, purchasePrice);
    }
}
