package lotto;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BonusNumberTest {

    List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);

    @DisplayName("보너스 넘버에 숫자 이외의 값을 입력시 예외가 발생한다.")
    @Test
    public void bonusNumberInputNotNum() {

        //given
        User user = new User();
        String input = "i";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        //when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> user.bonusNumberInput(winningNumbers));

        //then
        Assertions.assertThat(exception.getMessage()).isEqualTo("[ERROR] 숫자만 입력 가능합니다.");
    }

    @DisplayName("보너스 넘버에 1~45 외의 숫자 입력시 예외가 발생한다.")
    @Test
    public void bonusNumberInputOverRange() {

        //given
        User user = new User();
        String input = "46";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        //when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> user.bonusNumberInput(winningNumbers));

        //then
        Assertions.assertThat(exception.getMessage()).isEqualTo(Error.RANGE_ERROR.getErrorMessage());
    }

    @DisplayName("보너스 넘버가 당첨번호에 입력한 숫자와 같을경우 예외가 발생한다.")
    @Test
    public void bonusNumberInputDuplicateWinningNumbers() {

        //given
        User user = new User();
        String input = "6";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        //when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> {
                    user.bonusNumberInput(winningNumbers);
                });

        //then
        System.out.println("exception.getMessage() = " + exception.getMessage());
        Assertions.assertThat(exception.getMessage()).isEqualTo(Error.DUPLICATED.getErrorMessage());
    }

    @DisplayName("보너스 넘버에 알맞은 숫자를 입력시 String 을 int 로 변환하여 리턴한다.")
    @Test
    public void bonusNumberInputSuc() {
        //given
        User user = new User();
        String input = "43";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        //when
        int bonusNumberInput = user.bonusNumberInput(winningNumbers);

        //then
        Assertions.assertThat(bonusNumberInput).isEqualTo(43);
    }

}
