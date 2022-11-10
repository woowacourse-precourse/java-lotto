package lotto.Validator;

import lotto.validator.WinningNumberValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningNumberValidatorTest {
    WinningNumberValidator winningNumberValidator = new WinningNumberValidator();

    @DisplayName("당첨 번호에 중복된 값이 있다면 예외 처리한다.")
    @Test
    void validateTest1() {
        assertThatThrownBy(() -> winningNumberValidator.validateDuplicateNumber(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호의 길이가 6이 아니라면 예외 처리한다.")
    @Test
    void validateTest2() {
        assertThatThrownBy(() -> winningNumberValidator.validateNumberSize(List.of(1, 2, 3, 4, 5, 5, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 1 이상 45미만 이외의 값을 갖는다면 예외 처리한다.")
    @Test
    void validateTest3() {
        assertThatThrownBy(() -> winningNumberValidator.validateNumberRange(List.of(1, 2, 3, 4, 5, 51)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 당첨 번호에 포함되어 있을 경우 예외 처리한다.")
    @Test
    void validateTest4() {
        assertThatThrownBy(() ->
                winningNumberValidator.validateWinningNumbersContainBonusNumber(List.of(1, 2, 3, 4, 5, 5), 5))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
