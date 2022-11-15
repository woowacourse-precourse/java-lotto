package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PrizeTest {
    @DisplayName("맞춘 번호가 6을 초과할시 예외가 발생한다.")
    @Test
    void correctNumberOverSixInvokeException() {
        assertThatThrownBy(() -> Prize.makingResult(7,false).getCorrectCount())
                .isInstanceOf(IllegalArgumentException.class);
    }


}
