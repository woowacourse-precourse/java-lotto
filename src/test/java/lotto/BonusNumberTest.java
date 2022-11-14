package lotto;

import lotto.domain.BonusNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusNumberTest {
    @DisplayName("보너스 번호의 범위를 벗어날 때 예외가 발생한다.")
    @Test
    void createBonusNumberByOverSize() {
        assertThatThrownBy(() -> new BonusNumber(48))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
