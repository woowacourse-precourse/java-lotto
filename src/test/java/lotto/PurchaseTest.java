package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PurchaseTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("입력값에 숫자가 아닌 문자가 있으면 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"1300k", "이만원", "1ooo", "twentythousand", "!7000"})
    void nonNumeric(String input) {
        assertThatThrownBy(() -> new Purchase(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("입력값이 천 원 단위가 아니면 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"10005", "50010", "2080332900", "1300"})
    void nonDividedByThousand(String input) {
        assertThatThrownBy(() -> new Purchase(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }
}