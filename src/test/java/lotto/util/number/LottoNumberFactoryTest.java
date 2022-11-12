package lotto.util.number;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.IntStream;
import lotto.domain.LottoNumber;
import lotto.helper.util.LottoNumberTestUtils;
import lotto.util.message.LottoExceptionMessageUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberFactoryTest {

    @Nested
    @DisplayName("numberOf 메소드는")
    class NumberOfMethodTest {

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
            assertThatThrownBy(() -> new LottoNumber(wrongNumber))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(LottoExceptionMessageUtils.INVALID_NUMBER_RANGE
                            .findExceptionMessage(String.valueOf(wrongNumber)));
        }
    }
}