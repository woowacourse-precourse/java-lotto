package lotto.Model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class ValidatorTest {

    @Test
    void isValidAmout_입력받은_구매금액이_예외인지_판별() {

        String input1 = "$2,000";
        String input2 = "20210";
        String input3 = "2000";
        Buyer buyer3 = new Buyer(input3);

        assertThatThrownBy(() -> new Buyer(input1))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Buyer(input2))
                .isInstanceOf(IllegalArgumentException.class);
        assertThat(buyer3.getPurchaseAmount()).isEqualTo(2000);
    }
}
