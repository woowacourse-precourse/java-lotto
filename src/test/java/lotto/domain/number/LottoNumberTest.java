package lotto.domain.number;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.IntStream;
import lotto.utils.consts.LottoConst;
import lotto.utils.message.ExceptionMessageUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberTest {

    @Nested
    @DisplayName("int number를 매개변수로 받는 생성자는 ")
    class DescribeIntConstructorTest {

        @Nested
        @DisplayName("만약 유효한 number가 주어지면")
        class ContextWithNumberTest {

            @Test
            @DisplayName("LottoNumber를 생성한다")
            void it_returns_lottoNumber() {
                IntStream.rangeClosed(LottoConst.MIN_NUMBER_VALUE, LottoConst.MAX_NUMBER_VALUE)
                        .forEach(number -> assertThatCode(() -> new LottoNumber(number))
                                .doesNotThrowAnyException());
            }
        }

        @Nested
        @DisplayName("만약 유효하지 않은 number가 주어지면")
        class ContextWithInvalidNumberTest {

            @ParameterizedTest
            @ValueSource(ints = {0, 46})
            @DisplayName("IllegalArgumentException 에외가 발생한다")
            void it_throws_exception(int invalidInput) {
                assertThatThrownBy(() -> new LottoNumber(invalidInput))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(ExceptionMessageUtil.WRONG_NUMBER_RANGE.findFullMessage());
            }
        }
    }

    @Nested
    @DisplayName("equals 메소드는")
    class DescribeEqualsMethodTest {

        @Nested
        @DisplayName("만약 LottoNumber가 주어지면")
        class ContextWithoutParameterTest {

            @ParameterizedTest
            @CsvSource(
                    value = {
                        "1:1:true",
                        "1:2:false"
                    },
                    delimiter = ':'
            )
            @DisplayName("number가 동일한지에 대한 여부를 반환한다")
            void it_returns_equals(int number1, int number2, boolean expected) {
                LottoNumber lottoNumber1 = new LottoNumber(number1);
                LottoNumber lottoNumber2 = new LottoNumber(number2);

                boolean actual = lottoNumber1.equals(lottoNumber2);

                assertThat(actual).isSameAs(expected);
            }
        }
    }

    @Nested
    @DisplayName("toString 메소드는")
    class DescribeToStringMethodTest {

        @Nested
        @DisplayName("만약 호출하면")
        class ContextWithoutParameterTest {

            @Test
            @DisplayName("LottoNumber가 가지고 있는 로또 번호를 반환한다")
            void it_returns_number() {
                IntStream.rangeClosed(LottoConst.MIN_NUMBER_VALUE, LottoConst.MAX_NUMBER_VALUE)
                        .forEach(number -> {
                            String actual = new LottoNumber(number).toString();
                            assertThat(actual).contains(String.valueOf(number));
                        });
            }
        }
    }
}