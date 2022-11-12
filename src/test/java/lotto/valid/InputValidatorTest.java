package lotto.valid;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class InputValidatorTest {
    private static final String MONEY_ERROR_MESSAGE = "[ERROR] 1000원 단위의 금액을 입력해야 합니다.";


    @DisplayName("로또 구입 금액이 1000으로 나누어 떨어지는 0 이상의 수가 아니면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"1500", "1,000", "-4000"})
    void doesNotInputMoneyUnit1000(String string) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputValidator.validateMoney(string))
                .withMessage(MONEY_ERROR_MESSAGE);
    }
}
