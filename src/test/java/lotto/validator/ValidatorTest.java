package lotto.validator;

import lotto.constant.ErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static lotto.constant.ErrorMessage.*;

class ValidatorTest {
    private Validator validator;

    @BeforeEach
    public void setup() {
        validator = new Validator();
    }

    @DisplayName("구매 금액이 0이상의 정수가 아니면 예외가 발생한다.")
    @Test
    public void validateMoneyLessThen0() {
        int money = -1;

        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> validator.validateMoney(money))
                .withMessage(ErrorMessage.ERROR_MONEY);
    }

    @DisplayName("구매 금액이 1000단위 숫자가 아니면 예외가 발생한다.")
    @Test
    public void validateMoneyByNot1000Multiples() {
        int money = 1100;

        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> validator.validateMoney(money))
                .withMessage(ErrorMessage.ERROR_MONEY);
    }

    @DisplayName("당첨 번호에 콤마 구분자가 없으면 예외가 발생한다.")
    @Test
    public void validateWinningNumbersByCommaDelimiter() {
        String numbers = "1234";

        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> validator.validateWinningNumbers(numbers))
                .withMessage(ERROR_COMMA_DELIMITER);
    }

    @DisplayName("당첨 번호에 중복된 값이 있으면 예외가 발생한다.")
    @Test
    public void validateWinningNumberByDuplicatedValues() {
        String numbers = "1,2,3,3,4,5";

        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> validator.validateWinningNumbers(numbers))
                .withMessage(ERROR_DUPLICATE_SIZE);
    }

    @DisplayName("당첨 번호에 LOTTO_COUNT 만큼의 개수가 없으면 예외가 발생한다.")
    @Test
    public void validateWinningNumberByNotEqualsSize() {
        String greatThanSizeNumbers = "1,2,3,4,5,6,7,8";
        String lessThanSizeNumbers = "1,2,3";

        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> validator.validateWinningNumbers(greatThanSizeNumbers))
                .withMessage(ERROR_DUPLICATE_SIZE);
        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> validator.validateWinningNumbers(lessThanSizeNumbers))
                .withMessage(ERROR_DUPLICATE_SIZE);
    }

    @DisplayName("당첨 번호에 1 ~ 45 사이 숫자가 아닌 값이 있으면 예외가 발생한다.")
    @Test
    public void validateWinningNumberByRange() {
        String numbers = "1,2,3,4,46,7";

        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> validator.validateWinningNumbers(numbers))
                .withMessage(ERROR_RANGE);
    }

    @DisplayName("보너스 번호와 당첨 번호가 중복되면 예외가 발생한다.")
    @Test
    public void validateBonusNumberByDuplicatedWinningNumbers() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        String bonusNumber = "3";

        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> validator.validateBonusNumber(winningNumbers, bonusNumber))
                .withMessage(ERROR_DUPLICATE_BONUS);
    }

    @DisplayName("보너스 번호가 1 ~ 45 사이 숫자가 아닌 값이 있으면 예외가 발생한다.")
    @Test
    public void validateBonusNumberByRange() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        String bonusNumber = "46";

        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> validator.validateBonusNumber(winningNumbers, bonusNumber))
                .withMessage(ERROR_RANGE);
    }
}