package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LottoAnswerTest {
    @Test
    @DisplayName("기본흐름: 사용자가 올바른 당첨 번호와 보너스 번호를 입력한 경우")
    void LottoOrder_ValidInput_Success() {
        assertThatNoException().isThrownBy(() -> new LottoAnswer("1,2,3,4,5,6", "7"));
    }

    @Test
    @DisplayName("예외흐름: 사용자가 숫자가 아닌 값을 입력한 경우1")
    void LottoOrder_InvalidInput1_IllegalArgumentExceptionThrown() {
        assertThatThrownBy(() -> new LottoAnswer("1,two,3,4,5,6", "7"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoErrorCode.INVALID_LOTTO_RANGE.toString());
    }

    @Test
    @DisplayName("예외흐름: 사용자가 숫자가 아닌 값을 입력한 경우2")
    void LottoOrder_InvalidInput2_IllegalArgumentExceptionThrown() {
        assertThatThrownBy(() -> new LottoAnswer("1,2,3,4,5,6", "seven"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoErrorCode.INVALID_LOTTO_RANGE.toString());
    }

    @Test
    @DisplayName("예외흐름: 유효하지 않은 범위의 숫자를 입력한 경우1")
    void LottoOrder_InvalidRange1_IllegalArgumentExceptionThrown() {
        assertThatThrownBy(() -> new LottoAnswer("0,2,3,4,5,6", "7"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoErrorCode.INVALID_LOTTO_RANGE.toString());
    }

    @Test
    @DisplayName("예외흐름: 유효하지 않은 범위의 숫자를 입력한 경우2")
    void LottoOrder_InvalidRange2_IllegalArgumentExceptionThrown() {
        assertThatThrownBy(() -> new LottoAnswer("1,2,3,4,5,46", "7"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoErrorCode.INVALID_LOTTO_RANGE.toString());
    }

    @Test
    @DisplayName("예외흐름: 유효하지 않은 범위의 숫자를 입력한 경우3")
    void LottoOrder_InvalidRange3_IllegalArgumentExceptionThrown() {
        assertThatThrownBy(() -> new LottoAnswer("1,2,3,4,5,6", "0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoErrorCode.INVALID_LOTTO_RANGE.toString());
    }

    @Test
    @DisplayName("예외흐름: 유효하지 않은 범위의 숫자를 입력한 경우4")
    void LottoOrder_InvalidRange4_IllegalArgumentExceptionThrown() {
        assertThatThrownBy(() -> new LottoAnswer("1,2,3,4,5,6", "47"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoErrorCode.INVALID_LOTTO_RANGE.toString());
    }

    @Test
    @DisplayName("예외흐름: 중복된 숫자를 입력한 경우1")
    void LottoOrder_DuplicateNumber1_IllegalArgumentExceptionThrown() {
        assertThatThrownBy(() -> new LottoAnswer("1,2,3,4,5,5", "7"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoErrorCode.DUPLICATE_LOTTO_NUMBER.toString());
    }

    @Test
    @DisplayName("예외흐름: 중복된 숫자를 입력한 경우2")
    void LottoOrder_DuplicateNumber2_IllegalArgumentExceptionThrown() {
        assertThatThrownBy(() -> new LottoAnswer("1,2,3,4,5,6", "3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoErrorCode.DUPLICATE_LOTTO_NUMBER.toString());
    }
}