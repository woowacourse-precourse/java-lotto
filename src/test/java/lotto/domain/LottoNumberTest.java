package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoNumberTest {

    @DisplayName("번호가 1부터 45를 벗어나면 에러를 반환한다.")
    @Test
    void createLottoNumberOutOfRange() {
        Assertions.assertAll(
                () -> assertThatThrownBy(() -> LottoNumber.of(0)).isInstanceOf(IllegalArgumentException.class),
                () -> Assertions.assertDoesNotThrow(() -> LottoNumber.of(1)),
                () -> Assertions.assertDoesNotThrow(() -> LottoNumber.of(45)),
                () -> assertThatThrownBy(() -> LottoNumber.of(46)).isInstanceOf(IllegalArgumentException.class)
        );
    }

    @ParameterizedTest(name = "로또 숫자 값을 반환한다.")
    @ValueSource(ints = {1, 4, 16, 25, 35, 43, 45})
    void name(int number) {
        assertThat(LottoNumber.of(number).number()).isEqualTo(number);
    }
}
