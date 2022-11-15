package lotto;

import lotto.utils.NumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NumberExceptionTest {

    @DisplayName("구입금액이 1,000원으로 나누어 떨어지지 않는 경우 예외가 발생한다.")
    @Test
    void inputMoneyByInvalidAmount() {
        assertThatThrownBy(() -> NumberException.checkUserInputMoney("1001"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입금액이 숫자로 이루어지지 않는 경우 예외가 발생한다.")
    @Test
    void inputMoneyByNotNumber() {
        assertThatThrownBy(() -> NumberException.checkUserInputMoney("8000a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 숫자로 이루어 지지 않은 경우 예외가 발생한다.")
    @Test
    void inputNumberByNotNumber() {
        assertThatThrownBy(() -> NumberException.checkUserInputNumber("1,2,3,a,5,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호의 구분자가 쉼표(,)가 아닌 경우 예외가 발생한다.")
    @Test
    void inputNumberByInvalidSeparator() {
        assertThatThrownBy(() -> NumberException.checkUserInputNumber("1,2,3.4,5,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 중복된 경우 예외가 발생한다.")
    @Test
    void inputNumberByDuplicatedNumber() {
        assertThatThrownBy(() -> NumberException.checkUserInputNumber("1,2,3,4,5,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void inputNumberByOverSize() {
        assertThatThrownBy(() -> NumberException.checkUserInputNumber("1,2,3,4,5,6,7"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호는 1~45 범위를 벗어날 경우 예외가 발생한다.")
    @Test
    void inputNumberByOverNumbers() {
        assertThatThrownBy(() -> NumberException.checkUserInputNumber("1,2,0,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
