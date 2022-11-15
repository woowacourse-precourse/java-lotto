package lotto.domain;

import lotto.domain.exception.IllegalArgumentException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusTest {
    @ParameterizedTest(name = "보너스 번호가 1~45 숫자 범위에 포함되지 않은 경우 예외가 발생한다. (보너스 번호 : {0})")
    @ValueSource(ints = {0, 46})
    void createBonusByExceedNumberRange(int input) {
        assertThatThrownBy(() -> new Bonus(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
