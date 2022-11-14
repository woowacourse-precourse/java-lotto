package lotto.mvc.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import lotto.domain.number.Lotto;
import lotto.domain.number.LottoNumber;
import lotto.domain.player.LottoPurchaseAmount;
import lotto.domain.player.Player;
import lotto.helper.stub.StubWinningLotto;
import lotto.helper.util.LottoResultTestUtils;
import lotto.util.number.LottoNumberFactory;
import lotto.mvc.util.LottoRanking;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class LottoResultTest {

    private final LottoNumber dummyBonusNumber = LottoNumberFactory.numberOf(1);

    @Nested
    @DisplayName("Player player, Lotto winningLotto, LottoNumber bonusNumber를 매개변수로 받는 생성자는")
    class PlayerLottoLottoNumberConstructorTest {

        @ParameterizedTest
        @MethodSource("lotto.domain.argument.LottoResultTestArgument#lottoResultConstructorTestArgument")
        @DisplayName("만약 player, winningLotto, bonusNumber를 입력하면 로또 당첨 등수와 수익률을 계산해 LottoResult로 반환한다.")
        void success_test(String amountInput,
                List<LottoRanking> rankings, Map<LottoRanking, Integer> expectedRankingResult, String revenuePercent) {
            Player player = new Player(new LottoPurchaseAmount(amountInput));
            StubWinningLotto winningLotto = new StubWinningLotto(rankings);

            LottoResult lottoResult = new LottoResult(player, winningLotto, dummyBonusNumber);

            Map<LottoRanking, Integer> actualRankingResult = LottoResultTestUtils.findLottoRankingResult(lottoResult);
            BigDecimal actualRevenuePercent = LottoResultTestUtils.findRevenuePercent(lottoResult);

            Arrays.stream(LottoRanking.values())
                    .filter(lottoRanking -> lottoRanking != LottoRanking.RANKING_NOTHING)
                    .forEach(lottoRanking -> assertThat(actualRankingResult.getOrDefault(lottoRanking, 0))
                            .isSameAs(expectedRankingResult.getOrDefault(lottoRanking, 0)));

            assertThat(actualRevenuePercent.toString()).isEqualTo(revenuePercent);
        }
    }

    @Nested
    @DisplayName("toString 메소드는")
    class ToStringMethodTest {

        @Test
        @DisplayName("만약 호출되면 주어진 순서대로 당첨 통계 문자열을 반환한다.")
        void success_test() {
            Player player = new Player(new LottoPurchaseAmount("1000"));
            Lotto winningLotto = new Lotto("1,2,3,4,5,6");
            LottoResult lottoResult = new LottoResult(player, winningLotto, dummyBonusNumber);

            String actualMessage = lottoResult.toString();

            assertThat(actualMessage)
                    .contains("당첨 통계")
                    .contains("---")
                    .contains("3개 일치 (5,000원) -")
                    .contains("4개 일치 (50,000원) -")
                    .contains("5개 일치 (1,500,000원) -")
                    .contains("5개 일치, 보너스 볼 일치 (30,000,000원) -")
                    .contains("6개 일치 (2,000,000,000원) -");
        }
    }
}