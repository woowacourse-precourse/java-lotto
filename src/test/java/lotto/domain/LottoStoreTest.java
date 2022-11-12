package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.helper.factory.stub.LottoStoreTestFactory;
import lotto.helper.util.LottoResultTestUtils;
import lotto.helper.util.LottoStoreTestUtils;
import lotto.helper.util.LottoTestUtils;
import lotto.helper.util.PlayerTestUtils;
import lotto.util.message.LottoExceptionMessageUtils;
import lotto.util.number.LottoNumberConst;
import lotto.util.number.LottoNumberFactory;
import lotto.util.ranking.LottoRanking;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoStoreTest {

    @Nested
    @DisplayName("BigInteger lottoAmount를 매개변수로 받는 생성자는")
    class BigIntegerConstructorTest {

        @ParameterizedTest
        @CsvSource(
                value = {
                    "1000:1",
                    "2000:2",
                    "3000:3",
                    "4000:4",
                    "5000:5",
                    "6000:6",
                    "7000:7"
                },
                delimiter = ':'
        )
        @DisplayName("만약 구입 수량을 입력받는다면 그 수량만큼 Lotto를 초기화한 뒤 LottoStore를 반환한다.")
        void constructor_test(String inputAmount, int lottosSize) {
            LottoStore lottoStore = new LottoStore(new LottoPurchaseAmount(inputAmount));

            Player player = LottoStoreTestUtils.findPlayer(lottoStore);
            List<Lotto> actualPlayerLottos = PlayerTestUtils.findPlayerLottos(player);

            assertThat(actualPlayerLottos.size()).isSameAs(lottosSize);
        }
    }

    @Nested
    @DisplayName("createWinningLotto 메소드는")
    class CreateWinningLottoMethodTest {

        private final LottoStore lottoStore = new LottoStore(new LottoPurchaseAmount("1000"));

        @ParameterizedTest
        @ValueSource(strings = {"1,2,3,4,5,6", "11,12,13,14,15,16"})
        @DisplayName("만약 6개의 중복되지 않은 유효한 숫자가 적합한 구분자로 구분된 당첨 번호가 주어지면 Lotto 형태로 저장한다.")
        void success_test(String validInputNumbers) {
            lottoStore.createWinningLotto(validInputNumbers);

            Lotto winningLotto = LottoStoreTestUtils.findWinningLotto(lottoStore);
            List<LottoNumber> numbers = LottoTestUtils.findNumbers(winningLotto);

            assertThat(numbers.size()).isSameAs(LottoNumberConst.NUMBER_SIZE);
        }

        @Nested
        @DisplayName("만약 입력 값의 길이가 11(한 자릿수 6 + 구분자 5)에서 17(두 자릿수 12 + 구분자 6) 사이의 유효한 값이 아니라면")
        class InvalidInputLengthNestedTest {

            @ParameterizedTest
            @ValueSource(strings = {"1,2,3,4,5", "12,23,34,21,24,123", "123,234,345,456,567,678"})
            @DisplayName("IllegalArgumentException 예외가 발생한다.")
            void invalid_input_length_exception_test(String invalidInput) {
                assertThatThrownBy(() -> lottoStore.createWinningLotto(invalidInput))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(LottoExceptionMessageUtils.INVALID_NUMBER_LENGTH
                                .findExceptionMessage(invalidInput.length()));
            }
        }

        @ParameterizedTest
        @ValueSource(strings = {"1:2:3:4:5:6", "111213141516", "1.2.3.4.5.6", "1@2@3@4@5@6"})
        @DisplayName("만약 유효한 구분자(,)가 오지 않은 경우 IllegalArgumentException 예외가 발생한다.")
        void invalid_separator_exception_test(String invalidInput) {
            assertThatThrownBy(() -> lottoStore.createWinningLotto(invalidInput))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(LottoExceptionMessageUtils.INVALID_SEPARATOR
                            .findExceptionMessage(invalidInput));
        }

        @ParameterizedTest
        @ValueSource(strings = {"1, 2, 3, 4, 5, 6", "1 , 2 , 3 , 4 , 5 , 6", "1,a,3,4,5,6", " ,2,3,4,5,6", "1, 2,3,4,5,6", "@,2,3,4,5,6"})
        @DisplayName("만약 입력 값을 숫자로 치환할 수 없다면 IllegalArgumentException 예외가 발생한다.")
        void invalid_number_format_exception_test(String invalidInput) {
            assertThatThrownBy(() -> lottoStore.createWinningLotto(invalidInput))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @ParameterizedTest
        @ValueSource(strings = {"0,1,2,3,4,5", "1,2,3,4,5,46"})
        @DisplayName("만약 입력한 숫자의 범위가 1 ~ 45 사이가 아니라면 IllegalArgumentException 예외가 발생한다.")
        void invalid_number_range_exception_test(String invalidInput) {
            assertThatThrownBy(() -> lottoStore.createWinningLotto(invalidInput))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(LottoExceptionMessageUtils.INVALID_NUMBER_RANGE
                            .findExceptionMessage(invalidInput));
        }

        @ParameterizedTest
        @CsvSource(
                value = {
                    "1,2,3,4,5:5",
                    "12,41,32,17,42,1,2:7"
                },
                delimiter = ':'
        )
        @DisplayName("만약 중복되지 않는 유효한 숫자가 6개가 아니라면 IllegalArgumentException 예외가 발생한다.")
        void invalid_number_count_exception_test(String wrongInputLottoNumber, int validNumberCount) {
            List<Integer> numbers = Arrays.stream(wrongInputLottoNumber.split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            assertThatThrownBy(() -> new Lotto(numbers))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(LottoExceptionMessageUtils.INVALID_NUMBER_SIZE
                            .findExceptionMessage(validNumberCount));
        }
    }

    @Nested
    @DisplayName("calculateLottoResult 메소드는")
    class CalculateLottoResultMethodTest {

        private final LottoNumber dummyBonusNumber = LottoNumberFactory.numberOf(1);

        @ParameterizedTest
        @MethodSource("lotto.domain.argument.LottoStoreTestArgument#calculateLottoResultArgument")
        @DisplayName("만약 보너스 점수가 주어진다면 당첨 등수를 계산한 결과를 LottoResult에 저장하고 반환한다.")
        void calculate_winning_ranking_result_test(List<LottoRanking> rankings,
                String amountInput, Map<LottoRanking, Integer> expectedMap) {
            LottoStore lottoStore = LottoStoreTestFactory.lottoRankingsLottoOf(rankings, amountInput);

            LottoResult lottoResult = lottoStore.calculateLottoResult(dummyBonusNumber);
            Map<LottoRanking, Integer> actualMap = LottoResultTestUtils.findLottoRankingResult(lottoResult);

            Arrays.stream(LottoRanking.values())
                    .forEach(lottoRanking ->
                            assertThat(actualMap.getOrDefault(lottoRanking, 0))
                                    .isSameAs(expectedMap.get(lottoRanking)));
        }
    }
}