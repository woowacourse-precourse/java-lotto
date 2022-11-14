package lotto.domain.vo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import lotto.domain.constants.ErrorCode;
import lotto.domain.vo.Lotto;
import lotto.veiw.InputHandler;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoTest {

    InputHandler inputHandler = new InputHandler();

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Normal Lotto")
    @ParameterizedTest(name = "[{index}] input {0} ")
    @ValueSource(strings = {"1,2,3,4,5,6", "1,10,20,30,40,45", "40,41,42,43,44,45"})
    void getBonusNumber_7_7(String inputString) {
        Lotto lotto = new Lotto(inputHandler.stringToList(inputString));
        assertThat(lotto.getLottoNumbers()).isEqualTo(inputHandler.stringToList(inputString));
    }

    @DisplayName("Not six digits")
    @ParameterizedTest(name = "[{index}] input {0} ")
    @ValueSource(strings = {"1,2,3,4,5", "1,10,20,30,40,45,2"})
    public void validateSixDigits_1234566_NOTSIXDIGITS(String inputString) {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            new Lotto(inputHandler.stringToList(inputString));
        });
        assertEquals(ErrorCode.NOT_SIX_DIGITS.getErrorMessage(), exception.getMessage());
    }

    @DisplayName("Unvalidated range")
    @ParameterizedTest(name = "[{index}] input {0} ")
    @ValueSource(strings = {"0,2,3,4,5,6", "-1,10,20,30,40,45", "40,41,42,43,44,46"})
    public void validateRange_0or46_NOTINRANGE(String inputString) {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            new Lotto(inputHandler.stringToList(inputString));
        });
        assertEquals(ErrorCode.NOT_IN_RANGE.getErrorMessage(), exception.getMessage());
    }
}
