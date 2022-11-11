package lotto.verifier;

import static org.assertj.core.api.Assertions.assertThatThrownBy;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MoneyVerifierTest {
    private final MoneyVerifier moneyVerifier = new MoneyVerifier();

    @DisplayName("숫자가 아닌 값이 입력되었을 때")
    @ParameterizedTest(name = "{0}가 입력되었을 때")
    @ValueSource(strings = {"abc", "!@#", "   ", "ZXc", "ZXC", "%^&", "?\\"})
    void 숫자가_아닌_값을_테스트한다(String target) {
        assertThatThrownBy(() -> moneyVerifier.check(target))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 입력된 값은 숫자가 아닙니다.");
    }

    @DisplayName("자료형 범위를 벗어났을 때")
    @ParameterizedTest(name = "{0}가 입력되었을 때")
    @ValueSource(strings = {"-9223372036854775809", "9223372036854775808"})
    void 자료형_범위를_벗어났을때를_테스트한다(String target) {
        assertThatThrownBy(() -> moneyVerifier.check(target))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 유효한 값 범위를 벗어났습니다.");
    }
}