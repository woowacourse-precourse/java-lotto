package lotto.validator;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoValidatorTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("입력된 로또 번호가 1~45 사이의 숫자인지 검증할 수 있다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 46, -1})
    void validateNumber_입력된_숫자가_1에서_45_사이의_숫자인지_검증(final int number) {
        Assertions.assertThatThrownBy(
                () -> LottoValidator.validateNumber(number)
            ).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("입력된 당첨 번호가 유효한지 검증할 수 있다.")
    @Test
    void validateNumbers_당첨번호가_유효한지_검증() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 2);
        Assertions.assertThatThrownBy(
                () -> LottoValidator.validateWinningNumber(numbers)
            ).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("보너스번호와 당첨번호에 중복된 숫자가 존재하는지 검증할 수 있다.")
    @Test
    void validateBonusNumber_보너스번호와_당첨번호에_중복을_검증() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonus = 2;
        Assertions.assertThatThrownBy(
                () -> LottoValidator.validateBonusDuplicated(bonus, winningNumbers)
            ).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ERROR_MESSAGE);
    }
}
