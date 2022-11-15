package lotto.domain;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class BonusTest {
    private static final String ERROR_MESSAGE = "[ERROR]";
    private View view = new View();

    @DisplayName("보너스 입력값이 숫자가 아니면 예외가 발생한다")
    @Test
    void bonusNotInteger() {
        assertThatThrownBy(() -> view.validateIsNumber("j"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("보너스 입력값이 범위 밖이면 예외가 발생한다.")
    @Test
    void bonusOutOfRange() {
        assertThatThrownBy(() -> view.validateNumberInRange(450))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("보너스 입력값이 로또 당첨값과 중복이면 예외가 발생한다.")
    @Test
    void bonusIsRepeat() {
        assertThatThrownBy(() -> view.validateUniqueNumber(List.of(3, 5, 10, 14, 31, 32), 5))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

}
