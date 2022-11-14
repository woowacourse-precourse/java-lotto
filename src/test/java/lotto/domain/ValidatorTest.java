package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ValidatorTest {
    private final Validator validator = new Validator();

    @DisplayName("로또 구매 금액이 숫자가 아니면 예외 발생")
    @Test
    void inputAmountWithNonNumeric() {
        String input = "a";
        assertThatThrownBy(() -> validator.validateAmount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구매 금액이 1,000원 단위가 아니면 예외 발생")
    @Test
    void inputAmountWithNonThousandUnit() {
        String input = "1200";
        assertThatThrownBy(() -> validator.validateAmount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 1에서 45 사이의 숫자가 아니면 예외 발생")
    @Test
    void inputNumbersOutOfRange() {
        String input = "1,2,3,4,5,66";
        assertThatThrownBy(() -> validator.validateNumbers(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외 발생")
    @Test
    void inputNumbersOverSize() {
        String input = "1,2,3,4,5,6,7";
        assertThatThrownBy(() -> validator.validateNumbers(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호 입력 시 구분자가 쉼표가 아니면 예외 발생")
    @Test
    void inputNumbersWithWrongDelims() {
        String input = "1.2,3,4,5,6";
        assertThatThrownBy(() -> validator.validateNumbers(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외 발생")
    @Test
    void inputNumbersWithDuplicatedNumber() {
        String input = "1,1,2,3,4,5";
        assertThatThrownBy(() -> validator.validateNumbers(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 1에서 45 사이의 숫자가 아니면 예외 발생")
    @Test
    void inputBonusOutOfRange() {
        String input = "46";
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> validator.validateBonus(input, winningLotto))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 1개의 숫자가 아니면 예외 발생")
    @Test
    void inputBonusOverSize() {
        String input = "7,8";
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> validator.validateBonus(input, winningLotto))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 보너스 번호와 중복된 숫자가 있으면 예외 발생")
    @Test
    void inputBonusWithDuplicatedNumber() {
        String input = "1";
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> validator.validateBonus(input, winningLotto))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
