package lotto;

import java.util.Arrays;
import java.util.stream.Collectors;
import lotto.domain.number.Lotto;
import lotto.domain.number.LottoNumber;
import lotto.utils.message.ExceptionMessageUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Nested
    @DisplayName("List<Integer> numbers를 매개변수로 받는 생성자는")
    class DescribeListConstructorTest {

        private static final String NUMBER_SEPARATOR = ",";

        @Nested
        @DisplayName("만약 6개의 중복되지 않은 유효한 숫자 numbers가 주어지면")
        class ContextWithNumbersTest {

            @ParameterizedTest
            @ValueSource(strings = {"1,2,3,4,5,6", "23,43,15,17,12,39"})
            @DisplayName("List<LottoNumbers>를 초기화한 Lotto를 반환한다")
            void it_returns_lotto(String input) {
                List<Integer> numbers = Arrays.stream(input.split(NUMBER_SEPARATOR))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

                assertThatCode(() -> new Lotto(numbers)).doesNotThrowAnyException();
            }
        }

        @Nested
        @DisplayName("만약 유효한 숫자가 6개가 아닌 numbers가 주어지면")
        class ContextWithInvalidNumberSizeTest {

            @ParameterizedTest
            @ValueSource(strings = {"1,2,3,4,5", "12,41,13,17,42,1,2", "1,2,3,4,5,5"})
            @DisplayName("IllegalArgumentException 예외가 발생한다.")
            void it_throws_exception(String invalidInput) {
                List<Integer> numbers = Arrays.stream(invalidInput.split(NUMBER_SEPARATOR))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

                assertThatThrownBy(() -> new Lotto(numbers))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(ExceptionMessageUtil.WRONG_NUMBER_SIZE.findFullMessage());
            }
        }
    }

    @Nested
    @DisplayName("String winningNumbers를 매개변수로 받는 생성자는")
    class DescribeStringConstructorTest {

        @Nested
        @DisplayName("만약 6개의 중복되지 않은 유효한 숫자가 적합한 구분자로 구분된 문자열이 주어지면")
        class ContextWithNumbersTest {

            @ParameterizedTest
            @ValueSource(strings = {"1,2,3,4,5,6", "11,12,13,14,15,16"})
            @DisplayName("List<LottoNumbers>를 초기화한 Lotto를 반환한다")
            void it_returns_lotto(String input) {
                assertThatCode(() -> new Lotto(input)).doesNotThrowAnyException();
            }
        }

        @Nested
        @DisplayName("만약 길이가 11에서 17 사이의 유효한 입력이 주어지면")
        class ContextWithInvalidNumbersLengthTest {

            @ParameterizedTest
            @ValueSource(strings = {"1,2,3,4,5", "12,23,34,21,24,123", "123,234,345,456,567,678"})
            @DisplayName("IllegalArgumentException 예외가 발생한다.")
            void it_throws_exception(String invalidInput) {
                assertThatThrownBy(() -> new Lotto(invalidInput))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(ExceptionMessageUtil.WRONG_NUMBER_LENGTH.findFullMessage());
            }
        }

        @Nested
        @DisplayName("만약 유효한 구분자가 아닌 입력이 주어지면")
        class ContextWithInvalidSeparatorTest {

            @ParameterizedTest
            @ValueSource(strings = {"1:2:3:4:5:6", "111213141516", "1.2.3.4.5.6", "1@2@3@4@5@6"})
            @DisplayName("IllegalArgumentException 예외가 발생한다.")
            void it_throws_exception(String invalidInput) {
                assertThatThrownBy(() -> new Lotto(invalidInput))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(ExceptionMessageUtil.WRONG_SEPARATOR.findFullMessage());
            }
        }

        @Nested
        @DisplayName("만약 숫자로 변경이 불가능한 입력이 주어지면")
        class ContextWithInvalidNumberFormatTest {

            @ParameterizedTest
            @ValueSource(
                strings = {
                    "1, 2, 3, 4, 5, 6",
                    "1,a,3,4,5,6",
                    " ,2,3,4,5,6",
                    "1, 2,3,4,5,6",
                    "@,2,3,4,5,6"
                }
            )
            @DisplayName("IllegalArgumentException 예외가 발생한다")
            void invalid_number_format_exception_test(String invalidInput) {
                assertThatThrownBy(() -> new Lotto(invalidInput))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(ExceptionMessageUtil.WRONG_NUMBER_FORMAT.findFullMessage());
            }
        }

        @Nested
        @DisplayName("만약 1 ~ 45 사이의 숫자가 아닌 입력이 주어지면")
        class ContextWithInvalidNumberRangeTest {

            @ParameterizedTest
            @ValueSource(strings = {"0,1,2,3,4,5", "1,2,3,4,5,46"})
            @DisplayName("만약 입력한 숫자의 범위가 1 ~ 45 사이가 아니라면 IllegalArgumentException 예외가 발생한다.")
            void invalid_number_range_exception_test(String invalidInput) {
                assertThatThrownBy(() -> new Lotto(invalidInput))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(ExceptionMessageUtil.WRONG_NUMBER_RANGE.findFullMessage());
            }
        }

        @Nested
        @DisplayName("만약 중복되지 않는 유효한 숫자가 6개가 아닌 입력이 주어지면")
        class ContextWithInvalidNumberSizeTest {

            @ParameterizedTest
            @ValueSource(strings = {"11,22,31,42,21", "1,4,2,7,3,9,5"})
            @DisplayName("만약 중복되지 않는 유효한 숫자가 6개가 아니라면 IllegalArgumentException 예외가 발생한다.")
            void invalid_number_count_exception_test(String invalidInput) {
                assertThatThrownBy(() -> new Lotto(invalidInput))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(ExceptionMessageUtil.WRONG_NUMBER_SIZE.findFullMessage());
            }
        }
    }

    @Nested
    @DisplayName("calculateLottoRanking 메소드는")
    class DescribeCalculateLottoRankingMethodTest {

        @Nested
        @DisplayName("만약 플레이어가 구매한 로또와 보너스 번호가 주어지면")
        class ContextWithPlayerLottoAndBonusNumberTest {

            @DisplayName("당첨 등수를 반환한다")
            void it_returns_lottoRanking() {

            }
        }
    }
}
