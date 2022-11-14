package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.utility.Exception;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

public class ExceptionTest {
    @DisplayName("구매 금액이 숫자가 아니면 예외가 발생한다.")
    @Test
    void inputIsNotNumber() {
        assertThatThrownBy(() -> Exception.checkInputIsNum("10005a")).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매 금액이 1,000원 단위가 아니면 예외가 발생한다.")
    @Test
    void inputCanNotDivideNumber() {
        assertThatThrownBy(() -> Exception.checkPriceCanDivide(1001)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("범위를 벗어난 숫자를 입력하면 예외가 발생한다.")
    @Test
    void inputOutOfRangeNumber() {
        assertThatThrownBy(() -> Exception.checkWinningNumberRange(46)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Exception.checkWinningNumberRange(0)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력한 수의 갯수가 6개가 아닐 경우 예외가 발생한다.")
    @Test
    void inputNotSixNumbers() {
        assertThatThrownBy(() -> Exception.checkNumberOfNumbers(List.of(1,2,3,4,5,6,7))).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Exception.checkNumberOfNumbers(List.of(1,2,3,4,5))).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력한 수의 중복 될 경우 예외가 발생한다.")
    @Test
    void inputDuplicateNumbers() {
        assertThatThrownBy(() -> Exception.checkDuplicateNumber(List.of(1,2,3,4,6,6))).isInstanceOf(IllegalArgumentException.class);
    }
}