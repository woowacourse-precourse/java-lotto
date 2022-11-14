package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidationTest {
    @DisplayName("로또 구입 금액이 1000원 단위가 아닐 경우 예외가 발생한다.")
    @Test
    void purchaseAmountIsMultipleOf1000() {
        assertThatThrownBy(() -> Validation.isMultipleOf1000("1234"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구입 금액에 문자가 포함됐을 경우 예외가 발생한다.")
    @Test
    void purchaseAmountIncludeCharacter() {
        assertThatThrownBy(() -> Validation.isIncludeNotNumber("1000a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 1미만이거나 45 초과할 경우 예외가 발생한다.")
    @Test
    void numbersAreNotBetween1And45() {
        assertThatThrownBy(() -> Validation.isLottoBetween1And45(List.of(0, 2, 3, 4, 5, 45)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 중복되지 않은 6개의 숫자가 아닌 경우 예외가 발생한다.")
    @Test
    void isLottoDuplicate() {
        assertThatThrownBy(() -> Validation.isLottoDuplicate(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스가 로또 번호에 있을 경우 예외가 발생한다.")
    @Test
    void bonusInLotto() {
        assertThatThrownBy(() -> Validation.isBonusInLotto(List.of(1, 2, 3, 4, 5, 45), 1))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
