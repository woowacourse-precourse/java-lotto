package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ExceptionTest {
    @DisplayName("입력된 구입 금액이 정수가 아니면 예외가 발생한다.")
    @Test
    void createMoneyString() {
        assertThatThrownBy(() -> Exception.isInteger("abc"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 숫자가 아닌 경우 예외가 발생한다.")
    @Test
    void createNotIntegerWinningNumber() {
        assertThatThrownBy(() -> Exception.changeListStringToInteger(List.of("a", "b", "1", "2", "3", "4")))
                .isInstanceOf(IllegalArgumentException.class);
    }
}