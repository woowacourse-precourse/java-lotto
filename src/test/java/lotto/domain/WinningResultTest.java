package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningResultTest {
    private static List<List<Integer>> lotto;
    private static List<Integer> winningNumber;
    private static int bonuseNumber;
    private static WinningResult winningResult;

    @BeforeEach
    @DisplayName("초기 세팅")
    public void setUp() {
        lotto = Arrays.asList(
                List.of(20, 30, 12, 5, 3, 1, 4), List.of(5, 16, 23, 33, 24, 5),
                List.of(8, 21, 33, 42, 45, 3), List.of(11, 22, 33, 42, 14, 15),
                List.of(10, 20, 30, 40, 15, 16), List.of(1, 2, 3, 7, 5, 6),
                List.of(11, 21, 31, 41, 14, 2), List.of(14, 24, 34, 44, 23, 13)
        );
        winningNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
        bonuseNumber = 7;
        winningResult = new WinningResult(lotto);
    }

    @Test
    @DisplayName("로또 게임의 결과를 해쉬 맵으로 반환")
    void statistics() {
        LinkedHashMap<LottoRank, Integer> result = winningResult.getStatistics(winningNumber, bonuseNumber);
        System.out.println(result);
        assertThat(result)
                .matches(rank -> rank.get(LottoRank.THREE_MATCH) == 0)
                .matches(rank -> rank.get(LottoRank.FOUR_MATCH) == 1)
                .matches(rank -> rank.get(LottoRank.FIVE_MATCH_AND_BONUS_MATCH) == 1)
                .matches(rank -> rank.get(LottoRank.FIVE_MATCH) == 0)
                .matches(rank -> rank.get(LottoRank.SIX_MATCH) == 0);
    }

    @Test
    @DisplayName("수익률 계산")
    void revenueCalculation() {
        winningResult.getStatistics(winningNumber,bonuseNumber);
        float revenue = winningResult.revenueCalculation(1000);
        assertThat(revenue)
                .isPositive()
                .isEqualTo(3005000.0f);
    }
}