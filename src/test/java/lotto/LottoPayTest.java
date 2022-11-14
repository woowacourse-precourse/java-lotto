package lotto;


import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;


class LottoPayTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 최소_구매금() {
        assertSimpleTest(() -> {
            runException("850");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 최대_구매금() {
        assertSimpleTest(() -> {
            runException("2000001000");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 최소_구매금_단위() {
        assertSimpleTest(() -> {
            runException("1100");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

}