package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static lotto.Calculate.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class CalculateTest {

    @Test
    @DisplayName("수익률을 계산하는 기능")
    void getProfitRateTest() {
        String profitRate = getProfitRate(10000, 7650);
        assertThat(profitRate).isEqualTo("76.5");
    }

    @Nested
    @DisplayName("비교결과를 바탕으로 당첨 결과에 해당하는 인덱스를 리턴하는 기능")
    class winningCountAndBonusNumberToIdx {
        @Test
        @DisplayName("3개 일치")
        void winThree() {
            int idx = winningCountAndBonusNumberToIdx(3, false);
            assertThat(idx).isEqualTo(0);
        }

        @Test
        @DisplayName("4개 일치")
        void winFour() {
            int idx = winningCountAndBonusNumberToIdx(4, false);
            assertThat(idx).isEqualTo(1);
        }

        @Test
        @DisplayName("5개 일치")
        void winFive() {
            int idx = winningCountAndBonusNumberToIdx(5, false);
            assertThat(idx).isEqualTo(2);
        }

        @Test
        @DisplayName("5개 일치 + 보너스 번호 일치")
        void winFiveAndBonus() {
            int idx = winningCountAndBonusNumberToIdx(5, true);
            assertThat(idx).isEqualTo(3);
        }

        @Test
        @DisplayName("6개 일치")
        void winSix() {
            int idx = winningCountAndBonusNumberToIdx(6, false);
            assertThat(idx).isEqualTo(4);
        }
    }

    @Nested
    @DisplayName("당첨 결과를 idx에 맞춰 배열에 담는 기능")
    class getWinningResult {

        @Test
        @DisplayName("3개 일치")
        void winThree() {
            List<Lotto> lottos = List.of(
                    new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6))
            );
            List<Integer> winningNumbers = List.of(1, 2, 3, 7, 8, 9);
            long[] winningResult = getWinningResult(lottos, winningNumbers, 10);
            assertThat(winningResult).isEqualTo(new long[]{1,0,0,0,0});
        }

        @Test
        @DisplayName("4개 일치")
        void winFour() {
            List<Lotto> lottos = List.of(
                    new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6))
            );
            List<Integer> winningNumbers = List.of(1, 2, 3, 4, 8, 9);
            long[] winningResult = getWinningResult(lottos, winningNumbers, 10);
            assertThat(winningResult).isEqualTo(new long[]{0,1,0,0,0});
        }


        @Test
        @DisplayName("5개 일치")
        void winFive() {
            List<Lotto> lottos = List.of(
                    new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6))
            );
            List<Integer> winningNumbers = List.of(1, 2, 3, 5, 6, 9);
            long[] winningResult = getWinningResult(lottos, winningNumbers, 10);
            assertThat(winningResult).isEqualTo(new long[]{0,0,1,0,0});
        }


        @Test
        @DisplayName("5개 일치 + 보너스 번호 일치")
        void winFiveAndBonus() {
            List<Lotto> lottos = List.of(
                    new Lotto(Arrays.asList(1, 2, 3, 4, 5, 10))
            );
            List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
            long[] winningResult = getWinningResult(lottos, winningNumbers, 10);
            assertThat(winningResult).isEqualTo(new long[]{0,0,0,1,0});
        }


        @Test
        @DisplayName("6개 일치")
        void winSix() {
            List<Lotto> lottos = List.of(
                    new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6))
            );
            List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
            long[] winningResult = getWinningResult(lottos, winningNumbers, 10);
            assertThat(winningResult).isEqualTo(new long[]{0,0,0,0,1});
        }
    }

    @Test
    @DisplayName("당첨 결과를 계산하는 기능")
    void winAll() {
        Map<LottoMatch, Long> winningDetails = Map.of(LottoMatch.THREE, 1L, LottoMatch.FOUR, 1L, LottoMatch.FIVE, 1L, LottoMatch.FIVE_BONUS, 1L, LottoMatch.SIX, 1L);
        List<Lotto> lottos = List.of(
                new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 8, 9)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 9)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 10)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6))
        );
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        Map<LottoMatch, Long> myWinningDetails = getWinningDetails(lottos, winningNumbers, 10);

        assertThat(winningDetails.values().toString()).isEqualTo(myWinningDetails.values().toString());
    }
}