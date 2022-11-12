package lotto.setting;

import java.util.List;

public enum LottoApplicationSetting {
    NORMAL(LottoSetting.NORMAL,
            List.of(LottoReward.FIRST, LottoReward.SECOND, LottoReward.THIRD, LottoReward.FOURTH, LottoReward.FIFTH));

    private LottoSetting setting;
    private List<LottoReward> rewards;

    LottoApplicationSetting(LottoSetting setting, List<LottoReward> rewards) {
        this.setting = setting;
        this.rewards = rewards;
    }
}
