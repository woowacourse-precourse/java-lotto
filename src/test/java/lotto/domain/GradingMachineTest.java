package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GradingMachineTest {

    @DisplayName("보너스 숫자가 로또에 포함")
    @Test
    void validateContainBonusNumberTest() {
        assertThatThrownBy(
                () -> new GradingMachine(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), 1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 숫자의 범위 테스트")
    @Test
    void validateBonusNumberRangeTest() {
        assertThatThrownBy(
                () -> new GradingMachine(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), 46))
                .isInstanceOf(IllegalArgumentException.class);
    }

}