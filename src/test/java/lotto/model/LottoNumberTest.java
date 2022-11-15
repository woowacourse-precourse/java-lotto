package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumberTest {
    @DisplayName("숫자 1~45 범위가 아니라면 예외가 발생한다.")
    @Test
    void createLottoNumberByNumberRange() {
        assertThatThrownBy(() -> new LottoNumber(0)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new LottoNumber(46)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자 1~45 범위로 생성하면 성공한다.")
    @Test
    void createLottoNumber() {
        assertDoesNotThrow(() -> new LottoNumber(1));
        assertDoesNotThrow(() -> new LottoNumber(5));
        assertDoesNotThrow(() -> new LottoNumber(45));
    }

    @DisplayName("문자열 1~45 범위가 아니라면 예외가 발생한다.")
    @Test
    void createBonusNumberByNumberRange() {
        assertThatThrownBy(() -> new LottoNumber("a")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new LottoNumber("")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new LottoNumber("0")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new LottoNumber("46")).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("문자열 1~45 범위로 생성하면 성공한다.")
    @Test
    void createBonusNumber() {
        assertDoesNotThrow(() -> new LottoNumber("1"));
        assertDoesNotThrow(() -> new LottoNumber("5"));
        assertDoesNotThrow(() -> new LottoNumber("45"));
    }
}