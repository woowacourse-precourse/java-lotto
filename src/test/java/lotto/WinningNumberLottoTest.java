package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
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
    void inputBonusNumberByOverNumber() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> run("1,2,3,4,5,6", "46"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void inputBonusNumberByNegativeNumber() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> run("1,2,3,4,5,6", "-46"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void inputBonusNumberByFloatNumber() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> run("1,2,3,4,5,6", "4.4"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void inputBonusNumberByDuplicatedWinningNumber() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> run("1,2,3,4,5,6", "4"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void inputWinningNumberByUnderSize() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> run("1,2,3,4,5"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void inputWinningNumberBySpaceSplit() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> run("1 2 3 4 5 6"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void inputWinningNumberByOverNumber() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> run("1,2,3,4,5,46"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void inputWinningNumberByNormal() {
        assertSimpleTest(() ->
            run("1,2,3,4,5,6", "11")
        );
    }

    @Test
    void inputWinningNumberByFloatNumber() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> run("1,2.3,3,4,5,6.4"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Override
    public void runMain() {
        new WinningNumberLotto();
    }
}
