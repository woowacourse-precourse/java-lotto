package lotto.result;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class RewardEnumTest {

    @Test
    void getReward() {
        assertThat(RewardEnum.NONE.getReward()).isEqualTo(0);
        assertThat(RewardEnum.WIN_3.getReward()).isEqualTo(5_000);
        assertThat(RewardEnum.WIN_4.getReward()).isEqualTo(50_000);
        assertThat(RewardEnum.WIN_5.getReward()).isEqualTo(1_500_000);
        assertThat(RewardEnum.WIN_5_BONUS.getReward()).isEqualTo(30_000_000);
        assertThat(RewardEnum.WIN_6.getReward()).isEqualTo(2_000_000_000);
    }

    @Test
    void getFromResult() {
        assertThat(RewardEnum.getFromResult(0, false)).isEqualTo(RewardEnum.NONE);
        assertThat(RewardEnum.getFromResult(1, false)).isEqualTo(RewardEnum.NONE);
        assertThat(RewardEnum.getFromResult(2, false)).isEqualTo(RewardEnum.NONE);
        assertThat(RewardEnum.getFromResult(3, false)).isEqualTo(RewardEnum.WIN_3);
        assertThat(RewardEnum.getFromResult(4, false)).isEqualTo(RewardEnum.WIN_4);
        assertThat(RewardEnum.getFromResult(5, false)).isEqualTo(RewardEnum.WIN_5);
        assertThat(RewardEnum.getFromResult(6, false)).isEqualTo(RewardEnum.WIN_6);

        assertThat(RewardEnum.getFromResult(0, true)).isEqualTo(RewardEnum.NONE);
        assertThat(RewardEnum.getFromResult(1, true)).isEqualTo(RewardEnum.NONE);
        assertThat(RewardEnum.getFromResult(2, true)).isEqualTo(RewardEnum.NONE);
        assertThat(RewardEnum.getFromResult(3, true)).isEqualTo(RewardEnum.WIN_3);
        assertThat(RewardEnum.getFromResult(4, true)).isEqualTo(RewardEnum.WIN_4);
        assertThat(RewardEnum.getFromResult(5, true)).isEqualTo(RewardEnum.WIN_5_BONUS);
        assertThat(RewardEnum.getFromResult(6, true)).isEqualTo(RewardEnum.WIN_6);

        assertThat(RewardEnum.getFromResult(999, true)).isEqualTo(RewardEnum.NONE);
    }
}