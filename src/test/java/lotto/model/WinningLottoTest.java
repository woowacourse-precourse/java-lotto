package lotto.model;

import static lotto.constant.WinningLottoConstants.DUPLICATE_WINNING_NUMBER_EXIST_MSG;
import static lotto.constant.WinningLottoConstants.INVALID_RANGED_WINNING_LOTTO_INPUT_MSG;
import static lotto.constant.WinningLottoConstants.INVALID_WINNING_LOTTO_INPUT_FORM_MSG;
import static lotto.constant.WinningLottoConstants.INVALID_WINNING_LOTTO_SIZE_MSG;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class WinningLottoTest {
    @Test
    @DisplayName("사용자에게 입력받은 값이 비어있는 경우 이유를 나타내는 메세지를 포함한 예외가 발생한다.")
    void createLottoByUserInputWithEmptyValue() {
        //given
        String userInput ="";
        assertThatThrownBy(() -> WinningLotto.from(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_WINNING_LOTTO_SIZE_MSG);
    }

    @ParameterizedTest
    @DisplayName("사용자에게 입력받은 값을 쉼표로 구분했을 때 로또 크기만큼 구분되지 않는 경우 이유를 나타내는 메세지를 포함한 예외가 발생한다.")
    @ValueSource(strings = {"123456","12345,6","1234,5,6","123,4,5,6","12,3,4,5,6","abc,d,e,f","ab,c,d,e,f",})
    void createLottoByUserInputWithWrongForm(String userInput) {
        assertThatThrownBy(() -> WinningLotto.from(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_WINNING_LOTTO_INPUT_FORM_MSG);
    }

    @ParameterizedTest
    @DisplayName("구분된 값들 중 로또 숫자 범위를 제외한 값이 존재하는 경우 이유를 나타내는 메세지를 포함한 예외가 발생한다.")
    @ValueSource(strings = {"0,1,2,3,4,5","1,2,3,4,5,46","a,1,2,3,4,5","가,1,2,3,4,5","-1,2,3,4,5,6","1.1,1,2,3,4,5"})
    void createLottoByUserInputWithInvalidElements(String userInput) {
        assertThatThrownBy(() -> WinningLotto.from(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_RANGED_WINNING_LOTTO_INPUT_MSG);
    }

    @ParameterizedTest
    @DisplayName("구분된 값들 중 중복된 값이 존재하는 경우 이유를 나타내는 메세지를 포함한 예외가 발생한다.")
    @ValueSource(strings = {"1,2,3,4,5,5","1,2,3,5,5,5","1,2,5,5,5,5","1,5,5,5,5,5","5,5,5,5,5,5"})
    void createLottoByUserInputWithDuplicatedNumbers(String userInput) {
        assertThatThrownBy(() -> WinningLotto.from(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(DUPLICATE_WINNING_NUMBER_EXIST_MSG);
    }
}
