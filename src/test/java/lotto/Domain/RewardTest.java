package lotto.Domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RewardTest {
    @DisplayName("적중 개수, 보너스 번호 적중 여부에 따라 Reward를 잘 생성하는지 확인 ")
    @Test
    void makeReward_SECOND() {
        Reward ranKing = Reward.getRanKing(5, true);
        assertThat(ranKing).isEqualTo(Reward.SECOND);
    }

    @DisplayName("당첨 금액과 적중 개수를 반환하는지 확인")
    @Test
    void makeReward_FIRST() {
        Reward ranKing = Reward.getRanKing(6, true);
        assertThat(ranKing.getCount()).isEqualTo(6);
        assertThat(ranKing.getReward()).isEqualTo(2000000000);

        Reward ranKing2 = Reward.getRanKing(5, false);
        assertThat(ranKing2.getCount()).isEqualTo(5);
        assertThat(ranKing2.getReward()).isEqualTo(1500000);
    }
}