package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;


class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 4, 6, 9, 44, 45, 23, 43})
    @DisplayName("LottoNumber를 1~45사이의 값으로 생성하면 LottoNumber에는 해당 값이 들어 있다.")
    void LottoNumber_값생성_테스트(int intArgs) {
        LottoNumber lottoNumber = new LottoNumber(intArgs);
        assertThat(lottoNumber.getValue()).isEqualTo(intArgs);
    }

    @ParameterizedTest
    @ValueSource(ints = {-11, -4, 0, 46, 455, 123})
    @DisplayName("LottoNumber를 1~45이외의 값으로 생성하면 LottoNumber는 예외를 발생시킨다.")
    void LottoNumber_예외_테스트(int intArgs) {
        assertThatThrownBy(()->new LottoNumber(intArgs))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR]: 로또 숫자는 1에서 45사이의 값이여야 합니다.");
    }

}