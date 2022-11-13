package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class AskForMoneyTest extends NsTest {
    /* askForMoney Test */
    @DisplayName("구입 금액이 숫자로만 이루어지지 않으면 예외가 발생한다.")
    @Test
    void checkOnlyNumberTest() {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException("1000j"))
                .isInstanceOf(IllegalArgumentException.class));
    }

    @DisplayName("구입 금액이 1000원으로 나누어 떨어지지 않으면 예외가 발생한다.")
    @Test
    void checkDivisibleNumberTest() {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException("1100"))
                .isInstanceOf(IllegalArgumentException.class));
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
