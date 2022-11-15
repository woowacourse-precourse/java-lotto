package lotto.Validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyValidatorTest {

    private MoneyValidator moneyValidator;

    @BeforeEach
    void setUp() {
        moneyValidator = new MoneyValidator();
    }

    @DisplayName("구입 금액이 숫자가 아니라면 예외가 발생한다.")
    @Test
    void createNotNaturalNumber1() {
        assertThatThrownBy(() -> {
            moneyValidator.isNumber("asd");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 자연수가 아니라면 예외가 발생한다.")
    @Test
    void createNotNaturalNumber2() {
        assertThatThrownBy(() -> {
            moneyValidator.isNumber("1.2");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 1000보다 작다면 예외가 발생한다.")
    @Test
    void createNumberLessThan1000() {
        assertThatThrownBy(() -> {
            moneyValidator.isOverThan1000("999");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 1000으로 나누어 떨어지지 않으면 예외가 발생한다.")
    @Test
    void createNotMultiplesOf1000() {
        assertThatThrownBy(() -> {
            moneyValidator.isMultiplesOf1000("-1234");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
