package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.EnumMap;
import java.util.Map;
import lotto.helper.factory.LottoResultTestFactory;
import lotto.helper.util.LottoResultTestUtils;
import lotto.util.ranking.LottoRanking;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;

class LottoResultTest {

    @Nested
    @DisplayName("addRankingCount 메소드는")
    class AddRankCountMethodTest {

        private static final int ADD_VALUE = 1;

        @ParameterizedTest
        @EnumSource(
                names = {
                    "RANKING_FIRST",
                    "RANKING_SECOND",
                    "RANKING_THIRD",
                    "RANKING_FOURTH",
                    "RANKING_FIFTH",
                    "RANKING_NOTHING"
                }
        )
        @DisplayName("만약 해당 등수의 당첨 횟수가 존재하지 않는다면 해당 등수의 당첨 횟수을 1로 초기화한다.")
        void default_init_count_test(LottoRanking lottoRanking) {
            LottoResult lottoResult = new LottoResult();
            lottoResult.addRankingCount(lottoRanking);

            Map<LottoRanking, Integer> lottoRankingResult = LottoResultTestUtils.findLottoRankingResult(lottoResult);

            assertThat(lottoRankingResult.get(lottoRanking)).isSameAs(ADD_VALUE);
        }

        @ParameterizedTest
        @CsvSource(
                value = {
                    "RANKING_FIRST:1",
                    "RANKING_SECOND:3",
                    "RANKING_THIRD:5",
                    "RANKING_FOURTH:7",
                    "RANKING_FIFTH:9"
                },
                delimiter = ':'
        )
        @DisplayName("만약 해당 등수의 당첨 횟수가 존재한다면 기존 당첨 횟수에 1을 더한다.")
        void add_ranking_count_test(LottoRanking lottoRanking, int numberOfWins) {
            Map<LottoRanking, Integer> lottoRankingMap = new EnumMap<>(LottoRanking.class);
            lottoRankingMap.put(lottoRanking, numberOfWins);
            LottoResult lottoResult = LottoResultTestFactory.lottoRankingResultOf(lottoRankingMap);

            lottoResult.addRankingCount(lottoRanking);
            Map<LottoRanking, Integer> lottoRankingResult = LottoResultTestUtils.findLottoRankingResult(lottoResult);

            assertThat(lottoRankingResult.get(lottoRanking)).isSameAs(numberOfWins + ADD_VALUE);
        }
    }

    @Nested
    @DisplayName("calculateTotalReward 메소드는")
    class CalculateTotalRewardMethodTest {

        @ParameterizedTest
        @CsvSource(
                value = {
                    "RANKING_FIRST:1",
                    "RANKING_SECOND:3",
                    "RANKING_THIRD:5",
                    "RANKING_FOURTH:7",
                    "RANKING_FIFTH:9"
                },
                delimiter = ':'
        )
        @DisplayName("만약 호출되면 당첨 등수의 모든 상금 합을 계산해 반환한다.")
        void test(LottoRanking lottoRanking, int numberOfWins) {
            Map<LottoRanking, Integer> lottoRankingMap = new EnumMap<>(LottoRanking.class);
            lottoRankingMap.put(lottoRanking, numberOfWins);
            LottoResult lottoResult = LottoResultTestFactory.lottoRankingResultOf(lottoRankingMap);

            BigDecimal totalReward = lottoResult.calculateTotalReward();

            assertThat(totalReward).isEqualTo(lottoRanking.calculateTotalTargetLottoRankingReward(numberOfWins));
        }
    }
}