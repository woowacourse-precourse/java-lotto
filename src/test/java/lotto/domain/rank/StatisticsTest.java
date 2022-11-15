package lotto.domain.rank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class StatisticsTest {

    private Statistics statistics;

    @BeforeEach
    void init() {
        statistics = new Statistics();
    }

    @DisplayName("당첨 금액에 대한 총 수익률을 구한다.")
    @Test
    void getLottoYield() {
        int purchaseAmount = 30010000;
        double lottoYield = statistics.findLottoYield(purchaseAmount);
        assertThat(lottoYield).isEqualTo(3001000.0);
    }
}
