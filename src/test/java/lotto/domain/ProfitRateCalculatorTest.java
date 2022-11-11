package lotto.domain;

import lotto.constant.Score;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static lotto.constant.Score.THREE;
import static org.assertj.core.api.Assertions.assertThat;

class ProfitRateCalculatorTest {

    @DisplayName("수익률 계산 테스트")
    @Test
    void createProfitRate() {
        //given
        Map<Score, Integer> scoreStore = LottoScore.setInitialSetting();
        scoreStore.put(THREE, 1);

        //when
        String profitRate = ProfitRateCalculator.getProfitRate(scoreStore, 8000);

        //then
        assertThat(profitRate).isEqualTo("62.5");
    }
}