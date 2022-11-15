package lotto.util.number;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.IntStream;
import lotto.common.CommonExceptionTest;
import lotto.domain.number.LottoNumber;
import lotto.helper.util.LottoNumberTestUtils;
import lotto.util.message.LottoExceptionMessageUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberFactoryTest {

    @Nested
    @DisplayName("int number를 매개변수로 받는 numberOf 메소드는")
    class IntNumberOfMethodTest extends CommonExceptionTest {

        @Test
        @DisplayName("만약 1 ~ 45까지의 범위에 포함되는 숫자가 주어지면 동일한 number의 LottoNumber를 반환한다.")
        void success_test() {
            IntStream.rangeClosed(LottoNumberConst.MIN_NUMBER_INT_VALUE, LottoNumberConst.MAX_NUMBER_INT_VALUE)
                    .forEach(number -> {
                        LottoNumber lottoNumber = LottoNumberFactory.numberOf(number);
                        assertThat(LottoNumberTestUtils.findNumber(lottoNumber)).isSameAs(number);
                    });
        }

        @ParameterizedTest
        @ValueSource(ints = {0, 46})
        @DisplayName("만약 1 ~ 45까지의 범위에 포함되지 않는 숫자가 주어지면 IllegalArgumentException이 발생한다.")
        void exception_test(int wrongNumber) {
            assertIllegalArgumentExceptionWithMessage(() -> LottoNumberFactory.numberOf(wrongNumber),
                    LottoExceptionMessageUtils.INVALID_NUMBER_RANGE
                            .findExceptionMessage(String.valueOf(wrongNumber)));
        }
    }

    @Nested
    @DisplayName("String number를 매개변수로 받는 numberOf 메소드는")
    class StringNumberOfMethodTest extends CommonExceptionTest {

        @Test
        @DisplayName("만약 1 ~ 45까지의 범위에 포함되는 문자열이 주어지면 동일한 number의 LottoNumber를 반환한다.")
        void success_test() {
            IntStream.rangeClosed(LottoNumberConst.MIN_NUMBER_INT_VALUE, LottoNumberConst.MAX_NUMBER_INT_VALUE)
                    .forEach(number -> {
                        LottoNumber lottoNumber = LottoNumberFactory.numberOf(String.valueOf(number));
                        assertThat(LottoNumberTestUtils.findNumber(lottoNumber)).isSameAs(number);
                    });
        }

        @ParameterizedTest
        @ValueSource(strings = {"0", "46"})
        @DisplayName("만약 1 ~ 45까지의 범위에 포함되지 않는 문자열이 주어지면 IllegalArgumentException이 발생한다.")
        void wrong_range_exception_test(String wrongNumber) {
            assertIllegalArgumentExceptionWithMessage(() -> LottoNumberFactory.numberOf(wrongNumber),
                    LottoExceptionMessageUtils.INVALID_NUMBER_RANGE
                            .findExceptionMessage(String.valueOf(wrongNumber)));
        }

        @ParameterizedTest
        @ValueSource(strings = {"a", "t", "1@"})
        @DisplayName("만약 1 ~ 45까지의 범위에 포함되지 않는 문자열이 주어지면 IllegalArgumentException이 발생한다.")
        void wrong_number_format_exception_test(String wrongNumber) {
            assertIllegalArgumentExceptionWithMessage(() -> LottoNumberFactory.numberOf(wrongNumber),
                    LottoExceptionMessageUtils.INVALID_NUMBER_FORMAT
                            .findExceptionMessage(wrongNumber));
        }
    }
}