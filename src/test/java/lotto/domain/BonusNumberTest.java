package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusNumberTest {
    @DisplayName("입력값이 숫자가 아니면 예외가 발생한다.")
    @Test
    void createBonusNumberByNoNumericElement() {
        assertThatThrownBy(() -> new BonusNumber("a,", List.of(2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 당첨번호와 중복되었다면 예외가 발생한다.")
    @Test
    void createBonusNumberByDuplicatedWithWinningNumber() {
        assertThatThrownBy(() -> new BonusNumber("2,", List.of(2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 범위 밖의 숫자라면 예외가 발생한다.")
    @Test
    void createBonusNumberByOutOfRangeNumber() {
        assertThatThrownBy(() -> new BonusNumber("57,", List.of(2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
