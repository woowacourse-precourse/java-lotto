package lotto;

import lotto.domain.BonusNumber;
import lotto.domain.WinningNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusNumberTest {

    @DisplayName("1~45 범위 외의 숫자일 경우 예외 발생")
    @Test
    void createBonusByIncorrectRangeNumber() {
        assertThatThrownBy(() -> new BonusNumber(46))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자 외 형식이 들어올 경우 예외 발생")
    @Test
    void createBonusByWrongFormatNumber() {
        assertThatThrownBy(() -> new BonusNumber("a"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
