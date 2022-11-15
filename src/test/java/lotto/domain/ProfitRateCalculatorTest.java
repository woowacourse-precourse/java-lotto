package lotto.domain;

import lotto.config.Score;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static lotto.config.Score.THREE;
import static org.assertj.core.api.Assertions.assertThat;

class ProfitRateCalculatorTest {

    @AfterEach
    void clear() {
        Map<Score, Integer> scoreStore = LottoScore.setInitialSetting();
        scoreStore.clear();
    }

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