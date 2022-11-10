package lotto;

import lotto.validation.MoneyValidation;
import lotto.validation.PlayerNumberValidation;
import lotto.validation.Validation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidationTest {

    Validation validation1 = new MoneyValidation();
    Validation validation2 = new PlayerNumberValidation();

    @DisplayName("int인지 아닌지 확인1")
    @Test
    void validationNumber1() {
        boolean actual = validation1.validateInputIsInteger("5000");
        assertThat(actual).isTrue();
    }

    @DisplayName("int인지 아닌지 확인2")
    @Test
    void validationNumber2() {
        boolean actual = validation1.validateInputIsInteger("fhfgkrhtlvek");
        assertThat(actual).isFalse();
    }

    @DisplayName("int인지 아닌지 확인3")
    @Test
    void validationNumber3() {
        boolean actual = validation2.validateInputIsInteger("1, 2, 3, 4, 5, 6");
        assertThat(actual).isTrue();
    }

    @DisplayName("int인지 아닌지 확인4")
    @Test
    void validationNumber4() {
        boolean actual = validation2.validateInputIsInteger("1, jhkop, 3, 4, 5, 6");
        assertThat(actual).isFalse();
    }
}
