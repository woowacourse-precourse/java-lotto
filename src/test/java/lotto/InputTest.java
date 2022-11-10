package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputTest {

    @ParameterizedTest
    @DisplayName("1000원으로 나누어 떨어지지 않을 때 예외")
    @ValueSource(strings = {
            "999",
            "1001"
    })
    void validateAmount(String input) {
        InputStream in = generateInput(input);
        System.setIn(in);

        assertThatThrownBy(Input::purchaseAmount)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("구매 금액 문자 입력했을 때 예외")
    @ValueSource(strings = {
            "1000j",
            "abcde"
    })
    void validateNumber(String input) {
        InputStream in = generateInput(input);
        System.setIn(in);

        assertThatThrownBy(Input::purchaseAmount)
                .isInstanceOf(IllegalArgumentException.class);
    }

    private InputStream generateInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }
}
