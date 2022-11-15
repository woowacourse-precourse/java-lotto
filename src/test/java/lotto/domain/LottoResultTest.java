package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoResultTest {

    @DisplayName("3개 미만 일치하면 FAILED")
    @Test
    void failed() {
        assertThat(LottoResult.valueOf(2, true)).isEqualTo(LottoResult.FAILED);
    }

    @DisplayName("5개 일치, 보너스 숫자가 일치하면 SECOND")
    @Test
    void second() {
        assertThat(LottoResult.valueOf(5, true)).isEqualTo(LottoResult.SECOND);
    }

    @DisplayName("5개만 일치하면 THIRD")
    @Test
    void third() {
        assertThat(LottoResult.valueOf(5, false)).isEqualTo(LottoResult.THIRD);
    }

    @DisplayName("6개가 일치하면 FIRST")
    @Test
    void first() {
        assertThat(LottoResult.valueOf(6, false)).isEqualTo(LottoResult.FIRST);
    }

    @DisplayName("낙첨 복권인지 확인한다.")
    @Test
    void 낙첨_복권_확인() {
        assertTrue(LottoResult.FIRST.isNotFailed());
    }

    @DisplayName("당첨 복권 수를 받아 당첨 금액을 계산한다.")
    @Test
    void 당첨금액_계산() {
        assertThat(LottoResult.FIRST.calculatePrizeMoney(6)).isEqualTo(2000000000L * 6);
    }

}