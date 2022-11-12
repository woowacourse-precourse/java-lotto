package lotto.constants;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.constants.LottoResult;
import org.junit.jupiter.api.Test;

class LottoResultTest {


    @Test
    void getPrize_CoinIsTrue() {
        assertThat((LottoResult.getPrizeByCorrectCount(6))).isEqualTo(2_000_000_000);
    }
}