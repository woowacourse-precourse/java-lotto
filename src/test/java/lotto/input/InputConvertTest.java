package lotto.input;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
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
        String input = "1,3!,3,4,5,6";
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
    @DisplayName("음수가 입력된 경우 에러가 발생한다.")
    @Test
    void lottoNumberInputConvertErrorByMinus() {
        String input = "1,2,3,-4,5,6";
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
    @DisplayName("에러가 발생한 경우 에러메세지를 출력한다.")
    @Test
    void lottoNumberInputConvertErrorForPrint() {
        String input = "1,2,3,4,5,";
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        assertThatThrownBy(() -> InputConvert.lottoNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
        assertThat(out.toString()).isEqualTo("[ERROR] 입력 형식에 맞게 입력되어야 합니다.");
    }
    @DisplayName("아무런 입력이 없어 에러가 발생한 경우 에러메세지를 출력한다.")
    @Test
    void lottoNumberInputConvertErrorByNothingForPrint() {
        String input = "";
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        assertThatThrownBy(() -> InputConvert.lottoNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
        assertThat(out.toString()).isEqualTo("[ERROR] 아무것도 입력되지 않았습니다.");
    }
    @DisplayName("oneNumber에 아무런 입력이 없어 에러가 발생한 경우 에러메세지를 출력한다.")
    @Test
    void oneNumberInputConvertErrorByNothingForPrint() {
        String input = "";
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        assertThatThrownBy(() -> InputConvert.oneNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
        assertThat(out.toString()).isEqualTo("[ERROR] 아무것도 입력되지 않았습니다.");
    }
    @DisplayName("oneNumber에 에러가 발생한 경우 에러메세지를 출력한다.")
    @Test
    void oneNumberInputConvertErrorForPrint() {
        String input = "5a";
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        assertThatThrownBy(() -> InputConvert.oneNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
        assertThat(out.toString()).isEqualTo("[ERROR] 입력 형식에 맞게 입력되어야 합니다.");
    }
    @DisplayName("\"5000\"이 입력되면 5000이 리턴되고 \"1\"이 입력되면 1이 리턴된다.")
    @Test
    void oneNumberConvert() {
        String input = "5000";
        assertThat(InputConvert.oneNumber(input)).isEqualTo(5000);
        input = "1";
        assertThat(InputConvert.oneNumber(input)).isEqualTo(1);
    }
}
