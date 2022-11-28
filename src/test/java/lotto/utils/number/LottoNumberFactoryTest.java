package lotto.utils.number;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.IntStream;
import lotto.utils.consts.LottoConst;
import lotto.utils.message.ExceptionMessageUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberFactoryTest {

    @Nested
    @DisplayName("int number를 매개변수로 받는 numberOf 메소드는")
    class DescribeIntNumberOfMethodTest {

        @Nested
        @DisplayName("만약 int 타입의 유효한 number가 주어지면")
        class ContextWithNumberTest {

            @Test
            @DisplayName("동일한 number를 가진 LottoNumber를 반환한다")
            void it_returns_lottoNumber() {
                IntStream.rangeClosed(LottoConst.MIN_NUMBER_VALUE, LottoConst.MAX_NUMBER_VALUE)
                        .forEach(number -> assertThatCode(() -> LottoNumberFactory.numberOf(number))
                                .doesNotThrowAnyException());
            }
        }

        @Nested
        @DisplayName("만약 int 타입의 유효하지 않는 number가 주어지면")
        class ContextWithInvalidNumberRangeTest {

            @ParameterizedTest
            @ValueSource(ints = {0, 46})
            @DisplayName("IllegalArgumentException 예외가 발생한다")
            void it_throws_exception(int invalidInput) {
                assertThatThrownBy(() -> LottoNumberFactory.numberOf(invalidInput))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(ExceptionMessageUtil.WRONG_NUMBER_RANGE.findFullMessage());
            }
        }
    }

    @Nested
    @DisplayName("String number를 매개변수로 받는 numberOf 메소드는")
    class DescribeStringNumberOfMethodTest {

        @Nested
        @DisplayName("만약 String 타입의 유효한 number가 주어지면")
        class ContextWithNumberTest {

            @Test
            @DisplayName("동일한 number를 가진 LottoNumber를 반환한다")
            void it_returns_lottoNumber() {
                IntStream.rangeClosed(LottoConst.MIN_NUMBER_VALUE, LottoConst.MAX_NUMBER_VALUE)
                        .mapToObj(String::valueOf)
                        .forEach(number -> assertThatCode(() -> LottoNumberFactory.numberOf(number))
                                .doesNotThrowAnyException());
            }
        }

        @Nested
        @DisplayName("만약 String 타입의 유효하지 않는 number가 주어지면")
        class ContextWithInvalidNumberRangeTest {

            @ParameterizedTest
            @ValueSource(strings = {"0", "46"})
            @DisplayName("IllegalArgumentException 예외가 발생한다")
            void it_throws_exception(String invalidInput) {
                assertThatThrownBy(() -> LottoNumberFactory.numberOf(invalidInput))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(ExceptionMessageUtil.WRONG_NUMBER_RANGE.findFullMessage());
            }
        }

        @Nested
        @DisplayName("만약 String 타입의 유효하지 않는 number가 주어지면")
        class ContextWithInvalidNumberFormatTest {

            @ParameterizedTest
            @ValueSource(strings = {"@", " "})
            @DisplayName("IllegalArgumentException 예외가 발생한다")
            void it_throws_exception(String invalidInput) {
                assertThatThrownBy(() -> LottoNumberFactory.numberOf(invalidInput))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(ExceptionMessageUtil.WRONG_NUMBER_FORMAT.findFullMessage());
            }
        }
    }
}