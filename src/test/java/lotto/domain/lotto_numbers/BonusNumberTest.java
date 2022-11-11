package lotto.domain.lotto_numbers;

import static lotto.domain.lotto_numbers.Lotto.INVALID_RANGE_OF_LOTTO_NUMBER;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BonusNumberTest {

    @ParameterizedTest(name = "1부터 45가 아닌 숫자가 들어오면 예외를 던진다.")
    @ValueSource(ints = {0, 46})
    void createBonusNumberByInvalidNumber(int invalidNumber) {
        assertThatThrownBy(() -> new BonusNumber(invalidNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_RANGE_OF_LOTTO_NUMBER);
    }
}