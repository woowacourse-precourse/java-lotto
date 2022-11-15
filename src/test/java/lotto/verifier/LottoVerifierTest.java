package lotto.verifier;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.system.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoVerifierTest {
    LottoVerifier lottoVerifier = new LottoVerifier();

    @Nested
    @DisplayName("checkNumberCount 검증 테스트")
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
        void 유효한_개수가_입력되었는지_테스트(String target) {
            assertThatThrownBy(() -> lottoVerifier.check(target))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ExceptionMessage.COUNT_NOT_EQUAL);
        }
    }

    @Nested
    @DisplayName("checkEachNumeric 검증 테스트")
    class CheckEachNumeric {
        @ParameterizedTest(name = "{0}가 입력되었을 때")
        @ValueSource(strings = {
                "1,2,3,4,a,6",
                "@,2,3,4,5,6",
                "\\,2,3,4,5,6",
                "아,1,2,3,4,5"
        })
        void 각_원소가_숫자인지_테스트(String target) {
            assertThatThrownBy(() -> lottoVerifier.check(target))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ExceptionMessage.EACH_NOT_NUMERIC);
        }
    }

    @Nested
    @DisplayName("checkEachOutOfTypeRange 검증 테스트")
    class CheckEachOutOfTypeRange {
        @ParameterizedTest(name = "{0}가 입력되었을 때")
        @ValueSource(strings = {
                "-9223372036854775809,1,2,3,4,5",
                "1,2,3,4,5,9223372036854775808"
        })
        void 각_원소가_자료형의_범위를_넘지_않는지_테스트(String target) {
            assertThatThrownBy(() -> lottoVerifier.check(target))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ExceptionMessage.NUMBER_OUT_OF_TYPE_RANGE);
        }
    }

    @Nested
    @DisplayName("checkEachOutOfRange 검증 테스트")
    class CheckEachOutOfRange {
        @ParameterizedTest(name = "{0}가 입력되었을 때")
        @ValueSource(strings = {
                "1,2,3,4,5,46",
                "0,1,2,3,4,5",
                "46,47,48,49,50,51"
        })
        void 각_원소가_지정된_로또_값의_범위를_넘지_않는지_테스트(String target) {
            assertThatThrownBy(() -> lottoVerifier.check(target))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ExceptionMessage.NUMBER_EACH_OUT_OF_RANGE);
        }
    }

    @Nested
    @DisplayName("checkEachDistinct 검증 테스트")
    class CheckEachDistinct {
        @ParameterizedTest(name = "{0}가 입력되었을 때")
        @ValueSource(strings = {
                "1,2,3,4,5,1",
                "1,2,3,4,4,4",
                "43,43,43,45,45,45"
        })
        void 각_원소가_중복되지_않는지_테스트(String target) {
            assertThatThrownBy(() -> lottoVerifier.check(target))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ExceptionMessage.NUMBER_NOT_DISTINCT);
        }
    }
}