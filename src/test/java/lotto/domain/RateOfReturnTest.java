package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RateOfReturnTest {
    @DisplayName("총 수익률을 계산한다. : 8000원 사용해서 5등에 1개 당첨되면 총 수익률은 62.5")
    @Test
    public void calculateRateOfReturn() {
        RateOfReturn rateOfReturn = new RateOfReturn(Rank.FIFTH.getWinnings(), 8000);

        assertThat(rateOfReturn.calculate()).isEqualTo(62.5);
    }
}