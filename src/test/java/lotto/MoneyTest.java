package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class MoneyTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 천원단위가_아닐때() {
        assertSimpleTest(() -> {
            runException("10014");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 입력이_0원일때() {
        assertSimpleTest(() -> {
            runException("0");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 입력이_음수일때() {
        assertSimpleTest(() -> {
            runException("-1");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
