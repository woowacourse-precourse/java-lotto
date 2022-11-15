package lotto.verifier;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class BonusNumberValidatorTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("보너스 번호는 숫자로 입력해야한다")
    @Test
    void 보너스_번호_숫자() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", "12aaa");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("보너스 번호는 1부터 45사이로 입력해야한다")
    @Test
    void 보너스_번호_1부터_45사이() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", "123");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("보너스 번호는 당첨 번호와 중복되지 않아야한다")
    @Test
    void 보너스_당첨번호_중복() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", "1");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}