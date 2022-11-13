package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningNumberLottoTest extends NsTest {

    @Test
    void inputBonusNumberByString() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> run("1,2,3,4,5,6", "a"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void inputBonusNumberByUnderSize() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> run("1,2,3,4,5", "1"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void inputBonusNumberBySpaceSplit() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> run("1 2 3 4 5 6", "1"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void inputBonusNumberByNormal() {
        assertSimpleTest(() -> {
            run("1,2,3,4,5,6", "1");
        });
    }

    @Override
    public void runMain() {
        new WinningNumberLotto();
    }
}
