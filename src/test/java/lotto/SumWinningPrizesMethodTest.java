package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.Application.Places;

import static lotto.Application.sumWinningPrizes;
import static lotto.Application.initializeNoOfLottoWinAt;
import static lotto.Application.initializePrizesAtPlaces;
import static lotto.Application.noOfLottoWinAt;

import static org.assertj.core.api.Assertions.assertThat;

class SumWinningPrizesMethodTest {
    @DisplayName("5등이 5장 있는 경우 구매 금액 테스트")
    @Test
    void sumWinningPrizesMethodTest1() {
        initializeNoOfLottoWinAt();
        initializePrizesAtPlaces();
        noOfLottoWinAt.put(Places.FIFTH, 5);
        assertThat(sumWinningPrizes()).isEqualTo(5 * 5_000L);
    }

    @DisplayName("4등이 8장 있는 경우 구매 금액 테스트")
    @Test
    void sumWinningPrizesMethodTest2() {
        initializeNoOfLottoWinAt();
        initializePrizesAtPlaces();
        noOfLottoWinAt.put(Places.FOURTH, 8);
        assertThat(sumWinningPrizes()).isEqualTo(8 * 50_000L);
    }

    @DisplayName("3등이 11장 있는 경우 구매 금액 테스트")
    @Test
    void sumWinningPrizesMethodTest3() {
        initializeNoOfLottoWinAt();
        initializePrizesAtPlaces();
        noOfLottoWinAt.put(Places.THIRD, 11);
        assertThat(sumWinningPrizes()).isEqualTo(11 * 1_500_000L);
    }

    @DisplayName("2등이 16장 있는 경우 구매 금액 테스트")
    @Test
    void sumWinningPrizesMethodTest4() {
        initializeNoOfLottoWinAt();
        initializePrizesAtPlaces();
        noOfLottoWinAt.put(Places.SECOND, 16);
        assertThat(sumWinningPrizes()).isEqualTo(16 * 30_000_000L);
    }

    @DisplayName("1등이 35장 있는 경우 구매 금액 테스트")
    @Test
    void sumWinningPrizesMethodTest5() {
        initializeNoOfLottoWinAt();
        initializePrizesAtPlaces();
        noOfLottoWinAt.put(Places.FIRST, 35);
        assertThat(sumWinningPrizes()).isEqualTo(35 * 2_000_000_000L);
    }

    @DisplayName("1등이 2백만 장 있는 경우 구매 금액 테스트")
    @Test
    void sumWinningPrizesMethodTest6() {
        initializeNoOfLottoWinAt();
        initializePrizesAtPlaces();
        noOfLottoWinAt.put(Places.FIRST, 2_000_000);
        assertThat(sumWinningPrizes()).isEqualTo(2_000_000 * 2_000_000_000L);
        System.out.println(2_000_000 * 2_000_000_000L);
    }

    @DisplayName("각 등수에 임의의 장이 있을 경우 총 상금의 선형 조합 테스트")
    @Test
    void sumWinningPrizesMethodTest7() {
        initializeNoOfLottoWinAt();
        initializePrizesAtPlaces();
        noOfLottoWinAt.put(Places.FIRST, 1);
        noOfLottoWinAt.put(Places.SECOND, 5);
        noOfLottoWinAt.put(Places.THIRD, 40);
        noOfLottoWinAt.put(Places.FOURTH, 120);
        noOfLottoWinAt.put(Places.FIFTH, 300);
        assertThat(sumWinningPrizes()).isEqualTo(
                2_000_000_000L + 30_000_000L * 5 + 1_500_000L * 40 + 50_000L * 120 + 5_000L * 300);
    }
}