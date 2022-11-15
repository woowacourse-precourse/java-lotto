package lotto.domain.number;

import lotto.resource.message.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumberTest {

    @Test
    @DisplayName("입력이 숫자가 아닌 경우")
    void inputIsNotInteger() {
        String input = "숫자아님";

        assertThatThrownBy(() -> new Number(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]")
                .hasMessage(ErrorMessage.NOT_INTEGER_OR_NUMBER_OUT_OF_RANGE_MESSAGE.getValue());
    }

    @Test
    @DisplayName("입력이 허용된 숫자 범위를 벗어나는 경우")
    void numberOutOfRange() {
        String input = "1000000000000000";

        assertThatThrownBy(() -> new Number(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]")
                .hasMessage(ErrorMessage.NOT_INTEGER_OR_NUMBER_OUT_OF_RANGE_MESSAGE.getValue());
    }

    @Test
    @DisplayName("입력이 허용되는 범위의 숫자인 경우")
    void validNumber() {
        String input = "1000";

        Number number = new Number(input);

        assertThat(number.getValueAsInt()).isEqualTo(1000);
    }

    @Test
    @DisplayName("value를 정수로 가져오기")
    void getValueAsInt() {
        Number number = new Number(1000);

        assertThat(number.getValueAsInt()).isEqualTo(1000);
    }
}