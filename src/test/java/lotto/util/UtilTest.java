package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class UtilTest {
    @Nested
    @DisplayName("calculateYield 메소드 테스트")
    class CalculateYield {
        @ParameterizedTest(name = "{0}가 입력됐을 때")
        @CsvSource(value = {
                "8000, 5000, 62.5",
                "5000, 5000, 100",
                "10000, 5000, 50",
                "50000, 0, 0",
                "1500000, 1500000, 100"
        })
        void 수익률을_잘_계산하는지_테스트한다(float before, float after, float expected) {
            assertThat(Util.calculateYield(before + after, before)).isEqualTo(expected);
        }
    }

    @Nested
    @DisplayName("formatFloat 메소드 테스트")
    class FormatFloat {
        @ParameterizedTest(name = "{0}가 입력됐을 때")
        @CsvSource(value = {
                "62.46: 1: 62.5",
                "625.46: 1: 625.5",
                "1000000.0: 1: 1,000,000.0",
                "62.46: 0: 62.0"
        }, delimiter = ':')
        void 콤마를_잘_삽입하고_소숫점에서_반올림하는지_테스트한다(float target, int precision, String expected) {
            assertThat(Util.makeFloatFormatted(target, precision)).isEqualTo(expected);
        }
    }
}