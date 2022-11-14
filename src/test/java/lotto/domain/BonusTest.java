package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusTest {
    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    @DisplayName("보너스 번호가 1~45 숫자 범위에 포함되지 않은 경우 예외가 발생한다.")
    void createBonusByExceedNumberRange(int input) {
        assertThatThrownBy(() -> new Bonus(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
