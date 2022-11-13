package lotto.UI;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    Validator validator = new Validator();

    @ParameterizedTest
    @ValueSource(strings = {"q100", "999", "1001"})
    void 입력_금액검증(String money) {
        assertThrows(IllegalArgumentException.class, () -> {
            validator.isValidatedMoney(money);
        });
    }
}