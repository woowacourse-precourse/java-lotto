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
            validator.validateMoney(money);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"q,1,2,3,4,5", "-45,1,2,3,4,5", "1,2,3,4,5"})
    void 당첨일반숫자_검증(String normalNumbers) {
        assertThrows(IllegalArgumentException.class, () -> {
            validator.validateNormalNumbers(normalNumbers);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"100"})
    void 당첨보너스숫자_검증(String bonusNumbers) {
        assertThrows(IllegalArgumentException.class, () -> {
            validator.validateBonusNumber(bonusNumbers);
        });
    }
}