package lotto;

import lotto.message.ErrorMessage;
import lotto.validator.InputValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputValidatorTest {
    @DisplayName("입력 금액이 로또 가격에 나누어 떨어지지 않으면 예외가 발생한다.")
    @Test
    void checkValidatePayment() {
        int payment = 1500;
        int eachPrice = 1000;

        assertThatThrownBy(() -> InputValidator.validatePayment(payment, eachPrice))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_PURCHASE_PRICE.getMessage());
    }

    @DisplayName("입력 금액이 0원이면 예외가 발생한다.")
    @Test
    void checkValidateZero() {
        int payment = 0;

        assertThatThrownBy(() -> InputValidator.validateZero(payment))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NOT_POSITIVE_INTEGER.getMessage());
    }

    @DisplayName("숫자가 아닌 문자를 입력하면 예외가 발생한다.")
    @Test
    void checkChangeInputToInt() {
        String input = "abc";

        assertThatThrownBy(() -> InputValidator.changeInputToInt(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NOT_DIGIT.getMessage());
    }

    @DisplayName("로또 번호의 개수가 6개가 아니면 예외가 발생한다.")
    @Test
    void checkValidateLottoSize() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7);
        assertThatThrownBy(() -> InputValidator.validateLottoSize(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_LOTTO_SIZE.getMessage());
    }

    @DisplayName("로또 번호의 범위가 1~45 사이가 아니면 예외가 발생한다.")
    @Test
    void checkValidateNumberRange() {
        int number = 50;

        assertThatThrownBy(() -> InputValidator.validateNumberRange(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_NUMBER_RANGE.getMessage());
    }

    @DisplayName("로또 번호가 겹치면 예외가 발생한다.")
    @Test
    void checkValidateOverlappingNumbers() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 5);

        assertThatThrownBy(() -> InputValidator.validateOverlappingNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.OVERLAPPED_NUMBER.getMessage());
    }

    @DisplayName("보너스 번호가 겹치면 예외가 발생한다.")
    @Test
    void checkValidateOverlappingBonusNumber() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 5);
        int bonusNumber = 1;

        assertThatThrownBy(() -> InputValidator.validateOverlappingBonusNumbers(numbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.OVERLAPPED_NUMBER.getMessage());
    }

    @DisplayName("당첨 로또 번호를 입력받을 때, 포맷에 맞지 않으면 예외가 발생한다.")
    @Test
    void checkChangeInputToIntegerList() {
        String input = "1/2/3/4/5/6";

        assertThatThrownBy(() -> InputValidator.changeInputToIntegerList(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NOT_DIGIT.getMessage());
    }
}
