package lotto.domain.game;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import lotto.domain.number.LottoNumber;
import lotto.domain.player.Player;
import lotto.helper.stub.StubLotto;
import lotto.utils.consts.LottoConst;
import lotto.utils.number.LottoNumberFactory;
import lotto.utils.number.LottoNumbersGenerator;
import lotto.utils.number.LottoUniqueNumbersGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class LottoResultTest {

    @Nested
    @DisplayName("Player player, Lotto winningLotto, LottoNumber bonusNumber를 매개변수로 받는 생성자는")
    class DescribePlayerAndWinningLottoAndBonusNumberConstructorTest {

        @Nested
        @DisplayName("만약 player, winningLotto, bonusNumber를 전달하면")
        class ContextWithPlayerAndWinningLottoAndBonusNumberTest {

            private final LottoNumbersGenerator generator = new LottoUniqueNumbersGenerator(
                    LottoConst.MIN_NUMBER_VALUE,
                    LottoConst.MAX_NUMBER_VALUE);

            private final LottoNumber bonusNumber = LottoNumberFactory.numberOf(1);

            @ParameterizedTest
            @MethodSource("lotto.domain.game.arguments.LottoResultTestArgument#lottoResultConstructorTestArgument")
            @DisplayName("당첨 결과와 수익률을 계산해 LottoResult를 생성한다")
            void it_returns_lottoResult(List<LottoRanking> rankings,
                    Map<LottoRanking, Integer> expectedRankingResult, String revenuePercent) {
                Player player = new Player("10000", generator);
                StubLotto winningLotto = new StubLotto(rankings);
                LottoResult lottoResult = new LottoResult(player, winningLotto, bonusNumber);

                lottoResultConstructorRankingsTest(expectedRankingResult, lottoResult.getLottoRankingResult());
                assertThat(lottoResult.getRevenuePercent()).isEqualTo(revenuePercent);
            }

            private void lottoResultConstructorRankingsTest(Map<LottoRanking, Integer> expectedRankingResult,
                    Map<LottoRanking, Integer> actualRankings) {
                Arrays.stream(LottoRanking.values())
                        .filter(lottoRanking -> lottoRanking != LottoRanking.NOTHING)
                        .forEach(lottoRanking -> assertThat(actualRankings.getOrDefault(lottoRanking, 0))
                                .isSameAs(expectedRankingResult.getOrDefault(lottoRanking, 0)));
            }
        }
    }
}