package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class PriceTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 예외_테스트() {
        assertSimpleTest(() -> {
            runException("1000j");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 예외_천단위_가격_테스트() {
        assertSimpleTest(() -> {
            runException("1200");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 예외_최소_가격_테스트() {
        assertSimpleTest(() -> {
            runException("-3000");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
