package lotto.domain;

import lotto.constant.LotteryRank;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LotteryResultTest {
    @DisplayName("LotteryResult Rank별 개수와 상금을 조회한다.")
    @Test
    void addSeveralResult() {
        LotteryResult result = new LotteryResult();
        result.add("ticket1", LotteryRank.SECOND);
        result.add("ticket2", LotteryRank.FIFTH);
        result.add("ticket3", LotteryRank.LOSE_BY_ONE);
        result.add("ticket4", LotteryRank.FIFTH);

        SoftAssertions softAssertions = new SoftAssertions();

        softAssertions.assertThat(result.findByRank(LotteryRank.SECOND)).isEqualTo(1);
        softAssertions.assertThat(result.findByRank(LotteryRank.FIFTH)).isEqualTo(2);
        softAssertions.assertThat(result.findByRank(LotteryRank.LOSE_BY_ONE)).isEqualTo(1);
        softAssertions.assertThat(result.getTotalReward()).isEqualTo(30_010_000L);
        softAssertions.assertThat(result.hasTicket("ticket1")).isTrue();
        softAssertions.assertThat(result.getSize()).isEqualTo(4);
        softAssertions.assertAll();
    }

    @DisplayName("상금이 Integer의 최댓값을 넘어도 정상 동작한다.")
    @Test
    void addResultWithRewardOverIntegerMaxValue() {
        LotteryResult result = new LotteryResult();
        result.add("ticket1", LotteryRank.FIRST);
        result.add("ticket2", LotteryRank.FIRST);
        result.add("ticket3", LotteryRank.SECOND);

        assertThat(result.getTotalReward()).isEqualTo(4_030_000_000L);
    }
}
