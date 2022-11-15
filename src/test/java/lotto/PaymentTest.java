package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PaymentTest extends NsTest {
    private static final String PAYMENT_ERROR_MESSAGE = "[ERROR] 구입 금액이 올바르지 않습니다.";

    @DisplayName("구입 금액에 숫자가 아닌 문자가 들어가 있는 경우")
    @Test
    void 구입금액_문자_예외테스트() {
        assertSimpleTest(() -> {
            runException("abc1000");
            assertThat(output()).contains(PAYMENT_ERROR_MESSAGE);
        });
    }

    @DisplayName("구입 금액이 음수거나 0인 경우")
    @Test
    void 구입금액_범위_예외테스트() {
        assertSimpleTest(() -> {
            runException("-3000");
            assertThat(output()).contains(PAYMENT_ERROR_MESSAGE);
        });

        assertSimpleTest(() -> {
            runException("0");
            assertThat(output()).contains(PAYMENT_ERROR_MESSAGE);
        });
    }

    @DisplayName("구입 금액이 1000원 단위가 아닌 경우")
    @Test
    void 구입금액_단위_예외테스트() {
        assertSimpleTest(() -> {
            runException("2500");
            assertThat(output()).contains(PAYMENT_ERROR_MESSAGE);
        });

        assertSimpleTest(() -> {
            runException("10300");
            assertThat(output()).contains(PAYMENT_ERROR_MESSAGE);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}