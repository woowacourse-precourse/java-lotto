package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringToNumberConverterTest {

    private final Converter<String, Integer> converter = new StringToNumberConverter();

    @DisplayName("문자열을 숫자로 변환한다.")
    @Test
    void convertStringToNumber() {
        //given
        String target = "123";
        Integer number = 123;

        //when
        Integer result = converter.convert(target);

        //then
        assertThat(result).isEqualTo(number);
    }

    @DisplayName("문자열이 숫자로 변환할 수 없으면 IllegalArgumentException이 발생한다.")
    @Test
    void convertFail() {
        //given
        String target = "12a";

        //then
        assertThatThrownBy(() -> converter.convert(target)).isInstanceOf(
            IllegalArgumentException.class);
    }

}