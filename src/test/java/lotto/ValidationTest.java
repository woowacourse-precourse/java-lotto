package lotto;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidationTest {
    private final ValidInput validInput = new ValidInput();

    @DisplayName("사용자의 입력한 금액이 1000원 단위로 나누어진다.")
    @Test
    void inputCanDivideBy1000() {
        assertThatCode(() -> validInput.validCashAmount(100000, 1000)).doesNotThrowAnyException();
    }

    @DisplayName("사용자가 입력한 수가 6자리로 이뤄져 있다.")
    @Test
    void inputAmountIsSix() {
        List<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(2);
        input.add(3);
        input.add(4);
        input.add(5);
        input.add(6);

        assertThatCode(() -> validInput.validInputLength(input)).doesNotThrowAnyException();
        input.remove(5);
        assertThatThrownBy(() -> validInput.validInputLength(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자가 입력한 수가 범위 내에 있다.")
    @Test
    void isNumberInRange() {
        assertThatCode(() -> validInput.validIsInputInRange(10)).doesNotThrowAnyException();
        assertThatThrownBy(() -> validInput.validIsInputInRange(50)).isInstanceOf(IllegalArgumentException.class);
    }
}
