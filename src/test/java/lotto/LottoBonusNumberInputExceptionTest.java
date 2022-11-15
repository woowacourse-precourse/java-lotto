package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.exception.LottoBonusNumberInputException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoBonusNumberInputExceptionTest {

    private LottoBonusNumberInputException lottoBonusNumberInputException = new LottoBonusNumberInputException();

    @Test
    @DisplayName("보너스 번호는 숫자로만 이루어져야 합니다")
    void isBonusNumberConsistOfNumber() {
        assertThatThrownBy(
                () -> lottoBonusNumberInputException.isInputValid("B")).isInstanceOf(
                IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스 번호는 1부터 45 사이의 숫자로 이루어져야 합니다")
    void isBonusNumberInRage() {
        assertThatThrownBy(
                () -> lottoBonusNumberInputException.isInputValid("46")).isInstanceOf(
                IllegalArgumentException.class);
    }
}
