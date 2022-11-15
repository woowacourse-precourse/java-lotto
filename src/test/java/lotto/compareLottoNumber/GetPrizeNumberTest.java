package lotto.compareLottoNumber;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GetPrizeNumberTest extends NsTest {
    @DisplayName("숫자 이외의 값 받을시 예외 처리")
    @Test
    void getPrizeNumberTest() {
        assertThatThrownBy(() -> runException("c"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자가 6개 아닐 경우 예외 처리")
    @Test
    void numberOfNumbers() {
        assertThatThrownBy(() -> runException("1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> runException("1,2,3,4,5,6,7"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("올바른 값이 들어 오지 않았을 경우 예외를 발생")
    @Test
    void 숫자_이외의_값_예외발생_테스트() {
        assertThatThrownBy(() -> runException("1,2,3,4,5,j"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복된 값을 받았을때 예외 처리")
    @Test
    void duplicateNumberTest () {
        assertThatThrownBy(() -> runException("1,2,3,4,5,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    protected void runMain() {
        int [] prizeNumber = new int[6];
        GetResultNumber getResultNumber = new GetResultNumber();
        getResultNumber.getPrizeNumberFromUser(prizeNumber);
    }
}
