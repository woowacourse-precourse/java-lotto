package lotto.console;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    @DisplayName("구입_금액_예외_테스트")
    void validateMoney() {
        try {
            Input.validateMoney(0);
        } catch (RuntimeException e) {
            assertThat(e.getMessage()).contains(Constants.LOTTO_MONEY_EXCEPTION);
        }

        try {
            Input.validateMoney(1001);
        } catch (RuntimeException e) {
            assertThat(e.getMessage()).contains(Constants.LOTTO_MONEY_EXCEPTION);
        }
    }
}