package lotto.user;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import lotto.user.validation.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserNumbersTest {
    @DisplayName("로또 번호를 입력 후 리스트로 반환한다.")
    @Test
    void inputLottoNumbers() {
        //given
        String userInput = "1,2,3,4,5,6";
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);

        // when
        List<Integer> userNumbers = User.inputLottoNumbers();

        // then
        assertThat(numbers).isEqualTo(userNumbers);
    }

    @DisplayName("로또 번호가 1~45가 아니면 예외가 발생한다.")
    @Test
    void inputLottoNumbersByWrongRangeNumber() {
        //given
        String userInput = "1,2,3,4,55,6";
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);

        // when, then
        assertThatThrownBy(User::inputLottoNumbers)
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ExceptionMessage.NUMBER_RANGE.toString());
    }

    @DisplayName("로또 번호를 ,로 구별하지 않으면 예외가 발생한다.")
    @Test
    void inputLottoNumbersByWrongFormat() {
        //given
        String userInput = "1,2,3,4|5,6";
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);

        // when, then
        assertThatThrownBy(User::inputLottoNumbers)
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ExceptionMessage.WRONG_FORMAT.toString());
    }

    @DisplayName("로또 번호는 숫자로 입력하지 않으면 예외가 발생한다.")
    @Test
    void inputLottoNumbersByNotNumber() {
        //given
        String userInput = "1,2,3,4,5,six";
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);

        // when, then
        assertThatThrownBy(User::inputLottoNumbers)
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ExceptionMessage.WRONG_FORMAT.toString());
    }

    @DisplayName("중복된 숫자로 로또 번호를 입력하면 예외가 발생한다.")
    @Test
    void inputLottoNumbersByDuplicateNumber() {
        //given
        String userInput = "1,2,3,4,5,5";
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);

        // when, then
        assertThatThrownBy(User::inputLottoNumbers)
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ExceptionMessage.DUPLICATE_NUMBER.toString());
    }

    @DisplayName("로또 번호는 6개의 숫자로 구성되지 않으면 예외가 발생한다.")
    @Test
    void inputLottoNumbersByWrongLength() {
        //given
        String userInput = "1,2,3,4,5";
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);

        // when, then
        assertThatThrownBy(User::inputLottoNumbers)
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ExceptionMessage.NUMBERS_LENGTH.toString());
    }
}
