package lotto;

import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RandomLottosTest {
    private static final String ERROR_MESSAGE = "[ERROR]";
    @Test
    void 구입금액_1000의배수아닌수() {
        assertThatThrownBy(() -> new RandomLottos(1700))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_MESSAGE + " 구입금액은 1000으로 나누어 떨어져야 합니다.");
    }
    @Test
    void 구입금액_음수() {
        assertThatThrownBy(() -> new RandomLottos(-1000))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_MESSAGE + " 음수가 아닌 정수를 입력해야 합니다.");
    }
}
