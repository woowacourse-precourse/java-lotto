package lotto.Model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class ValidatorTest {

    @Test
    void isValidAmount_입력받은_구매금액이_예외인지_판별() {
        Buyer buyer1 = new Buyer();
        String input1 = "$2,000";
        assertThatThrownBy(() -> buyer1.setPurchaseAmount(input1))
                .isInstanceOf(IllegalArgumentException.class);

        Buyer buyer2 = new Buyer();
        String input2 = "20210";
        assertThatThrownBy(() -> buyer2.setPurchaseAmount(input2))
                .isInstanceOf(IllegalArgumentException.class);

        Buyer buyer3 = new Buyer();
        String input3 = "-2000";
        assertThatThrownBy(() -> buyer3.setPurchaseAmount(input3))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
