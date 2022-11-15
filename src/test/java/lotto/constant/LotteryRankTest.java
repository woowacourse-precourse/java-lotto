package lotto.constant;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LotteryRankTest {
    @DisplayName("일치 숫자가 5개, 보너스 숫자가 있다고 주어지면 2등을 반환한다.")
    @Test
    void findSecondRank() {
        assertThat(LotteryRank.findRank(5, true))
                .isEqualTo(LotteryRank.SECOND);
    }

    @DisplayName("일치 숫자가 5개, 보너스 숫자가 없다고 주어지면 3등을 반환한다.")
    @Test
    void findThirdRank() {
        assertThat(LotteryRank.findRank(5, false))
                .isEqualTo(LotteryRank.THIRD);
    }

    @DisplayName("일치 숫자가 5개가 아닐때 보너스 숫자가 있다고 주어지면 일치 숫자에 맞는 rank를 반환한다.")
    @Test
    void findRankExceptSecondAndThirdWhenHasBonusNumber() {
        assertThat(LotteryRank.findRank(5, true))
                .isEqualTo(LotteryRank.SECOND);
    }
}
