package lotto;

import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class ConsoleInputTest extends CustomNsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 구매금액_예외처리_테스트(){
        assertSimpleTest(() -> {
            runException("1000j");
            assertThat(output()).contains(ERROR_MESSAGE);
        });

        assertSimpleTest(() -> {
            runException("101000");
            assertThat(output()).contains(ERROR_MESSAGE);
        });

        assertSimpleTest(() -> {
            runException("0");
            assertThat(output()).contains(ERROR_MESSAGE);
        });

    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
