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
    @DisplayName("로또 구입 금액이 1000으로 나누어 떨어지지 않으면 예외가 발생한다")
    @Test
    void nonDigitInMoney() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputValidator.validateMoney("4500"));
    }

    @DisplayName("입력된 로또 구입 금액이 정수 외의 문자를 포함하는 경우 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"1,000", "-4000"})
    void doesNotInputMoneyUnit1000(String moneyInput) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputValidator.validateMoney(moneyInput));
    }

    @DisplayName("입력된 당첨 번호가 잘못된 형식인 경우 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5.6", "1,,3,4,5,6"})
    void jackpotNumberInputByIncorrectFormat(String jackpotNumber) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputValidator.validateJackpotNumberFormat(jackpotNumber));
    }
}
