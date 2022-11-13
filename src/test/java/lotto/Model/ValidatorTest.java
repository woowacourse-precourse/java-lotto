package lotto.Model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.Utils.Validator.BuyerValidator;
import org.junit.jupiter.api.Test;

public class ValidatorTest {

    @Test
    void Validator_입력받은_구매금액이_예외인지_판별() {
        String input1 = "$2,000";
        assertThatThrownBy(() -> new BuyerValidator(input1))
                .isInstanceOf(IllegalArgumentException.class);

        String input2 = "20210";
        assertThatThrownBy(() -> new BuyerValidator(input2))
                .isInstanceOf(IllegalArgumentException.class);

        String input3 = "-2000";
        assertThatThrownBy(() -> new BuyerValidator(input3))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
