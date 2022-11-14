package lotto.utils;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputConverterTest {

    @DisplayName("[정상] 구매금액이 숫자일 경우 변환된다.")
    @Test
    void createInput_Can_Be_Converted() {
        Integer result = InputConverter.toInteger("123456");
        assertThat(result).isEqualTo(123456)
                .isInstanceOf(Integer.class);
    }

    @DisplayName("[예외] 구매금액이 숫자가 아닐경우 예외가 발생한다.")
    @Test
    void createInput_Can_Not_Be_Converted() {
        assertThatThrownBy(() -> InputConverter.toInteger("a1234"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 올바르지 않은 입력입니다.");
    }
}
