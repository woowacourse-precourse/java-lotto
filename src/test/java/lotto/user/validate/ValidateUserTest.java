package lotto.user.validate;

import static lotto.user.validate.ValidateUser.validateMinAmount;

import org.junit.jupiter.api.Test;

class ValidateUserTest {

    @Test
    void user_input_Mininmum_test() {
        int amount = 450 ;
        validateMinAmount(amount);
    }

    @Test
    void validateOnlyNumber() {
    }
}