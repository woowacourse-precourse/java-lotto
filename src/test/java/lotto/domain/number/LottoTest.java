package lotto.domain.number;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.common.CommonExceptionTest;
import lotto.helper.util.LottoTestUtils;
import lotto.util.message.LottoExceptionMessageUtils;
import lotto.util.number.LottoNumberConst;
import lotto.util.number.LottoNumberFactory;
import lotto.mvc.util.LottoRanking;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoTest {

    private static final int VALID_NUMBER_COUNT = 6;
    private static final String NUMBER_SEPARATOR = ",";

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
    class ListConstructorTest extends CommonExceptionTest {

        @ParameterizedTest
        @ValueSource(strings = {"1,2,3,4,5,6", "23,43,15,17,12,39"})
        @DisplayName("만약 6개의 중복되지 않은 유효한 숫자가 주어지면 numbers 필드를 초기화한 Lotto를 반환한다.")
        void list_constructor_test(String input) {
            List<Integer> numbers = Arrays.stream(input.split(NUMBER_SEPARATOR))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            Lotto lotto = new Lotto(numbers);
            List<LottoNumber> result = LottoTestUtils.findNumbers(lotto);

            assertThat(result.size()).isSameAs(VALID_NUMBER_COUNT);
        }

        @ParameterizedTest
        @CsvSource(
                value = {
                    "1,2,3,4,5:5",
                    "12,41,13,17,42,1,2:7",
                    "1,2,3,4,5,5:5"
                },
                delimiter = ':'
        )
        @DisplayName("만약 중복되지 않는 유효한 숫자가 6개가 아니라면 IllegalArgumentException 예외가 발생한다.")
        void list_constructor_exception_test(String invalidInput, int numberCount) {
            List<Integer> numbers = Arrays.stream(invalidInput.split(NUMBER_SEPARATOR))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            assertIllegalArgumentExceptionWithMessage(() -> new Lotto(numbers),
                    LottoExceptionMessageUtils.INVALID_NUMBER_SIZE
                            .findExceptionMessage(numberCount));
        }
    }

    @Nested
    @DisplayName("String winningNumbers를 매개변수로 받는 생성자는")
    class StringConstructorTest extends CommonExceptionTest {

        @ParameterizedTest
        @ValueSource(strings = {"1,2,3,4,5,6", "11,12,13,14,15,16"})
        @DisplayName("만약 6개의 중복되지 않은 유효한 숫자가 적합한 구분자로 구분된 문자열로 주어지면 numbers 필드를 초기화한 Lotto를 반환한다.")
        void success_test(String input) {
            Lotto lotto = new Lotto(input);

            List<LottoNumber> numbers = LottoTestUtils.findNumbers(lotto);

            assertThat(numbers.size()).isSameAs(VALID_NUMBER_COUNT);
        }

        @Nested
        @DisplayName("만약 입력 값의 길이가 11(한 자릿수 6 + 구분자 5)에서 17(두 자릿수 12 + 구분자 6) 사이의 유효한 값이 아니라면")
        class InvalidInputLengthNestedTest {

            @ParameterizedTest
            @ValueSource(strings = {"1,2,3,4,5", "12,23,34,21,24,123", "123,234,345,456,567,678"})
            @DisplayName("IllegalArgumentException 예외가 발생한다.")
            void invalid_input_length_exception_test(String invalidInput) {
                assertIllegalArgumentExceptionWithMessage(() -> new Lotto(invalidInput),
                        LottoExceptionMessageUtils.INVALID_NUMBER_LENGTH
                                .findExceptionMessage(invalidInput.length()));
            }
        }

        @ParameterizedTest
        @ValueSource(strings = {"1:2:3:4:5:6", "111213141516", "1.2.3.4.5.6", "1@2@3@4@5@6"})
        @DisplayName("만약 유효한 구분자(,)가 오지 않은 경우 IllegalArgumentException 예외가 발생한다.")
        void invalid_separator_exception_test(String invalidInput) {
            assertIllegalArgumentExceptionWithMessage(() -> new Lotto(invalidInput),
                    LottoExceptionMessageUtils.INVALID_SEPARATOR
                            .findExceptionMessage(invalidInput));
        }

        @ParameterizedTest
        @ValueSource(
                strings = {
                    "1, 2, 3, 4, 5, 6",
                    "1 , 2 , 3 , 4 , 5 , 6",
                    "1,a,3,4,5,6",
                    " ,2,3,4,5,6",
                    "1, 2,3,4,5,6",
                    "@,2,3,4,5,6"
                }
        )
        @DisplayName("만약 입력 값을 숫자로 치환할 수 없다면 IllegalArgumentException 예외가 발생한다.")
        void invalid_number_format_exception_test(String invalidInput) {
            assertThatThrownBy(() -> new Lotto(invalidInput))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @ParameterizedTest
        @CsvSource(
                value = {
                    "0,1,2,3,4,5:0",
                    "1,2,3,4,5,46:46"
                },
                delimiter = ':'
        )
        @DisplayName("만약 입력한 숫자의 범위가 1 ~ 45 사이가 아니라면 IllegalArgumentException 예외가 발생한다.")
        void invalid_number_range_exception_test(String invalidInput, String message) {
            assertIllegalArgumentExceptionWithMessage(() -> new Lotto(invalidInput),
                    LottoExceptionMessageUtils.INVALID_NUMBER_RANGE
                            .findExceptionMessage(message));
        }

        @ParameterizedTest
        @CsvSource(
                value = {
                    "11,22,31,42,21:5",
                    "1,4,2,7,3,9,5:7"
                },
                delimiter = ':'
        )
        @DisplayName("만약 중복되지 않는 유효한 숫자가 6개가 아니라면 IllegalArgumentException 예외가 발생한다.")
        void invalid_number_count_exception_test(String invalidInput, int numberCount) {
            List<Integer> numbers = Arrays.stream(invalidInput.split(NUMBER_SEPARATOR))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            assertIllegalArgumentExceptionWithMessage(() -> new Lotto(invalidInput),
                    LottoExceptionMessageUtils.INVALID_NUMBER_SIZE
                            .findExceptionMessage(numberCount));
        }
    }

    @Nested
    @DisplayName("calculateLottoGrade 메소드는")
    class CalculateLottoGradeMethodTest {

        private final Lotto playerLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        @ParameterizedTest
        @MethodSource("lotto.domain.argument.LottoTestArgument#calculateLottoGradeArgument")
        @DisplayName("만약 당첨 번호와 보너스 번호를 입력하면 대상 로또가 몇 등인지 계산해 반환한다.")
        void success_test(String winningNumbers, int bonusNumber, LottoRanking expectedLottoRanking) {
            Lotto winningLotto = new Lotto(winningNumbers);

            LottoRanking actualLottoRanking = winningLotto
                    .calculateLottoGrade(playerLotto, LottoNumberFactory.numberOf(bonusNumber));

            assertThat(actualLottoRanking).isSameAs(expectedLottoRanking);
        }
    }

    @Nested
    @DisplayName("toString 메소드는")
    class ToStringMethodTest {

        private static final String LOTTO_PRINT_SEPARATOR = ", ";
        private static final String LOTTO_PRINT_LOG_OPEN_BRACKET = "[";
        private static final String LOTTO_PRINT_LOG_CLOSE_BRACKET = "]";

        @RepeatedTest(10)
        @DisplayName("생성한 Lotto의 numbers 필드를 오름차순으로 정해진 형식에 맞는 문자열을 반환한다.")
        void to_string_test() {
            List<Integer> uniqueNumbers = createUniqueNumbers();
            String lottoPrintLog = new Lotto(uniqueNumbers).toString();
            assertThat(lottoPrintLog).contains(LOTTO_PRINT_LOG_OPEN_BRACKET, LOTTO_PRINT_LOG_CLOSE_BRACKET);

            lottoPrintLog = lottoPrintLog.substring(1, lottoPrintLog.length() - 1);

            List<Integer> numbers = Arrays.stream(lottoPrintLog.split(LOTTO_PRINT_SEPARATOR))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            IntStream.range(0, numbers.size() - 1)
                    .forEach(i -> assertThat(numbers.get(i)).isLessThan(numbers.get(i + 1)));
        }

        private List<Integer> createUniqueNumbers() {
            return Randoms.pickUniqueNumbersInRange(
                    LottoNumberConst.MIN_NUMBER_INT_VALUE,
                    LottoNumberConst.MAX_NUMBER_INT_VALUE,
                    LottoNumberConst.NUMBER_SIZE);
        }
    }
}
