package lotto.user.validate;

import static lotto.user.validate.ValidateUser.validateDivideByUnit;
import static lotto.user.validate.ValidateUser.validateOnlyNumber;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

class ValidateUserTest {
    @Test
    void user_input_word() {
        try {
            String input = "a";
            validateOnlyNumber(input);
            fail();
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    void user_input_under_unit() {
        try {
            int amount = 450;
            validateDivideByUnit(amount);
            fail();
        } catch (IllegalArgumentException e) {
        }
    }
    @Test
    void user_input_min_unit_test() {
        try {
            int amount = 4450;
            validateDivideByUnit(amount);
            fail();
        } catch (IllegalArgumentException e) {
        }
    }
}