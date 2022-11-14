package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LottoStatisticsTest {



    @DisplayName("")
    @Test
    void calculatePercentageOfProfit() {
        String percentageOfprofit = "62.5";

        LottoStatistics lottoStatistics = new LottoStatistics(8000, 5000);
        assertThat(lottoStatistics.getPercentageOfProfit()).isEqualTo(percentageOfprofit);
    }
}