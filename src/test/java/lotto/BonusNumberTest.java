package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;

import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class BonusNumberTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 보너스번호_영어입력_예외테스트() {
        assertSimpleTest(() -> {
            run("5000", "1,2,3,4,5,6", "aa");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 보너스번호_범위_예외테스트() {
        assertSimpleTest(() -> {
            run("5000", "1,2,3,4,5,6", "100");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 보너스번호_당첨번호와_중복_예외테스트() {
        assertSimpleTest(() -> {
            run("5000", "1,2,3,4,5,6", "6");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
