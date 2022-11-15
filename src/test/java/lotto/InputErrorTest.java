package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.model.InputErrorMessage;
import org.junit.jupiter.api.Test;

public class InputErrorTest extends NsTest {
    @Test
    void 구입금액_단위_테스트() {
        assertSimpleTest(() -> {
            runException("462");
            assertThat(output()).contains(InputErrorMessage.MONEY_IS_NOT_DIVIDED.getErrorMessage());
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
