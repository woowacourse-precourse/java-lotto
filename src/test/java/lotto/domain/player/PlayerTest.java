package lotto.domain.player;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.IntStream;
import lotto.domain.game.LottoRanking;
import lotto.domain.number.Lotto;
import lotto.domain.number.LottoNumber;
import lotto.domain.player.exception.WrongGeneratorException;
import lotto.helper.stub.StubLotto;
import lotto.helper.stub.WrongNumbersGenerator;
import lotto.utils.consts.LottoConst;
import lotto.utils.message.ExceptionMessageUtil;
import lotto.utils.number.LottoNumberFactory;
import lotto.utils.number.LottoNumbersGenerator;
import lotto.utils.number.LottoUniqueNumbersGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class PlayerTest {

    private final LottoNumbersGenerator generator = new LottoUniqueNumbersGenerator(
            LottoConst.MIN_NUMBER_VALUE,
            LottoConst.MAX_NUMBER_VALUE);

    @Nested
    @DisplayName("String amountInput를 매개변수로 받는 생성자는")
    class DescribePlayerPurchaseAmountConstructorTest {

        @Nested
        @DisplayName("만약 유효한 로또 구매 금액 amountInput와 유효한 로또 숫자 생성 전략을 전달하면")
        class ContextWithPlayerPurchaseAmountAndGeneratorTest {

            @Test
            @DisplayName("PlayerPurchaseAmount를 초기화한 Player를 생성한다")
            void it_returns_Player() {
                assertThatCode(() -> new Player(new BigDecimal("1000"), generator))
                        .doesNotThrowAnyException();
            }
        }

        @Nested
        @DisplayName("만약 1000원 단위가 아닌 값과 유효한 로또 숫자 생성 전략을 전달하면")
        class ContextWithInvalidUnitAmountAndGeneratorTest {

            @ParameterizedTest
            @ValueSource(strings = {"10001", "10010", "10100"})
            @DisplayName("IllegalArgumentException 예외가 발생한다")
            void it_throws_exception(String invalidInput) {
                assertThatThrownBy(() -> new Player(new BigDecimal(invalidInput), generator))
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
                assertThatThrownBy(() -> new Player(new BigDecimal(invalidInput), generator))
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
                assertThatThrownBy(() -> new Player(new BigDecimal("1000"), wrongGenerator))
                        .isInstanceOf(WrongGeneratorException.class)
                        .hasMessageContaining(ExceptionMessageUtil.WRONG_NUMBER_RANGE.findFullMessage());
            }
        }
    }

    @Nested
    @DisplayName("calculateLottoRanking 메소드는")
    class DescribeCalculateLottoRankingMethodTest {

        @Nested
        @DisplayName("만약 당첨 번호와 보너스 번호가 주어지면")
        class ContextWithBonusNumberAndLottoResultTest {

            private final LottoNumber bonusNumber = LottoNumberFactory.numberOf(1);

            @ParameterizedTest
            @MethodSource("lotto.domain.player.arguments.PlayerTestArgument#calculateLottoRankingArgument")
            @DisplayName("로또 당첨 등수 LottoRanking을 반환한다")
            void it_returns_lottoRanking(List<LottoRanking> rankings, String input) {
                Player player = new Player(new BigDecimal(input), generator);
                Lotto winningLotto = new StubLotto(rankings);

                List<LottoRanking> actualRankings = player.calculateLottoRanking(winningLotto, bonusNumber);

                assertThat(actualRankings)
                        .hasSize(rankings.size())
                        .hasSameElementsAs(rankings);
            }
        }
    }

    @Nested
    @DisplayName("calculateRevenuePercent 메소드는")
    class DescribeCalculateRevenuePercentMethodTest {

        @Nested
        @DisplayName("당첨된 총 상금 TotalReward가 주어지면")
        class ContextWithTotalRewardTest {

            @ParameterizedTest
            @CsvSource(
                    value = {
                        "1000:500.0",
                        "2000:250.0",
                        "3000:166.7",
                        "4000:125.0",
                        "5000:100.0"
                    },
                    delimiter = ':'
            )
            @DisplayName("수익률을 반환한다")
            void it_returns_revenuePercent(String input, String expected) {
                Player player = new Player(new BigDecimal(input), generator);

                BigDecimal actualRevenue = player.calculateRevenuePercent(BigDecimal.valueOf(5000L));

                assertThat(actualRevenue.toString()).isEqualTo(expected);
            }
        }
    }

    @Nested
    @DisplayName("getPurchaseLottos 메소드는")
    class DescribeGetPurchaseLottosMethodTest {

        @Nested
        @DisplayName("만약 호출하면")
        class ContextWithoutParameterTest {

            private static final String LOTTO_MESSAGE_SEPARATOR = ", ";

            @ParameterizedTest
            @CsvSource(
                    value = {
                        "1000:1",
                        "2000:2",
                        "5000:5",
                        "10000:10"
                    },
                    delimiter = ':'
            )
            @DisplayName("플레이어가 구매한 로또 묶음을 오름차순으로 반환한다")
            void it_returns_sortedLottos(String input, int expectedSize) {
                Player player = new Player(new BigDecimal(input), generator);

                List<String> purchaseLottos = player.getPurchaseLottos();

                assertThat(purchaseLottos.size()).isSameAs(expectedSize);
                IntStream.range(0, purchaseLottos.size() - 1)
                        .forEach(i -> sortedTest(purchaseLottos.get(i).split(LOTTO_MESSAGE_SEPARATOR)));
            }

            private void sortedTest(String[] lottos) {
                IntStream.range(0, lottos.length - 1)
                        .forEach(i -> {
                            int first = Integer.parseInt(lottos[i]);
                            int second = Integer.parseInt(lottos[i + 1]);

                            assertThat(first).isLessThan(second);
                        });
            }
        }
    }
}