package lotto.console;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoneyInputTest {
    private final Console console = new MoneyInput();

    @ParameterizedTest
    @ValueSource(strings = {"0", "1000", "2000", "1001000", "100000000", "-0"})
    void 입력값이_올바른_경우(String input) {
        boolean result = true;
        try {
            console.checkInput(input);
        } catch (IllegalArgumentException e) {
            result = false;
        }
        assertThat(true).isEqualTo(result);
    }

    @ParameterizedTest
    @ValueSource(strings = {"i", "erdsa", "감사", "#$%&", "\n", "", "12a", "a12", "1000원", "10000000000"})
    void 숫자가아닌_입력값(String input) {
        assertThatThrownBy(() -> console.checkInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 숫자가 아닌 입력 또는 입력범위를 초과 했습니다");
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "-1000", "-1001000"})
    void 음수인_입력값(String input) {
        assertThatThrownBy(() -> console.checkInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 마이너스 금액으로 구매가 불가능합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"01000", "01001000", "0001000"})
    void 영으로_시작하는_입력값(String input) {
        assertThatThrownBy(() -> console.checkInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 0원빼고 0으로 시작하는 돈은 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1001", "999", "1", "100100"})
    void 천원단위가아닌_입력값(String input) {
        assertThatThrownBy(() -> console.checkInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 1000원 단위의 금액을 입력 해야합니다");
    }
}
