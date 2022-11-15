package lotto;

import java.util.List;
import lotto.util.LottoParser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoParserTest {

    @Nested
    class ParseToMoney {

        @DisplayName("문자열을 음수가 아닌 정수로 변환 한다.")
        @Test
        void parseUnsignedInt() {
            assertEquals(LottoParser.parseToMoney("1000"), 1000);
        }

        @DisplayName("음수인 문자열이면 예외 발생")
        @Test
        void parseNegativeInteger() {
            assertThatThrownBy(() -> LottoParser.parseToMoney("-1000"))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    class ParseToIntegers {

        @DisplayName("문자열을 ','로 구분하여 정수 리스트로 반환한다.")
        @Test
        void parseToIntegersSplitByComma() {
            assertEquals(LottoParser.parseToIntegers("1,2,3,4"), List.of(1, 2, 3, 4));
        }

        @DisplayName("음수인 문자열인 숫자가 있으면 예외 발생")
        @Test
        void parseNegativeIntegers() {
            assertThatThrownBy(() -> LottoParser.parseToIntegers("-1,-2,-3"))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("','로 구분된 문자열 숫자가 아니면 예외 발생")
        @Test
        void parseToIntegersNotSplitByComma() {
            assertThatThrownBy(() -> LottoParser.parseToIntegers("1-2-3"))
                    .isInstanceOf(IllegalArgumentException.class);
            assertThatThrownBy(() -> LottoParser.parseToIntegers("1, 2, 3"))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    class ParseToBonumNumber {

        @DisplayName("문자열을 음수가 아닌 정수로 변환 한다.")
        @Test
        void parseUnsignedInt() {
            assertEquals(LottoParser.parseToBonumNumber("7"), 7);
        }

        @DisplayName("음수인 문자열이면 예외 발생")
        @Test
        void parseNegativeInteger() {
            assertThatThrownBy(() -> LottoParser.parseToBonumNumber("-7"))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

}
