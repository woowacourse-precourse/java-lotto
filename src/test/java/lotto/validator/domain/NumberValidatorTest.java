package lotto.validator.domain;

import lotto.validator.domain.NumberValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class NumberValidatorTest {
    @DisplayName("로또 범위 벗어났는지 확인")
    @ParameterizedTest(name = "{displayName} => {0}")
    @ValueSource(ints = {0, 46})
    void isOutOfRange(final int lottoNumber) {
        assertThat(NumberValidator.isOutOfRange(lottoNumber)).isTrue();
    }
}