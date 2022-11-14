package lotto.valid;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputValidatorTest {
    @DisplayName("입력된 로또 구입 금액이 1000으로 나누어 떨어지는 0 이상의 정수가 아니면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"1,000", "-4000", "", "14500"})
    void doesNotInputMoneyUnit1000(String moneyInput) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputValidator.getValidMoney(moneyInput));
    }

    @DisplayName("입력된 당첨 번호가 1부터 45사이의 중복되지 않은 숫자 6개가 아니면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5.6", "1,,3,4,5,6", "1,1,2,3,4,5", "0,1,2,3,4,5", "1,2,3,4,5,47",""})
    void jackpotNumberInputByIncorrectFormat(String jackpotNumber) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputValidator.getValidJackpotNumbers(jackpotNumber));
    }

    @DisplayName("입력된 보너스 번호가 정수 외의 문자를 포함하는 경우 예외가 발생한다")
    @Test
    void nonDigitInBonusNumber() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputValidator.validateBonusNumber("4,5"));
    }

    @DisplayName("입력된 보너스 번호가 1부터 45사이의 숫자가 아닌 경우 예외가 발생한다")
    @Test
    void bonusNumberOfIncorrectRange() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputValidator.validateBonusNumber("46"));
    }
}
