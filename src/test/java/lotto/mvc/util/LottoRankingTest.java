package lotto.mvc.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import lotto.helper.util.LottoRankingTestUtils;
import lotto.mvc.util.LottoRanking;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;

class LottoRankingTest {

    @Nested
    @DisplayName("findRewardMessage 메소드는")
    class FindRewardMessageMethodTest {

        private static final String OPEN_BRACKET = "(";
        private static final String CLOSE_BRACKET = ")";
        private static final String AMOUNT_UNIT = ",";

        @ParameterizedTest
        @EnumSource(names = {"RANKING_FIRST", "RANKING_SECOND", "RANKING_THIRD", "RANKING_FOURTH", "RANKING_FIFTH"})
        @DisplayName("만약 호출하면 해당 LottoRanking의 상금을 정해진 포맷대로 변환해 문자열로 출력한다.")
        void lotto_ranking_reward_formatting_test(LottoRanking lottoRanking) {
            String message = lottoRanking.findRewardMessage();

            assertThat(message)
                    .contains(OPEN_BRACKET)
                    .contains(CLOSE_BRACKET)
                    .contains(AMOUNT_UNIT);
        }
    }

    @Nested
    @DisplayName("calculateTotalTargetLottoRankingReward 메소드는")
    class CalculateTotalTargetLottoRankingRewardMethodTest {

        private static final int DEFAULT_NUMBER_OF_WINS = 1;

        @ParameterizedTest
        @EnumSource(names = {"RANKING_FIRST", "RANKING_SECOND", "RANKING_THIRD", "RANKING_FOURTH", "RANKING_FIFTH"})
        @DisplayName("만약 당첨 횟수가 주어지면 총 상금을 계산해 반환한다.")
        void success_test(LottoRanking lottoRanking) {
            BigDecimal result = lottoRanking.calculateTotalTargetLottoRankingReward(DEFAULT_NUMBER_OF_WINS);

            assertThat(result).isEqualTo(LottoRankingTestUtils.findLottoGradeReward(lottoRanking));
        }
    }

    @Nested
    @DisplayName("findLottoGrade 메소드는")
    class FindLottoGradeMethodTest {

        @ParameterizedTest
        @CsvSource(
                value = {
                    "0:true:RANKING_NOTHING",
                    "0:false:RANKING_NOTHING",
                    "1:true:RANKING_NOTHING",
                    "1:false:RANKING_NOTHING",
                    "2:true:RANKING_NOTHING",
                    "2:false:RANKING_NOTHING",
                    "3:true:RANKING_FIFTH",
                    "3:false:RANKING_FIFTH",
                    "4:true:RANKING_FOURTH",
                    "4:false:RANKING_FOURTH",
                    "5:false:RANKING_THIRD",
                    "5:true:RANKING_SECOND",
                    "6:true:RANKING_FIRST",
                    "6:false:RANKING_FIRST"
                },
                delimiter = ':'
        )
        @DisplayName("만약 당첨 횟수와 보너스 점수 일치 유무가 주어지면 그에 맞는 등수를 반환한다.")
        void success_test(int correctNumberCount, boolean isCorrectBonusNumber, LottoRanking lottoRanking) {
            LottoRanking result = LottoRanking.findLottoRanking(correctNumberCount, isCorrectBonusNumber);

            assertThat(result).isSameAs(lottoRanking);
        }
    }
}