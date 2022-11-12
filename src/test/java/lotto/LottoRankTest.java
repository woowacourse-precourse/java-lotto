package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoRankTest {
    @DisplayName("1등의 당첨 금액은 20억이다.")
    @Test
    void testWinPriceOfFirstPlace() {
        LottoRank firstPlace = LottoRank.FIRST;
        assertThat(firstPlace.getWinPrice()).isEqualTo(2000000000);
    }
}