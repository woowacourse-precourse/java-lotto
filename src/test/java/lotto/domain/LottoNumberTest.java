package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberTest {
    @DisplayName("숫자 1 ~ 45 내로 입력 시 정상적으로 생성된다.")
    @ValueSource(ints = {1, 3, 5, 8, 10, 22, 28, 40, 35, 45})
    @ParameterizedTest(name = "입력 받은 돈 : {0}")
    void validLottoNumber(int lottoNumber) {
        Assertions.assertThatNoException().isThrownBy(() -> new LottoNumber(lottoNumber));
    }

    @DisplayName("숫자 1 ~ 45 외의 범위 입력 시 예외가 발생한다.")
    @ValueSource(ints = {-1, 0, 46, 50})
    @ParameterizedTest(name = "입력 받은 돈 : {0}")
    void invalidLottoNumber(int lottoNumber) {
        Assertions.assertThatThrownBy(() -> new LottoNumber(lottoNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}