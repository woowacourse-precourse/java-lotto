package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningNumberTest {

    @DisplayName("당첨 번호가 숫자가 아니면 예외가 발생한다.")
    @Test
    public void winningNumberInputNotNum() {
        //given
        User user = new User();
        String input = "1,2,3,4,5,i";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        //when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                user::winningNumbersInput);

        //then
        assertThat(exception.getMessage()).isEqualTo("[ERROR] 숫자만 입력 가능합니다.");
    }

    @DisplayName("당첨 번호가 6개가 아니면 예외가 발생한다.")
    @Test
    public void winningNumberInputLength() {
        //given
        User user = new User();
        String input = "1,2,3,4,5";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        //when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                user::winningNumbersInput);

        //then
        assertThat(exception.getMessage()).isEqualTo("6개의 숫자를 입력해주세요.");
    }

    @DisplayName("당첨 번호가 1~45 이외의 숫자면 예외가 발생한다.")
    @Test
    public void winningNumbersInputOutOfRange() {
        //given
        User user = new User();
        String input = "1,2,3,4,5,46";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        //when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                user::winningNumbersInput);

        //then
        assertThat(exception.getMessage()).isEqualTo("1~45 사이의 숫자만 입력 가능합니다.");
    }

    @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    public void winningNumbersInputDuplicate() {
        //given
        User user = new User();
        String input = "1,2,3,4,5,5";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        //when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                user::winningNumbersInput);

        //then
        assertThat(exception.getMessage()).isEqualTo("중복된 수는 입력할수 없습니다.");
    }

    @DisplayName("알맞은 당첨 번호를 입력하면 String 타입 그대로 반환한다.")
    @Test
    public void winningNumberInputSUC() {
        //given
        User user = new User();
        String input = "1,2,3,4,5,6";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        //when
        String winningNumbersInput = user.winningNumbersInput();

        //then
        assertThat(winningNumbersInput).isEqualTo("1,2,3,4,5,6");
    }
}
