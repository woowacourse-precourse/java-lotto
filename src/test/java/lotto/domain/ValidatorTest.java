package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static lotto.domain.Validator.payment;
import static lotto.domain.Validator.bonusNumber;
import static lotto.domain.Validator.winningNumberDuplicate;
import static lotto.domain.Validator.winningNumberFormat;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import lotto.domain.Lotto;

public class ValidatorTest {

    @DisplayName("구매 금액을 형식에 맞게 입력하지 않으면 예외가 발생한다")
    @Test
    void paymentValidation() {
        assertThatThrownBy(() -> payment("123456"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호를 형식에 맞게 입력하지 않으면 예외가 발생한다")
    @Test
    void winningNumberFormatValidation() {
        assertThatThrownBy(() -> winningNumberFormat("1,2?3,4,123,4"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 중복이 존재하면 예외가 발생한다")
    @Test
    void winningNumberDuplicateValidation() {
        assertThatThrownBy(() -> winningNumberDuplicate(new Integer[]{1, 2, 3, 4, 5, 5}))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호를 형식에 맞게 입력하지 않으면 예외가 발생한다")
    @Test
    void bonusNumberValidation() {
        assertThatThrownBy(() -> bonusNumber("100"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 당첨번호 내에 존재하면 예외가 발생한다")
    @Test
    void bonusNumberValidation_2() {
        Lotto.setWinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> bonusNumber("6"))
                .isInstanceOf(IllegalArgumentException.class);
    }


}
