package lotto.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class PurchaseAmtValidatorTest {
    Validator purchaseValidator;

    @BeforeEach
    void setUp() {
        purchaseValidator = new PurchaseAmtValidator();
    }

    @ParameterizedTest
    @CsvSource(value = {"1000j","0","990","1200"})
    void 구매금액_유효성_테스트(String input) {
        assertThrows(IllegalArgumentException.class, () -> purchaseValidator.validate(input));
    }

}