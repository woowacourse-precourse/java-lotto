package lotto.validation;

import static org.junit.jupiter.api.Assertions.*;

import lotto.constant.IntConstant;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMoneyValidationTest {
    Validation lottoMoneyValidation = new LottoMoneyValidation();
    @DisplayName("숫자가 아니면 IllegalArgumentException 을 발생시킨다.")
    @Test
    void notNumberException() {
        assertThrows(IllegalArgumentException.class, () -> lottoMoneyValidation.isValidate("j"));
    }

    @DisplayName("정수형이 아니면 IllegalArgumentException 을 발생시킨다.")
    @Test
    void notIntegerInputException() {
        assertThrows(IllegalArgumentException.class, () -> lottoMoneyValidation.isValidate("12.3"));
    }

    @DisplayName("음수 값이면 IllegalArgumentException 을 발생시킨다.")
    @Test
    void minusValueException() {
        assertThrows(IllegalArgumentException.class, () -> lottoMoneyValidation.isValidate("-200"));
    }

    @DisplayName("로또 1개 가격으로 나누어 떨어지지 않으면 IllegalArgumentException 을 발생시킨다.")
    @Test
    void notDivideByLottoMoneyPerCountInputException() {
        int money = IntConstant.LOTTO_MONEY_PER_ONE.getValue();
        int userMoney = money / 10;
        assertThrows(IllegalArgumentException.class, () -> lottoMoneyValidation.isValidate(String.valueOf(userMoney)));
    }

    @DisplayName("모두 통과하면 어떠한 상황도 발생하지 않는다.")
    @Test
    void correctMoneyInput() {
        int money = IntConstant.LOTTO_MONEY_PER_ONE.getValue();
        int userMoney = money * 10;
        assertDoesNotThrow(() -> lottoMoneyValidation.isValidate(String.valueOf(userMoney)));
    }

}