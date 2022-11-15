package lotto;

import java.util.NoSuchElementException;
import lotto.util.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidatorTest {

    @DisplayName("입력받은 수가 숫자가 아닐 경우 에러가 발생한다.")
    @Test
    void createValidateInputNumberType() {
        assertThatThrownBy(
                () -> {
                    List<Integer> winningNumbers = (List.of(1, 2, 3, 4, 5, 6));
                    String input = "우테코";
                    Validator.validateInputNumber(input);
                }
        )
                .isInstanceOf(NoSuchElementException.class);
    }

    @DisplayName("입력받은 구매 가격이 1000단위가 아닐 경우 에러가 발생한다.")
    @Test
    void createValidateInputMoneyUnit() {
        assertThatThrownBy(
                () -> {
                    String input = "1001";
                    Validator.validateInputMoneyUnit(input);
                }
        )
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력받은 숫자가 양수가 아닐 경우 에러가 발생한다.")
    @Test
    void createValidateInputNumberPositive() {
        assertThatThrownBy(
                () -> {
                    String input = "-1";
                    Validator.validateInputNumberPositive(input);
                }
        )
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력받은 로또 당첨 번호가 1~45 범위 밖이면 에러가 발생한다.")
    @Test
    void createValidateRangeNumbers() {
        assertThatThrownBy(
                () -> {
                    List<Integer> winningNumbers = (List.of(1, 2, 3, 4, 5, 47));
                    Validator.validateRangeNumbers(winningNumbers);
                }
        )
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력받은 로또 당첨 번호가 ','단위로 나누어져 있지 않으면 에러가 발생한다.")
    @Test
    void createValidateComma() {
        assertThatThrownBy(
                () -> {
                    String input = "1 2 3 4 5 6";
                    Validator.validateComma(input);
                }
        )
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("먼저 입력된 당첨 번호와 입력하는 보너스 번호가 중복되면 예외가 발생한다.")
    @Test
    void createValidateByDuplicatedBonusNumber() {
        assertThatThrownBy(
                () -> {
                    List<Integer> winningNumbers = (List.of(1, 2, 3, 4, 5, 6));
                    String inputBonusNumber = String.valueOf(1);
                    Validator.validateDuplicateBonusNumber(winningNumbers, inputBonusNumber);
                }
        )
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력하는 보너스 번호가 1~45 범위 밖이면 에러가 발생한다.")
    @Test
    void createValidateRangeBonusNumber() {
        assertThatThrownBy(
                () -> {
                    String inputBonusNumber = "46";
                    Validator.validateRangeBonusNumber(inputBonusNumber);
                }
        )
                .isInstanceOf(IllegalArgumentException.class);
    }

}
