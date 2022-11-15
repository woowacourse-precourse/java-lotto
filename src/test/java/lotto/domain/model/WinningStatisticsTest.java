package lotto.domain.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;
import lotto.domain.model.enums.Reward;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningStatisticsTest {

    private WinningStatistics winningStatistics;

    @BeforeEach
    @DisplayName("당첨 통계 test를 위한 setting")
    void SETTING() {
        winningStatistics = new WinningStatistics(new HashMap<>(Map.of(
                Reward.FIRST, 0,
                Reward.SECOND, 0,
                Reward.THIRD, 0,
                Reward.FOURTH, 0,
                Reward.FIFTH, 1
        )));
    }

    @Test
    @DisplayName("수익률을 제대로 계산하는지 확인하기 위한 test")
    void getRateOfReturn() {
        double rate = winningStatistics.getRateOfReturn(5000);
        assertThat(rate).isEqualTo(100);
    }
}