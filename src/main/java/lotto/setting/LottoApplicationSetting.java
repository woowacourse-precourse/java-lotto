package lotto.setting;

import java.util.List;

public enum LottoApplicationSetting {
    NORMAL(LottoSetting.NORMAL, WinningNumberSetting.NORMAL,
            List.of(LottoReward.FIRST, LottoReward.SECOND, LottoReward.THIRD, LottoReward.FOURTH, LottoReward.FIFTH));

    private LottoSetting lottoSetting;
    private WinningNumberSetting winningNumberSetting;
    private List<LottoReward> rewards;

    LottoApplicationSetting(LottoSetting lottoSetting,
                            WinningNumberSetting winningNumberSetting,
                            List<LottoReward> rewards) {
        this.lottoSetting = lottoSetting;
        this.winningNumberSetting = winningNumberSetting;
        this.rewards = rewards;
    }
}
