package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoOrderTest {
    @Test
    @DisplayName("기본흐름: 사용자가 구매금액으로 8000원을 입력한 경우")
    void LottoOrder_ValidInput_Success() {
        LottoOrder lottoOrder = new LottoOrder("8000");
        assertThat(lottoOrder.getLottoCount()).isEqualTo(8);
    }

    @Test
    @DisplayName("예외흐름: 사용자가 구매금액으로 숫자가 아닌 값을 입력한 경우")
    void LottoOrder_InvalidInput1_IllegalArgumentExceptionThrown() {
        assertThatThrownBy(() -> new LottoOrder("three thousand"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoErrorCode.INVALID_MONEY.toString());
    }

    @Test
    @DisplayName("예외흐름: 사용자가 구매금액으로 로또 금액 배수가 아닌 값을 입력한 경우")
    void LottoOrder_InvalidInput2_IllegalArgumentExceptionThrown() {
        assertThatThrownBy(() -> new LottoOrder("1200"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoErrorCode.INVALID_MONEY.toString());
    }

    @Test
    @DisplayName("예외흐름: 사용자가 구매금액으로 0을 입력한 경우")
    void LottoOrder_InvalidInput3_IllegalArgumentExceptionThrown() {
        assertThatThrownBy(() -> new LottoOrder("0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoErrorCode.INVALID_MONEY.toString());
    }
}