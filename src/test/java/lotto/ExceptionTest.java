package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ExceptionTest {
    @DisplayName("1000원 단위가 아닌 숫자를 입력하면 예외가 발생한다.")
    @Test
    void inputIncorrectMoney() {
        Exception ex = new Exception();
        assertThatThrownBy(() -> ex.initialInput("1000001"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자를 입력하지 않으면 예외가 발생한다.")
    @Test
    void inputOnlyNumber() {
        Exception ex = new Exception();
        assertThatThrownBy(() -> ex.initialInput("111111j"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스로 숫자를 입력하지 않으면 예외가 발생한다.")
    @Test
    void inputBonusOnlyNumber() {
        Exception ex = new Exception();
        assertThatThrownBy(() -> ex.inputWinningBonus("10jj"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스로 1~45범위 숫자를 입력하지 않으면 예외가 발생한다.")
    @Test
    void inputBonusOnlyRange() {
        Exception ex = new Exception();
        assertThatThrownBy(() -> ex.inputWinningBonus("46"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
