package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.domain.Validator.winningNumberDuplicate;
import static lotto.domain.Validator.winningNumberFormat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidatorTest {
    @DisplayName("당첨 번호를 형식에 맞게 입력하지 않으면 예외가 발생한다")
    @Test
    void winningNumberFormatValidation() {
        assertThatThrownBy(() -> winningNumberFormat("1,2?3,4,123,4"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 중복이 존재하면 예외가 발생한다")
    @Test
    void winningNumberDuplicateValidation() {
        assertThatThrownBy(() -> winningNumberDuplicate(new Integer[] {1,2,3,4,5,5}))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
