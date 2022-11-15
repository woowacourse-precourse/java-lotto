package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class ExceptionTest extends NsTest{

    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("1000원에 딱 맞아떨어지는 비용이 지불되지 않으면 예외가 발생한다.")
    @Test
    void notdividedByThousandWon() {
        assertSimpleTest(() -> {
            runException("200");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("0원을 지불하면 예외가 발생한다.")
    @Test
    void payZero() {
        assertSimpleTest(() -> {
            runException("0");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("보너스 넘버는 로또 넘버와 같으면 안된다.")
    @Test
    void checkBonusNum() {
        assertSimpleTest(() -> {
            runException("8000", "1,2,3,4,5,6", "6");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
