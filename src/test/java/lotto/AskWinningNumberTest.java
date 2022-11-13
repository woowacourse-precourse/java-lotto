package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class AskWinningNumberTest extends NsTest {
    /* askWinningNumber Test */
    @DisplayName("입력받은 당첨번호가 숫자로만 이루어지지 않았으면 예외가 발생한다.")
    @Test
    void checkArrayOnlyNumberTest() {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException("1000", "1,2,3,4,5,a", "7"))
                .isInstanceOf(IllegalArgumentException.class));
    }

    @DisplayName("입력받은 당첨번호가 범위(1 ~ 45)를 넘어가면 예외가 발생한다.")
    @Test
    void createWinningLottoByOutOfRange() {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException("1000", "1,2,3,4,5,46", "7"))
                .isInstanceOf(IllegalArgumentException.class));
    }

    @DisplayName("입력받은 당첨번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createWinningLottoByOverSize() {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException("1000", "1,2,3,4,5,6,7", "7"))
                .isInstanceOf(IllegalArgumentException.class));
    }

    @DisplayName("입력받은 당첨번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createWinningLottoByDuplicatedNumber() {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException("1000", "1,2,3,4,5,1", "7"))
                .isInstanceOf(IllegalArgumentException.class));
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
