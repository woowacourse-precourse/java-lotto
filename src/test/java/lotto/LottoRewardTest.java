package lotto;

import lotto.domain.LottoReward;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoRewardTest {
    @DisplayName("등수가 제대로 나오는가")
    @Test
    void isRightRank() {
        LottoReward rank_1 = LottoReward.getRank(6, false);
        LottoReward rank_2 = LottoReward.getRank(5, true);
        LottoReward rank_3 = LottoReward.getRank(5, false);
        LottoReward rank_4 = LottoReward.getRank(4, false);
        LottoReward rank_5 = LottoReward.getRank(3, false);

        Assertions.assertEquals(LottoReward.FIRST, rank_1);
        Assertions.assertEquals(LottoReward.SECOND, rank_2);
        Assertions.assertEquals(LottoReward.THIRD, rank_3);
        Assertions.assertEquals(LottoReward.FOURTH, rank_4);
        Assertions.assertEquals(LottoReward.FIFTH, rank_5);
    }

    @DisplayName("찾는 등수가 없다면")
    @Test
    void isRankExistence() {
        assertThatThrownBy(() -> LottoReward.getRank(2, false))
                .isInstanceOf(IllegalArgumentException.class);
    }
}