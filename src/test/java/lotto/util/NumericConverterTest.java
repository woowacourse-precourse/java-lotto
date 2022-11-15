package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumericConverterTest {

    private final Converter<String, Integer> converter = new NumericConverter();

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

    @DisplayName("영문자는 숫자로 변환할 수 없으므로 예외가 발생한다.")
    @Test
    void convertFailByEnglish() {
        //given
        String target = "12a";

        //then
        assertThatThrownBy(() -> converter.convert(target)).isInstanceOf(
                IllegalArgumentException.class);
    }

    @DisplayName("한글은 숫자로 변환할 수 없으므로 예외가 발생한다.")
    @Test
    void convertFailByKorean() {
        //given
        String target = "12가";

        //then
        assertThatThrownBy(() -> converter.convert(target)).isInstanceOf(
                IllegalArgumentException.class);
    }

    @DisplayName("특수 기호는 숫자로 변환할 수 없으므로 예외가 발생한다.")
    @Test
    void convertFailBySymbol() {
        //given
        String target = "12@";

        //then
        assertThatThrownBy(() -> converter.convert(target)).isInstanceOf(
                IllegalArgumentException.class);
    }

    @DisplayName("공백은 숫자로 변환할 수 없으므로 예외가 발생한다.")
    @Test
    void convertFailByBlank() {
        //given
        String target = "12 ";

        //then
        assertThatThrownBy(() -> converter.convert(target)).isInstanceOf(
                IllegalArgumentException.class);
    }

}