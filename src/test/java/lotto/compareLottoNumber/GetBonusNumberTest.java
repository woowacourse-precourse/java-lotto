package lotto.compareLottoNumber;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GetBonusNumberTest extends NsTest {
    @DisplayName("숫자 이외의 값 받을시 예외 처리")
    @Test
    void getBonusNumberTest() {
        assertThatThrownBy(() -> runException("c"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("여러 개의 숫자를 받을시 예외 처리")
    @Test
    void getNotNumberTest() {
        assertThatThrownBy(() -> runException("1,2"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    protected void runMain() {
        int [] prizeNumber = new int[6];
        GetResultNumber getResultNumber = new GetResultNumber();
        getResultNumber.getBonusNumberFromUser(prizeNumber);
    }
}
