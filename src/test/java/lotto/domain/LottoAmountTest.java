package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import constants.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoAmountTest {

    @DisplayName("로또 구입금액이 1000원 단위인 경우")
    @Test
    void canDivide1000() {
        int lottoAmount = 10000;

        assertThatCode(() -> new LottoAmount(lottoAmount))
                .doesNotThrowAnyException();
    }

    @DisplayName("로또 구입금액이 1000원 단위이지 않은 경우")
    @Test
    void cantDivide1000() {
        int lottoAmount = 10100;

        assertThatThrownBy(() -> new LottoAmount(lottoAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.ILLEGAL_LOTTO_AMOUNT);
    }

}