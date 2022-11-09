package lotto.view;

import lotto.utils.UserInputValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.*;

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
        Assertions.assertDoesNotThrow(InputView::inputPurchaseAmount);
    }
}