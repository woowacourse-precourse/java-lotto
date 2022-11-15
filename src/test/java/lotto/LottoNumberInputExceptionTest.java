package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.exception.LottoNumberInputException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoNumberInputExceptionTest {

    private LottoNumberInputException lottoNumberInputException = new LottoNumberInputException();

    @Test
    @DisplayName("로또 번호는 숫자로만 이루어져야 한다.")
    void isLottoNumberConsistOfOnlyNumber() {
        assertThatThrownBy(
                () -> lottoNumberInputException.isInputValid("1,2,a,3,9,B")).isInstanceOf(
                IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호는 6자리 숫자로 이루어져야 한다.")
    void isLottoNumberContainSixNumber() {
        assertThatThrownBy(
                () -> lottoNumberInputException.isInputValid("1,2,3,4,5,6,7")).isInstanceOf(
                IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호는 6자리 숫자로 이루어져야 한다.")
    void isLottoNumberInRange() {
        assertThatThrownBy(
                () -> lottoNumberInputException.isInputValid("1,101,3,46,5,6,7")).isInstanceOf(
                IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호는 겹치지 않는 숫자로 이루어져야 한다.")
    void isLottoNumberConsistOfUniqueNumber() {
        assertThatThrownBy(
                () -> lottoNumberInputException.isInputValid("1,2,4,4,6,7")).isInstanceOf(
                IllegalArgumentException.class);
    }
}
