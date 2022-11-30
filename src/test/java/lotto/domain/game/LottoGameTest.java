package lotto.domain.game;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.math.BigDecimal;
import java.util.List;
import lotto.domain.number.LottoNumber;
import lotto.domain.player.Player;
import lotto.domain.player.exception.WrongGeneratorException;
import lotto.helper.stub.StubNumbersGenerator;
import lotto.helper.stub.WrongNumbersGenerator;
import lotto.utils.consts.LottoConst;
import lotto.utils.message.ExceptionMessageUtil;
import lotto.utils.number.LottoNumberFactory;
import lotto.utils.number.LottoNumbersGenerator;
import lotto.utils.number.LottoUniqueNumbersGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoGameTest {

    @Nested
    @DisplayName("BigInteger lottoAmount, LottoNumbersGenerator generator를 매개변수로 받는 생성자는")
    class DescribeBigIntegerAndLottoNumbersGeneratorConstructorTest extends CommonGeneratorField {

        @Nested
        @DisplayName("만약 플레이어가 구매한 로또의 수량 lottoAmount과 generator가 주어지면")
        class ContextWithLottoAmountAndGeneratorTest {

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
            @DisplayName("Player를 초기화한 LottoGame을 생성한다")
            void it_returns_lottoGame(String input, int expected) {
                LottoGame lottoGame = new LottoGame(input, generator);

                List<String> playerPurchaseLottos = lottoGame.getPlayerPurchaseLottos();

                assertThat(playerPurchaseLottos.size()).isSameAs(expected);
            }
        }

        @Nested
        @DisplayName("만약 숫자가 아닌 로또 금액 입력 amountInput와 유효한 로또 숫자 생성 전략을 전달하면")
        class ContextWithInvalidNumberFormatAndGeneratorTest {

            @ParameterizedTest
            @ValueSource(strings = {"a", "a00", "@", " 123"})
            @DisplayName("IllegalArgumentException 예외가 발생한다")
            void it_throws_exception(String invalidInput) {
                assertThatThrownBy(() -> new Player(invalidInput, generator))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ExceptionMessageUtil.WRONG_NUMBER_FORMAT.findFullMessage());
            }
        }

        @Nested
        @DisplayName("만약 1000원 단위가 아닌 값과 유효한 로또 숫자 생성 전략을 전달하면")
        class ContextWithInvalidUnitAmountAndGeneratorTest {

            @ParameterizedTest
            @ValueSource(strings = {"10001", "10010", "10100"})
            @DisplayName("IllegalArgumentException 예외가 발생한다")
            void it_throws_exception(String invalidInput) {
                assertThatThrownBy(() -> new Player(invalidInput, generator))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ExceptionMessageUtil.WRONG_PURCHASE_AMOUNT_UNIT.findFullMessage());
            }
        }

        @Nested
        @DisplayName("만약 1000원 이하의 값과 유효한 로또 숫자 생성 전략을 전달하면")
        class ContextWithInvalidMinAmountAndGeneratorTest {

            @ParameterizedTest
            @ValueSource(strings = {"900", "80", "1", "-1000"})
            @DisplayName("IllegalArgumentException 예외가 발생한다")
            void it_throws_exception(String invalidInput) {
                assertThatThrownBy(() -> new Player(invalidInput, generator))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ExceptionMessageUtil.WRONG_PURCHASE_AMOUNT_VALUE.findFullMessage());
            }
        }

        @Nested
        @DisplayName("만약 유효한 구매 금액과 유효하지 않은 로또 숫자 생성 전략을 전달하면")
        class ContextWithAmountAndInvalidGeneratorTest {

            private final LottoNumbersGenerator wrongGenerator = new WrongNumbersGenerator();

            @Test
            @DisplayName("WrongGeneratorException 예외가 발생한다")
            void it_throws_exception() {
                assertThatThrownBy(() -> new Player("1000", wrongGenerator))
                    .isInstanceOf(WrongGeneratorException.class)
                    .hasMessageContaining(ExceptionMessageUtil.WRONG_NUMBER_RANGE.findFullMessage());
            }
        }
    }

    @Nested
    @DisplayName("createWinningLotto 메소드는")
    class DescribeCreateWinningLottoMethodTest extends CommonLottoGameField {

        @Nested
        @DisplayName("만약 유효한 당첨 숫자를 전달하면")
        class ContextWithWinningLottoTest {

            @ParameterizedTest
            @ValueSource(strings = {"1,2,3,4,5,6", "11,12,13,14,15,16"})
            @DisplayName("winningLotto를 초기화한다")
            void it_init_winningLotto(String input) {
                assertThatCode(() -> lottoGame.createWinningLotto(input)).doesNotThrowAnyException();
            }
        }

        @Nested
        @DisplayName("만약 길이가 11에서 17 사이의 유효하지 않은 입력이 주어지면")
        class ContextWithInvalidNumbersLengthTest {

            @ParameterizedTest
            @ValueSource(strings = {"1,2,3,4,5", "12,23,34,21,24,123", "123,234,345,456,567,678"})
            @DisplayName("IllegalArgumentException 예외가 발생한다.")
            void it_throws_exception(String invalidInput) {
                assertThatThrownBy(() -> lottoGame.createWinningLotto(invalidInput))
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
                assertThatThrownBy(() -> lottoGame.createWinningLotto(invalidInput))
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
                assertThatThrownBy(() -> lottoGame.createWinningLotto(invalidInput))
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
                assertThatThrownBy(() -> lottoGame.createWinningLotto(invalidInput))
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
                assertThatThrownBy(() -> lottoGame.createWinningLotto(invalidInput))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(ExceptionMessageUtil.WRONG_NUMBER_SIZE.findFullMessage());
            }
        }
    }

    @Nested
    @DisplayName("calculateLottoResult 메소드는")
    class DescribeCalculateLottoResultMethodTest {

        private final LottoNumbersGenerator generator = new StubNumbersGenerator();
        private LottoGame lottoGame = new LottoGame("1000", generator);

        @BeforeEach
        void initLottoGame() {
            LottoNumbersGenerator generator = new StubNumbersGenerator();
            lottoGame = new LottoGame("1000", generator);
            lottoGame.createWinningLotto("1,2,3,4,5,6");
        }

        @Nested
        @DisplayName("만약 유효한 보너스 번호를 전달하면")
        class ContextWithBonusNumberTest {

            @Test
            @DisplayName("로또 당첨 결과를 계산해 LottoResult를 반환한다")
            void it_returns_lottoResult() {
                LottoNumber bonusNumber = LottoNumberFactory.numberOf(7);

                assertThatCode(() -> lottoGame.calculateLottoResult(bonusNumber)).doesNotThrowAnyException();
            }
        }

        @Nested
        @DisplayName("만약 당첨 번호와 중복된 보너스 번호를 전달하면")
        class ContextWithInvalidBonusNumberTest {

            @Test
            @DisplayName("IllegalArgumentException 예외가 발생한다")
            void it_returns_lottoResult() {
                LottoNumber bonusNumber = LottoNumberFactory.numberOf(1);

                assertThatThrownBy(() -> lottoGame.calculateLottoResult(bonusNumber))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(ExceptionMessageUtil.WRONG_BONUS_NUMBER.findFullMessage());
            }
        }
    }

    @Nested
    @DisplayName("calculateRevenuePercent 메소드는")
    class DescribeCalculateRevenuePercentMethodTest extends CommonLottoGameField {

        @Nested
        @DisplayName("만약 총 당첨 상금 totalReward가 주어지면")
        class ContextWithBigDecimalTest {

            @ParameterizedTest
            @CsvSource(
                    value = {
                        "50000:5000.0",
                        "10000:1000.0"
                    },
                    delimiter = ':'
            )
            @DisplayName("수익률을 계산해 반환한다")
            void it_returns_revenuePercent(String totalReward, String expected) {
                BigDecimal actual = lottoGame.calculateRevenuePercent(new BigDecimal(totalReward));

                assertThat(actual.toString()).contains(expected);
            }
        }
    }

    private class CommonGeneratorField {

        protected final LottoNumbersGenerator generator = new LottoUniqueNumbersGenerator(
                LottoConst.MIN_NUMBER_VALUE,
                LottoConst.MAX_NUMBER_VALUE);
    }

    private class CommonLottoGameField extends CommonGeneratorField {

        protected final LottoGame lottoGame = new LottoGame("1000", generator);
    }
}