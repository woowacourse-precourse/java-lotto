package lotto.domain.number;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.IntStream;
import lotto.common.CommonExceptionTest;
import lotto.helper.util.LottoNumberTestUtils;
import lotto.util.message.LottoExceptionMessageUtils;
import lotto.util.number.LottoNumberConst;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberTest {

    @Nested
    @DisplayName("int number를 매개변수로 받는 생성자는")
    class IntConstructorTest extends CommonExceptionTest {

        @Test
        @DisplayName("만약 1 ~ 45까지의 범위에 포함되는 숫자가 주어지면 숫자를 number로 초기화한 LottoNumber를 생성한다.")
        void success_test() {
            IntStream.rangeClosed(LottoNumberConst.MIN_NUMBER_INT_VALUE, LottoNumberConst.MAX_NUMBER_INT_VALUE)
                    .forEach(number -> {
                        LottoNumber lottoNumber = new LottoNumber(number);
                        assertThat(LottoNumberTestUtils.findNumber(lottoNumber)).isSameAs(number);
                    });
        }

        @ParameterizedTest
        @ValueSource(ints = {0, 46})
        @DisplayName("만약 1 ~ 45까지의 범위에 포함되지 않는 숫자가 주어지면 IllegalArgumentException 예외가 발생한다.")
        void exception_test(int wrongNumber) {
            assertIllegalArgumentExceptionWithMessage(() -> new LottoNumber(wrongNumber),
                    LottoExceptionMessageUtils.INVALID_NUMBER_RANGE
                            .findExceptionMessage(String.valueOf(wrongNumber)));
        }
    }

    @Nested
    @DisplayName("equals 메소드는")
    class EqualsMethodTest {

        @ParameterizedTest
        @CsvSource(
                value = {
                    "1:1",
                    "2:2",
                    "3:3",
                    "45:45"
                },
                delimiter = ':'
        )
        @DisplayName("만약 number가 동일한 LottoNumber가 주어지면 true를 반환한다.")
        void false_test(int number1, int number2) {
            assertThat(new LottoNumber(number1)).isEqualTo(new LottoNumber(number2));
        }

        @ParameterizedTest
        @CsvSource(
                value = {
                    "1:2",
                    "2:3",
                    "3:4",
                    "43:45"
                },
                delimiter = ':'
        )
        @DisplayName("만약 number가 동일하지 않은 LottoNumber가 주어지면 false를 반환한다.")
        void true_test(int number1, int number2) {
            assertThat(new LottoNumber(number1)).isNotEqualTo(new LottoNumber(number2));
        }
    }
}