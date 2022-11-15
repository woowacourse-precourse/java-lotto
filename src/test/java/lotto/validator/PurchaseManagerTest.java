package lotto.validator;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class PurchaseManagerTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("구입금액은 숫자이어야한다")
    @Test
    void 구입금액_숫자() {
        assertSimpleTest(() -> {
            runException("123asd");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("구입금액은 천원단위이어야한다")
    @Test
    void 구입금액_천원단위() {
        assertSimpleTest(() -> {
            runException("99900");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("구입금액은 1000원 이상이어야한다")
    @Test
    void 구입금액_1000원이상() {
        assertSimpleTest(() -> {
            runException("-1000");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}