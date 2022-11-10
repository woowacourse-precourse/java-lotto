package lotto.view;

import lotto.utils.UserInputValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {

    @DisplayName("구입 금액 - 숫자만 입력 가능")
    @ParameterizedTest
    @ValueSource(strings = {"wrong", "input"})
    void 구입_금액은_숫자(String userInput) {
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);
        assertThatThrownBy(InputView::inputPurchaseAmount)
                .hasMessage(UserInputValidator.ERROR_MESSAGE_NOT_DIGIT);
    }

    @DisplayName("구입 금액 - 1000원 단위만 입력 가능")
    @ParameterizedTest
    @ValueSource(strings = {"1001", "2005"})
    void 구입_금액은_1000원_단위(String userInput) {
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);
        assertThatThrownBy(InputView::inputPurchaseAmount)
                .hasMessage(UserInputValidator.ERROR_MESSAGE_NOT_VALID_UNIT_OF_MONEY);
    }

    @DisplayName("구입 금액 - 정상 입력")
    @ParameterizedTest
    @ValueSource(strings = {"1000", "2000"})
    void 구입_금액_정상입력(String userInput) {
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);
        assertDoesNotThrow(InputView::inputPurchaseAmount);
    }

    @DisplayName("당첨 번호 - 숫자만 입력 가능")
    @ParameterizedTest
    @ValueSource(strings = {"g,1,2,3,4,5", "1,a,2,3,4,5"})
    void 당첨_번호_숫자만_입력_가능(String userInput) {
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);
        assertThatThrownBy(InputView::inputWinningNumber)
                .hasMessage(UserInputValidator.ERROR_MESSAGE_NOT_DIGIT);
    }

    @DisplayName("당첨 번호 - 6개만 입력 가능")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6,7", "45"})
    void 당첨_번호_6개만_입력_가능(String userInput) {
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);
        assertThatThrownBy(InputView::inputWinningNumber)
                .hasMessage(UserInputValidator.ERROR_MESSAGE_NOT_VALID_LOTTO_SIZE);
    }

    @DisplayName("당첨 번호 - 중복 불가")
    @ParameterizedTest
    @ValueSource(strings = {"1,1,2,3,4,5", "1,2,3,4,5,5"})
    void 당첨_번호_중복_불가(String userInput) {
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);
        assertThatThrownBy(InputView::inputWinningNumber)
                .hasMessage(UserInputValidator.ERROR_MESSAGE_DUPLICATE_NUMBER);
    }

    @DisplayName("당첨 번호 - 1 ~ 45사이의 숫자")
    @ParameterizedTest
    @ValueSource(strings = {"0,1,2,3,4,5", "1,2,3,4,5,46"})
    void 당첨_번호_1부터_45까지의_숫자(String userInput) {
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);
        assertThatThrownBy(InputView::inputWinningNumber)
                .hasMessage(UserInputValidator.ERROR_MESSAGE_NOT_VALID_LOTTO_NUMBER);
    }

    @DisplayName("당첨 번호 - 정상 입력")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6", "12,23,32,41,44,45"})
    void 당첨_번호_정상입력(String userInput) {
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);
        assertDoesNotThrow(InputView::inputWinningNumber);
    }
}