package lotto.domain.player;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.IntStream;
import lotto.domain.game.LottoRanking;
import lotto.domain.number.Lotto;
import lotto.domain.number.LottoNumber;
import lotto.helper.stub.StubLotto;
import lotto.utils.consts.LottoConst;
import lotto.utils.number.LottoNumberFactory;
import lotto.utils.number.LottoNumbersGenerator;
import lotto.utils.number.LottoUniqueNumbersGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

class PlayerTest {

    @Nested
    @DisplayName("String amountInput를 매개변수로 받는 생성자는")
    class DescribePlayerPurchaseAmountConstructorTest {

        @Nested
        @DisplayName("만약 로또 구매 금액 amountInput을 전달하면")
        class ContextWithPlayerPurchaseAmountTest {

            @Test
            @DisplayName("Player를 생성한다")
            void it_returns_Player() {
                LottoNumbersGenerator generator = new LottoUniqueNumbersGenerator(
                        LottoConst.MIN_NUMBER_VALUE,
                        LottoConst.MAX_NUMBER_VALUE);

                assertThatCode(() -> new Player("1000", generator))
                        .doesNotThrowAnyException();
            }
        }
    }

    @Nested
    @DisplayName("calculateLottoRanking 메소드는")
    class DescribeCalculateLottoRankingMethodTest extends CommonGeneratorField {

        @Nested
        @DisplayName("만약 당첨 번호와 보너스 번호가 주어지면")
        class ContextWithBonusNumberAndLottoResultTest {

            private final LottoNumber bonusNumber = LottoNumberFactory.numberOf(1);

            @ParameterizedTest
            @MethodSource("lotto.domain.player.arguments.PlayerTestArgument#calculateLottoRankingArgument")
            @DisplayName("로또 당첨 등수 LottoRanking을 반환한다")
            void it_returns_lottoRanking(List<LottoRanking> rankings, String input) {
                Player player = new Player(input, generator);
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
    class DescribeCalculateRevenuePercentMethodTest extends CommonGeneratorField {

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
                Player player = new Player(input, generator);

                BigDecimal actualRevenue = player.calculateRevenuePercent(BigDecimal.valueOf(5000L));

                assertThat(actualRevenue.toString()).isEqualTo(expected);
            }
        }
    }

    @Nested
    @DisplayName("getPurchaseLottos 메소드는")
    class DescribeGetPurchaseLottosMethodTest extends CommonGeneratorField {

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
                Player player = new Player(input, generator);

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

    private class CommonGeneratorField {

        protected final LottoNumbersGenerator generator = new LottoUniqueNumbersGenerator(
                LottoConst.MIN_NUMBER_VALUE,
                LottoConst.MAX_NUMBER_VALUE);
    }
}