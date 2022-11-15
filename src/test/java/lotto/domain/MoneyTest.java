package lotto.domain;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class MoneyTest {
    private static final String ERROR_MESSAGE = "[ERROR]";
    private View view = new View();
    @DisplayName("구입 금액이 1000원의 배수가 아니면 예외가 발생한다.")
    @Test
    void moneyNotMultipleOf1000() {
        assertThatThrownBy(() -> view.validateIsDivisible(4500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("구입 금액에 숫자가 아닌 값이 있으면 예외가 발생한다.")
    @Test
    void moneyIsNotInteger() {
        assertThatThrownBy(() -> view.validateIsNumber("42d9"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }
}
