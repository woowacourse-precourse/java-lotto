package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
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
    void lottoNumberInputConvertErrorByAlphabet() {
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
    @DisplayName("\"1,2,3,4,5,6\"이 List인 [1, 2, 3, ,4, 5, 6]로 변환된다.")
    @Test
    void lottoNumberConvert() {
        String input = "1,2,3,4,5,6";
        assertThat(InputConvert.lottoNumber(input)).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }
    @DisplayName("\"1,2,3,4,20,45\"이 List인 [1, 2, 3, ,4, 20, 45]로 변환된다.")
    @Test
    void lottoNumberConvert2() {
        String input = "1,2,3,4,20,45";
        assertThat(InputConvert.lottoNumber(input)).isEqualTo(List.of(1, 2, 3, 4, 20, 45));
    }
}
