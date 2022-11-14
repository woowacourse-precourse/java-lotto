package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputTest {
    @DisplayName("구입금액에 문자열이 입력되면 예외가 발생한다.")
    @Test
    void stringToIntMoneyByNonNumericInput() {
        assertThatThrownBy(() -> Input.stringToIntMoney("o12"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입금액이 1000원 단위가 아니면 예외가 발생한다.")
    @Test
    void stringToIntMoneyByOtherThanThousandWon() {
        assertThatThrownBy(() -> Input.stringToIntMoney("15400"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
