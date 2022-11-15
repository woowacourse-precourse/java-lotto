package lotto.mvc.util.message;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.common.CommonExceptionTest;
import lotto.mvc.util.LottoRanking;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoRankingMessageUtilsTest {

    @Nested
    @DisplayName("findLottoRankingMessage 메소드는")
    class FindLottoRankingMessageMethodTest extends CommonExceptionTest {

        @ParameterizedTest
        @CsvSource(
                value = {
                    "RANKING_FIRST:1:6개 일치 (2,000,000,000원) - 1개",
                    "RANKING_SECOND:2:5개 일치, 보너스 볼 일치 (30,000,000원) - 2개",
                    "RANKING_THIRD:3:5개 일치 (1,500,000원) - 3개",
                    "RANKING_FOURTH:4:4개 일치 (50,000원) - 4개",
                    "RANKING_FIFTH:5:3개 일치 (5,000원) - 5개"
                },
                delimiter = ':'
        )
        @DisplayName("만약 LottoRaking.NOTHING을 제외한 나머지가 주어지면 그에 맞는 메세지를 반환한다.")
        void success_test(LottoRanking lottoRanking, int numberOfWins, String expectedMessage) {
            String actualMessage = LottoRankingMessageUtils.findLottoRankingMessage(lottoRanking, numberOfWins);

            assertThat(actualMessage).isEqualTo(expectedMessage);
        }

        @Test
        @DisplayName("만약 LottoRanking.NOTHING이 주어지면 IllegalArgumentException 예외가 발생한다.")
        void exception_test() {
            assertIllegalArgumentExceptionWithMessage(() -> LottoRankingMessageUtils.
                    findLottoRankingMessage(LottoRanking.RANKING_NOTHING, 0),
                    "[ERROR] 존재하지 않는 등수입니다. 입력 값 : RANKING_NOTHING");
        }
    }
}