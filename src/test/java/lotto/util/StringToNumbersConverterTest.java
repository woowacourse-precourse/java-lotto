package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringToNumbersConverterTest {

    private final Converter<String, List<Integer>> converter = new StringToNumbersConverter();

    @DisplayName("문자열을 숫자 목록으로 변환한다.")
    @Test
    void convertStringToNumbers() {
        //given
        String target = "1,2,3";

        //when
        List<Integer> result = converter.convert(target);

        //then
        assertThat(result.size()).isEqualTo(3);
        assertThat(result).containsExactly(1, 2, 3);
    }

    @DisplayName("문자열이 숫자 목록으로 변환할 수 없으면 IllegalArgumentException이 발생한다.")
    @Test
    void convertFail() {
        //given
        String target = "1,2,3p";

        //then
        assertThatThrownBy(() -> converter.convert(target)).isInstanceOf(
            IllegalArgumentException.class);
    }

}