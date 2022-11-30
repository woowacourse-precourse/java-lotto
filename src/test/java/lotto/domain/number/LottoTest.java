package lotto.domain.number;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.game.LottoRanking;
import lotto.utils.consts.LottoConst;
import lotto.utils.message.ExceptionMessageUtil;
import lotto.utils.number.LottoNumberFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
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
            @DisplayName("IllegalArgumentException 예외가 발생한다.")
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
            @DisplayName("IllegalArgumentException 예외가 발생한다.")
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
        @DisplayName("만약 플레이어가 구매한 로또와 유효한 보너스 번호가 주어지면")
        class ContextWithPlayerLottoAndBonusNumberTest {

            private final Lotto playerLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

            @ParameterizedTest
            @MethodSource("lotto.domain.number.arguments.LottoTestArgument#lottoRankingArgument")
            @DisplayName("당첨 등수를 반환한다")
            void it_returns_lottoRanking(String winningNumbers, int bonusNumber, LottoRanking expectedLottoRanking) {
                Lotto winningLotto = new Lotto(winningNumbers);

                LottoRanking actualLottoRanking = winningLotto
                        .calculateLottoRanking(playerLotto, LottoNumberFactory.numberOf(bonusNumber));

                assertThat(actualLottoRanking).isSameAs(expectedLottoRanking);
            }
        }

        @Nested
        @DisplayName("만약 플레이어가 구매한 로또와 유효하지 않은 보너스 번호가 주어지면")
        class ContextWithPlayerLottoAndInvalidBonusNumberTest {

            private final Lotto playerLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

            @ParameterizedTest
            @MethodSource("lotto.domain.number.arguments.LottoTestArgument#lottoRankingInvalidBonusNumberArgument")
            @DisplayName("당첨 등수를 반환한다")
            void it_throws_exception(String winningNumbers, int bonusNumber) {
                Lotto winningLotto = new Lotto(winningNumbers);

                assertThatThrownBy(() -> winningLotto.calculateLottoRanking(playerLotto, LottoNumberFactory
                        .numberOf(bonusNumber)))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(ExceptionMessageUtil.WRONG_BONUS_NUMBER.findFullMessage());
            }
        }
    }

    @Nested
    @DisplayName("getLottoNumbers 메소드는")
    class DescribeGetLottoNumbersMethodTest {

        @Nested
        @DisplayName("만약 호출하면")
        class ContextWithoutParameterTest {

            private static final String LOTTO_PRINT_SEPARATOR = ", ";

            @RepeatedTest(10)
            @DisplayName("해당 Lotto의 LottoNumber를 오름차순으로 정렬한 문자열을 반환한다")
            void it_return_sortedLottoNumbersLogMessage() {
                List<Integer> uniqueNumbers = createUniqueNumbers();
                String lottoNumbersLogMessage = new Lotto(uniqueNumbers).getSortedLottoNumbers();

                List<Integer> numbers = mapToNumbers(lottoNumbersLogMessage);

                IntStream.range(0, numbers.size() - 1)
                        .forEach(i -> assertThat(numbers.get(i)).isLessThan(numbers.get(i + 1)));
            }

            private List<Integer> createUniqueNumbers() {
                return Randoms.pickUniqueNumbersInRange(
                        LottoConst.MIN_NUMBER_VALUE,
                        LottoConst.MAX_NUMBER_VALUE,
                        LottoConst.NUMBER_SIZE);
            }

            private List<Integer> mapToNumbers(String lottoNumbersLogMessage) {
                return Arrays.stream(lottoNumbersLogMessage.split(LOTTO_PRINT_SEPARATOR))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
            }
        }
    }
}
