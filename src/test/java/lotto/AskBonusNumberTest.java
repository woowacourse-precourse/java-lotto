package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class AskBonusNumberTest extends NsTest {
    /* askBonusNumber Test*/
    @DisplayName("보너스번호가 숫자가 아닌 경우 예외가 발생한다.")
    @Test
    void createBonusNumberNotNumber() {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException("1000", "1,2,3,4,5,6", "a"))
                .isInstanceOf(IllegalArgumentException.class));
    }

    @DisplayName("보너스번호가 범위(1~45)를 벗어난 경우 예외가 발생한다.")
    @Test
    void checkOutOfRangeTest() {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException("1000", "1,2,3,4,5,6", "47"))
                .isInstanceOf(IllegalArgumentException.class));
    }

    @DisplayName("보너스번호가 당첨번호와 중첩되는 경우 예외가 발생한다.")
    @Test
    void createBonusNumberByDuplicatedWinningNumber() {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException("1000", "1,2,3,4,5,6", "6"))
                .isInstanceOf(IllegalArgumentException.class));
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
