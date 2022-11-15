package lotto;

import lotto.domain.WinningsCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningsCalculatorTest {
    List<Integer> winningNumbers = List.of(8, 10, 2, 1, 5, 7);
    int bonusNumber = 40;
    WinningsCalculator winningsCalculator = new WinningsCalculator(winningNumbers, bonusNumber);

    @DisplayName("숫자 리스트와 타겟 숫자가 일치 여부 확인 - 성공")
    @Test
    void isExistentNumber_Success() {
        List<Integer> numbers = List.of(8, 10, 2, 1, 5, 7);
        int targetNumber = 7;
        assertThat(winningsCalculator.isExistentNumber(numbers, targetNumber))
                .isTrue();
    }

    @DisplayName("숫자 리스트와 타겟 숫자가 일치 여부 확인 - 실패")
    @Test
    void isExistentNumber_Fail() {
        List<Integer> numbers = List.of(8, 10, 2, 1, 5, 7);
        int targetNumber = 13;
        assertThat(winningsCalculator.isExistentNumber(numbers, targetNumber))
                .isFalse();
    }

    @DisplayName("당첨 번호와 일치하는 개수 세기")
    @Test
    void countMatchingWinningNumbersTest() {
        List<Integer> lottoNumbers = List.of(2, 3, 5, 7, 10, 40);
        int matchingCount = 4;
        assertThat(winningsCalculator.countMatchingWinningNumbers(lottoNumbers))
                .isEqualTo(matchingCount);
    }

    @DisplayName("보너스 번호와 일치하는 개수 세기")
    @Test
    void countMatchingBonusNumbersTest() {
        List<Integer> lottoNumbers = List.of(7, 2, 5, 3, 10, 41);
        int matchingCount = 0;
        assertThat(winningsCalculator.countMatchingBonusNumbers(lottoNumbers))
                .isEqualTo(matchingCount);
    }

    @DisplayName("등수 찾기")
    @Test
    void addRankingCountsTest() {
        Map<String, Integer> rankingCounts = new HashMap<>() {
            {
                put("FIRST_PLACE", 0);
                put("SECOND_PLACE", 0);
                put("THIRD_PLACE", 0);
                put("FOURTH_PLACE", 0);
                put("FIFTH_PLACE", 0);
            }
        };
        int winningCount = 5;
        int bonusCount = 0;
        winningsCalculator.addRankingCounts(rankingCounts, winningCount, bonusCount);
        assertThat(rankingCounts.get("THIRD_PLACE"))
                .isEqualTo(1);
    }

    @DisplayName("등수 세기")
    @Test
    void countLottoRankingsTest() {
        List<List<Integer>> lottoPapers = List.of(
                List.of(1, 2, 5, 7, 8, 10), //1등
                List.of(1, 2, 3, 5, 6, 9), //5등
                List.of(2, 9, 11, 13, 15, 16), //없음
                List.of(2, 5, 7, 8, 10, 40) //2등
        );
        Map<String, Integer> result = new HashMap<>() {
            {
                put("FIRST_PLACE", 1);
                put("SECOND_PLACE", 1);
                put("THIRD_PLACE", 0);
                put("FOURTH_PLACE", 0);
                put("FIFTH_PLACE", 1);
            }
        };
        assertThat(winningsCalculator.countLottoRankings(lottoPapers))
                .isEqualTo(result);
    }

    @DisplayName("총 수익금 계산")
    @Test
    void calculateTotalWinningsTest() {
        Map<String, Integer> rankingCounts = new HashMap<>() {
            {
                put("FIRST_PLACE", 1);
                put("SECOND_PLACE", 1);
                put("THIRD_PLACE", 0);
                put("FOURTH_PLACE", 0);
                put("FIFTH_PLACE", 1);
            }
        };
        long result = 2030005000L;
        assertThat(winningsCalculator.calculateTotalWinnings(rankingCounts))
                .isEqualTo(result);
    }

    @DisplayName("수익률 계산")
    @Test
    void calculateRateOfReturnTest() {
        long totalWinnings = 3000L;
        long payment = 11000L;
        double result = 27.3D;
        assertThat(winningsCalculator.calculateRateOfReturn(totalWinnings, payment))
                .isEqualTo(result);
    }
}