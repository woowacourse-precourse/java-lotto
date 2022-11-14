package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import lotto.Application.Places;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import static lotto.Application.printEarningsRate;
import static lotto.Application.initializeNoOfLottoWinAt;
import static lotto.Application.initializePrizesAtPlaces;
import static lotto.Application.noOfLottoWinAt;
import static lotto.Application.noOfLottos;

class PrintEarningsRateMethodTest extends NsTest {
    @Test
    void printEarningsRate_메소드_테스트1() {
        noOfLottos = 2_000_000;
        initializeNoOfLottoWinAt();
        initializePrizesAtPlaces();
        noOfLottoWinAt.put(Places.FIRST, 1);
        noOfLottoWinAt.put(Places.SECOND, 5);
        noOfLottoWinAt.put(Places.THIRD, 40);
        noOfLottoWinAt.put(Places.FOURTH, 120);
        noOfLottoWinAt.put(Places.FIFTH, 300);
        noOfLottoWinAt.put(Places.NONE, 1_999_534);

        assertSimpleTest(() -> {
            printEarningsRate();
            assertThat(output()).contains("총 수익률은 110.9%입니다.");
        });
    }

    @Test
    void printEarningsRate_메소드_테스트2() {
        noOfLottos = 2_000_000;
        initializeNoOfLottoWinAt();
        initializePrizesAtPlaces();
        noOfLottoWinAt.put(Places.FIRST, 0);
        noOfLottoWinAt.put(Places.SECOND, 0);
        noOfLottoWinAt.put(Places.THIRD, 0);
        noOfLottoWinAt.put(Places.FOURTH, 0);
        noOfLottoWinAt.put(Places.FIFTH, 0);
        noOfLottoWinAt.put(Places.NONE, 2_000_000);

        assertSimpleTest(() -> {
            printEarningsRate();
            assertThat(output()).contains("총 수익률은 0.0%입니다.");
        });
    }

    @Test
    void printEarningsRate_메소드_테스트3() {
        noOfLottos = 2_000_000;
        initializeNoOfLottoWinAt();
        initializePrizesAtPlaces();
        noOfLottoWinAt.put(Places.FIRST, 2_000_000);

        assertSimpleTest(() -> {
            printEarningsRate();
            assertThat(output()).contains("총 수익률은 200000000.0%입니다.");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}