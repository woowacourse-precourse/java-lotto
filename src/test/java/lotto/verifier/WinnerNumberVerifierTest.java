package lotto.verifier;

import lotto.util.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinnerNumberVerifierTest {
    WinnerNumberVerifier winnerNumberVerifier = new WinnerNumberVerifier();
    @Nested
    @DisplayName("유효한 개수가 입력되지 않았을 때")
    class CheckNumberCount {
        @ParameterizedTest(name = "{0}가 입력되었을 때")
        @ValueSource(strings = {
                " ",
                "1",
                "1,2",
                "1,2,3",
                "1,2,3, 4,5",
                "1,2,3,4,5,6,7"
        })
        void 유효한_개수가_입력되었는지_테스트한다(String target) {
            assertThatThrownBy(() -> winnerNumberVerifier.check(target))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ExceptionMessage.COUNT_NOT_EQUAL);
        }
    }

    @Nested
    @DisplayName("각 원소가 숫자가 아닐 때")
    class CheckEachNumeric {
        @ParameterizedTest(name = "{0}가 입력되었을 때")
        @ValueSource(strings = {
                "1,2,3,4,a,6",
                "@,2,3,4,5,6",
                "\\,2,3,4,5,6",
                "아,1,2,3,4,5"
        })
        void 각_원소가_숫자인지_테스트한다(String target) {
            assertThatThrownBy(() -> winnerNumberVerifier.check(target))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ExceptionMessage.EACH_NOT_NUMERIC);
        }
    }
}