package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class ExceptionTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("금액 입력 예외 테스트")
    @Nested
    class MoneyInputTest {
        @DisplayName("숫자가 아닌 걸 입력한 경우")
        @Test
        void case1() {
            assertSimpleTest(() -> {
                runException("1000j");
                assertThat(output()).contains(ERROR_MESSAGE);
            });
        }

        @DisplayName("로또 금액(1000원)보다 작은 돈을 입력한 경우")
        @Test
        void case2() {
            assertSimpleTest(() -> {
                runException("100");
                assertThat(output()).contains(ERROR_MESSAGE);
            });
        }

        @DisplayName("로또 금액(1000원)보다 큰 돈 입력, 그러나 로또 금액 단위가 아닌 경우")
        @Test
        void case3() {
            assertSimpleTest(() -> {
                runException("2500");
                assertThat(output()).contains(ERROR_MESSAGE);
            });
        }
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
