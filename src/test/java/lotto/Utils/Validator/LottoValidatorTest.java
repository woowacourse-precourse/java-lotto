package lotto.Utils.Validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoValidatorTest {
    @DisplayName("입력받은 당첨로또번호가 문자를 포함하면 예외를 발생한다.")
    @Test
    void createLottoByNotInteger() {
        String input = "a,b,2,3,4,5";
        assertThatThrownBy(() -> new LottoValidator(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력받은 당첨로또번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        String input = "1,2,3,4,5,6,7";
        assertThatThrownBy(() -> new LottoValidator(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력받은 당첨로또번호에 1~45 사이 정수가 아닌 값이 있으면 예외가 발생한다.")
    @Test
    void createLottoByNotRange() {
        String input = "-2,0,3,4,5,87";
        assertThatThrownBy(() -> new LottoValidator(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력받은 당첨로또번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        String input = "1,2,3,3,5,41";
        assertThatThrownBy(() -> new LottoValidator(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
