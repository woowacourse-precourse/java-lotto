package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumberTest {
    @DisplayName("숫자 1~45 범위가 아니라면 예외가 발생한다.")
    @Test
    void createLottoNumberByNumberRange() {
        Assertions.assertThatThrownBy(() -> new LottoNumber(0)).isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> new LottoNumber(46)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("문자열 1~45 범위가 아니라면 예외가 발생한다.")
    @Test
    void createBonusNumberByNumberRange() {
        Assertions.assertThatThrownBy(() -> new LottoNumber("a")).isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> new LottoNumber("")).isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> new LottoNumber("0")).isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> new LottoNumber("46")).isInstanceOf(IllegalArgumentException.class);
    }
}