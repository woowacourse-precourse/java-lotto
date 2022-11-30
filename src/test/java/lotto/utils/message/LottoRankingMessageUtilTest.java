package lotto.utils.message;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.game.LottoRanking;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoRankingMessageUtilTest {

    @Nested
    @DisplayName("findExceptionMessage 메소드는")
    class DescribeFindExceptionMessageMethodTest {

        @Nested
        @DisplayName("만약 로또 등수 lottoRanking와 로또 등수 당첨 횟수 numberOfWins를 전달하면")
        class ContextWithLottoRankingANdNumberOfWinsTest {

            @ParameterizedTest
            @CsvSource(
                value = {
                    "FIRST:1:6개 일치 (2,000,000,000원) - 1개",
                    "SECOND:2:5개 일치, 보너스 볼 일치 (30,000,000원) - 2개",
                    "THIRD:3:5개 일치 (1,500,000원) - 3개",
                    "FOURTH:4:4개 일치 (50,000원) - 4개",
                    "FIFTH:5:3개 일치 (5,000원) - 5개"
                },
                delimiter = ':'
            )
            @DisplayName("해당 로또 등수의 결과를 반환한다")
            void it_returns_lottoResultMessage(LottoRanking lottoRanking, int numberOfWins, String expectedMessage) {
                String actualMessage = LottoRankingMessageUtil.findLottoRankingMessage(lottoRanking, numberOfWins);

                assertThat(actualMessage).isEqualTo(expectedMessage);
            }
        }

        @Nested
        @DisplayName("만약 LottoRanking.NOTHING이 주어지면")
        class ContextWithInvalidLottoRankingTest {

            @Test
            @DisplayName("만약 LottoRanking.NOTHING이 주어지면 IllegalArgumentException 예외가 발생한다.")
            void exception_test() {
                assertThatThrownBy(() -> LottoRankingMessageUtil
                        .findLottoRankingMessage(LottoRanking.NOTHING, 0))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("존재하지 않는 등수입니다.");
            }
        }
    }
}