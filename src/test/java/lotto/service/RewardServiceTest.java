package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;
import static lotto.utils.Constants.FIRST_PLACE;
import static lotto.utils.Constants.LAST_PLACE;

import lotto.domain.Ranking;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RewardServiceTest {

    @DisplayName("당첨된 로또의 개수와 등 수에 맞는 당첨금을 계산한다.")
    @Test
    void 총_당첨금_계산() {
        int[] rankingCount = {0, 1, 1, 1, 1, 1};
        long totalReward1 = RewardService.calcuateReward(rankingCount);

        long totalReward2 = 0;
        for (int ranking = FIRST_PLACE; ranking <= LAST_PLACE; ranking++) {
            totalReward2 += Ranking.values()[ranking].getReward();
        }

        assertThat(totalReward1)
                .isEqualTo(totalReward2);
    }

    @DisplayName("구매 금액과 당첨금을 통해 총 수익률을 계산한다.")
    @Test
    void 총_수익률_계산() {
        int purchaseAmount = 10_000;
        long reward = 100_000;

        assertThat(RewardService.calculateRateOfReturn(purchaseAmount, reward))
                .isEqualTo(1000.0);
    }
}