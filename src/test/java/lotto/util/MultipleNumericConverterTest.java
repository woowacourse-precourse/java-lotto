package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MultipleNumericConverterTest {

    private final Converter<String, List<Integer>> converter = new MultipleNumericConverter();

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

    @DisplayName("영문자는 숫자로 변환할 수 없으므로 예외가 발생한다.")
    @Test
    void convertFailByEnglish() {
        //given
        String target = "1,2,a";

        //then
        assertThatThrownBy(() -> converter.convert(target)).isInstanceOf(
                IllegalArgumentException.class);
    }

    @DisplayName("한글은 숫자로 변환할 수 없으므로 예외가 발생한다.")
    @Test
    void convertFailByKorean() {
        //given
        String target = "1,2,가";

        //then
        assertThatThrownBy(() -> converter.convert(target)).isInstanceOf(
                IllegalArgumentException.class);
    }

    @DisplayName("특수 기호는 숫자로 변환할 수 없으므로 예외가 발생한다.")
    @Test
    void convertFailBySymbol() {
        //given
        String target = "1,2,@";

        //then
        assertThatThrownBy(() -> converter.convert(target)).isInstanceOf(
                IllegalArgumentException.class);
    }

    @DisplayName("공백은 숫자로 변환할 수 없으므로 예외가 발생한다.")
    @Test
    void convertFailByBlank() {
        //given
        String target = "1,2, ";

        //then
        assertThatThrownBy(() -> converter.convert(target)).isInstanceOf(
                IllegalArgumentException.class);
    }

}