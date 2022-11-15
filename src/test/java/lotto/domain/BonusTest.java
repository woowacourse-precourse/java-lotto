package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class BonusTest {
    @ValueSource(ints = {1, 45})
    @ParameterizedTest
    void 보너스_번호를_생성한다(int number) {
        assertDoesNotThrow(() -> new Bonus(number));
    }

    @ValueSource(ints = {-1, 0, 46})
    @ParameterizedTest
    void _1_이상_45_이하가_아니면_예외가_발생한다(int number) {
        assertThatThrownBy(() -> new Bonus(number))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
