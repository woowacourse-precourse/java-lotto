package lotto;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import lotto.service.ValidInput;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidationTest {
    private final ValidInput validInput = new ValidInput();

    @DisplayName("사용자의 입력한 금액이 1000원 단위로 나누어진다.")
    @Test
    void inputCanDivideBy1000() {
        assertThatCode(() -> validInput.validCashAmount(100000, 1000)).doesNotThrowAnyException();
        assertThatThrownBy(() -> validInput.validCashAmount(100500, 1000))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자가 입력한 수가 6자리로 이뤄져 있다.")
    @Test
    void inputAmountIsSix() {
        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertThatCode(() -> validInput.validInputLength(input)).doesNotThrowAnyException();
        List<Integer> input2 = Arrays.asList(1, 2, 3, 4, 5);
        assertThatThrownBy(() -> validInput.validInputLength(input2)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자가 입력한 수가 범위 내에 있다.")
    @Test
    void isNumberInRange() {
        assertThatCode(() -> validInput.validIsInputInRange(10)).doesNotThrowAnyException();
        assertThatThrownBy(() -> validInput.validIsInputInRange(50))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자의 입력에 중복이 존재하지 않는다.")
    @Test
    void isInputHasDuplicatedNumber() {
        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertThatCode(() -> validInput.validInputHasDuplicatedNumber(input)).doesNotThrowAnyException();

        List<Integer> input2 = Arrays.asList(1, 2, 3, 4, 5, 6, 1);
        assertThatThrownBy(() -> validInput.validInputHasDuplicatedNumber(input2))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
