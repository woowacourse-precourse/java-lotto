package lotto.verifier;

import static org.assertj.core.api.Assertions.assertThatThrownBy;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MoneyVerifierTest {
    private final MoneyVerifier moneyVerifier = new MoneyVerifier();

    @DisplayName("숫자가 아닌 값이 입력되었을 때")
    @ParameterizedTest
    @ValueSource(strings = {"abc", "!@#", "   ", "ZXc", "ZXC", "%^&", "?\\"})
    void 숫자가_아닌_값을_테스트한다(String target) {
        assertThatThrownBy(() -> moneyVerifier.check(target))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 입력된 값은 숫자가 아닙니다.");
    }
}