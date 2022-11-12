package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.Test;

public class ExceptionTest {

    @Test
    void isValidAmout_입력받은_구매금액이_예외인지_판별() {
        Exception exception = new Exception();
        String input1 = "$2,000";
        String input2 = "20210";
        String input3 = "2000";

        assertThatThrownBy(() -> exception.isValidAmount(input1))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> exception.isValidAmount(input2))
                .isInstanceOf(IllegalArgumentException.class);
        assertThat(exception.isValidAmount(input3)).isEqualTo(2000);
    }
}
