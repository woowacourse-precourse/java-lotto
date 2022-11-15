package lotto.domain.player;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.List;
import lotto.domain.number.Lotto;
import lotto.domain.number.LottoNumber;
import lotto.helper.stub.StubWinningLotto;
import lotto.helper.util.PlayerTestUtils;
import lotto.util.number.LottoNumberFactory;
import lotto.mvc.util.LottoRanking;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class PlayerTest {

    @Nested
    @DisplayName("LottoPurchaseAmount lottoPurchaseAmount를 매개변수로 받는 생성자는")
    class LottoPurchaseAmountConstructorTest {

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
        @DisplayName("만약 lottoPurchaseAmount가 주어지면 그 크기만큼 Lotto를 생성하고 초기화한 Player를 반환한다.")
        void success_test(String input, int size) {
            Player player = new Player(new LottoPurchaseAmount(input));

            List<Lotto> playerLottos = PlayerTestUtils.findPlayerLottos(player);

            assertThat(playerLottos.size()).isSameAs(size);
        }
    }

    @Nested
    @DisplayName("calculateLottoRanking 메소드는")
    class CalculateLottoRankingMethodTest {

        private final LottoNumber dummyBonusNumber = LottoNumberFactory.numberOf(1);

        @ParameterizedTest
        @MethodSource("lotto.domain.argument.PlayerTestArgument#calculateLottoGradeArgument")
        @DisplayName("만약 당첨 번호와 보너스 번호와 LottoResult가 주어지면 LottoResult에 당첨 결과를 계산한다.")
        void success_test(List<LottoRanking> rankings, String amountInput) {
            Player player = new Player(new LottoPurchaseAmount("2000"));
            Lotto winningLotto = new StubWinningLotto(rankings);

            List<LottoRanking> actualRankings = player.calculateLottoRanking(winningLotto, dummyBonusNumber);

            actualRankings.forEach(ranking -> assertThat(rankings).contains(ranking));
        }
    }

    @Nested
    @DisplayName("calculateRevenuePercent 메소드는")
    class CalculateRevenuePercentMethodTest {

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
        @DisplayName("만약 총 당첨 상금이 주어지면 수익률을 반환한다.")
        void success_test(String amountInput, String expectedRevenue) {
            Player player = new Player(new LottoPurchaseAmount(amountInput));

            BigDecimal actualRevenue = player.calculateRevenuePercent(BigDecimal.valueOf(5000L));

            assertThat(actualRevenue.toString()).isEqualTo(expectedRevenue);
        }
    }

    @Nested
    @DisplayName("toString 메소드는")
    class ToStringMethodTest {

        private final String purchaseLogFormat = "개를 구매했습니다.";

        @ParameterizedTest
        @ValueSource(strings = {"1000", "2000", "5000", "10000"})
        @DisplayName("만약 호출되면 List<Lotto>와 LottoPurchaseAmount를 정해진 규격에 따라 문자열로 반환한다.")
        void success_test(String input) {
            Player player = new Player(new LottoPurchaseAmount(input));

            String log = player.toString();

            assertThat(log).contains(purchaseLogFormat);
        }
    }
}