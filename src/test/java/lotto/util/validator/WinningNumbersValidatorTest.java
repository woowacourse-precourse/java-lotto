package lotto.util.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

// 당첨 번호의 중복, 범위, 길이에 대한 예외 검사는 Contrller 에서 수행
class WinningNumbersValidatorTest {
    @DisplayName("당첨 숫자의 불필요한 문자 포함 예외 테스트")
    @Test
    void createWinningNumbersFormat() {
        assertThatThrownBy(() -> new WinningNumbersValidator("ABCD"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("당첨 숫자의 콤마의 위치 예외 테스트")
    @Test
    void createWinningNumbersComma() {
        assertThatThrownBy(() -> new WinningNumbersValidator(",1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
        assertThatThrownBy(() -> new WinningNumbersValidator("1,2,3,4,5,"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("당첨 숫자의 Null 문자 예외 테스트")
    @Test
    void createWinningNumbers() {
        assertThatThrownBy(() -> new WinningNumbersValidator(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");

    }
}