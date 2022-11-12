package lotto;

import static org.assertj.core.api.Assertions.assertThatCode;

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

    }
}
