package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputConvertTest {
    @DisplayName(",뒤 숫자가 없는 경우에러가 발생한다")
    @Test
    void lottoNumberInputConvertErrorByNoInput() {
        String input = "1,2,3,4,5,";
        assertThatThrownBy(() -> InputConvert.lottoNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("알파벳이 주어진 경우 에러가 발생한다.")
    @Test
    void lottoNumberInputConvertErrorByAlphabet () {
        String input = "a,2,3,4,5,6";
        assertThatThrownBy(() -> InputConvert.lottoNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName(",제외 특수 문자가 주어진 경우 에러가 발생한다.")
    @Test
    void lottoNumberInputConvertErrorBySpecialCharacter() {
        String input = "1,!,3,4,5,6";
        assertThatThrownBy(() -> InputConvert.lottoNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("공백이 입력된 경우 에러가 발생한다.")
    @Test
    void lottoNumberInputConvertErrorByBlank() {
        String input = "1,2,3,4,5 ,6";
        assertThatThrownBy(() -> InputConvert.lottoNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
