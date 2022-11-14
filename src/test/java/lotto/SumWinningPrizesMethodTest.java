package lotto;

import org.junit.jupiter.api.Test;

import lotto.Application.Places;

import static lotto.Application.sumWinningPrizes;
import static lotto.Application.initializeNoOfLottoWinAt;
import static lotto.Application.initializePrizesAtPlaces;
import static lotto.Application.noOfLottoWinAt;

import static org.assertj.core.api.Assertions.assertThat;

class SumWinningPrizesMethodTest {
    @Test
    void sumWinningPrizes_메소드_테스트1() {
        initializeNoOfLottoWinAt();
        initializePrizesAtPlaces();
        noOfLottoWinAt.put(Places.FIFTH, 5);
        assertThat(sumWinningPrizes()).isEqualTo(5 * 5_000L);
    }

    @Test
    void sumWinningPrizes_메소드_테스트2() {
        initializeNoOfLottoWinAt();
        initializePrizesAtPlaces();
        noOfLottoWinAt.put(Places.FOURTH, 8);
        assertThat(sumWinningPrizes()).isEqualTo(8 * 50_000L);
    }

    @Test
    void sumWinningPrizes_메소드_테스트3() {
        initializeNoOfLottoWinAt();
        initializePrizesAtPlaces();
        noOfLottoWinAt.put(Places.THIRD, 11);
        assertThat(sumWinningPrizes()).isEqualTo(11 * 1_500_000L);
    }

    @Test
    void sumWinningPrizes_메소드_테스트4() {
        initializeNoOfLottoWinAt();
        initializePrizesAtPlaces();
        noOfLottoWinAt.put(Places.SECOND, 16);
        assertThat(sumWinningPrizes()).isEqualTo(16 * 30_000_000L);
    }

    @Test
    void sumWinningPrizes_메소드_테스트5() {
        initializeNoOfLottoWinAt();
        initializePrizesAtPlaces();
        noOfLottoWinAt.put(Places.FIRST, 35);
        assertThat(sumWinningPrizes()).isEqualTo(35 * 2_000_000_000L);
    }

    @Test
    void sumWinningPrizes_메소드_테스트6() {
        initializeNoOfLottoWinAt();
        initializePrizesAtPlaces();
        noOfLottoWinAt.put(Places.FIRST, 2_000_000);
        assertThat(sumWinningPrizes()).isEqualTo(2_000_000 * 2_000_000_000L);
    }

    @Test
    void sumWinningPrizes_메소드_테스트7() {
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