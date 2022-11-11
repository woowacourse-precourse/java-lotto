package lotto.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("InputValidator Unit Test")
class InputValidatorTest {

    @Test
    @DisplayName("로또 구입 입력 시 0을 입력하면 IllegalArgumentException을 발생시킵니다.")
    void testValidatePurchaseInput_Zero_IllegalArgumentException() throws Exception {
        //when & then
        assertThrows(IllegalArgumentException.class,
                     () -> InputValidator.validatePurchaseInput("0", 1000));
    }

    @Test
    @DisplayName("로또 구입 입력 시 1000의 배수가 아니면 IllegalArgumentException을 발생시킵니다.")
    void testValidatePurchaseInput_Multiply_1000_IllegalArgumentException() throws Exception {
        //when & then
        assertThrows(IllegalArgumentException.class,
                     () -> InputValidator.validatePurchaseInput("0", 1000));

        assertThrows(IllegalArgumentException.class,
                     () -> InputValidator.validatePurchaseInput("4232", 1000));

        assertThrows(IllegalArgumentException.class,
                     () -> InputValidator.validatePurchaseInput("4001", 1000));
    }
}