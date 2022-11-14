package lotto.ui;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputMoneyTest extends NsTest{
    private static final String ERROR_MESSAGE = "[ERROR]";
    @Test
    void 구입금액_음수() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("-246"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ERROR_MESSAGE + " 음수가 아닌 정수를 입력해야 합니다.");
        });
    }
    @Test
    void 구입금액_정수아닌수() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("25.0"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ERROR_MESSAGE + " 정수를 입력해야 합니다.");
        });
    }
    @Test
    void 구입금액_1000의배수아닌수() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("1700"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ERROR_MESSAGE + " 구입금액은 1000으로 나누어 떨어져야 합니다.");
        });
    }
    @Override
    public void runMain() {
        Input.scanPurchaseAmount();
    }
}
