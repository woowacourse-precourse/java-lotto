package model;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningStaticTest {

    @Test
    @DisplayName("[WinningStatic] 3개일치 1개, 4개일치 1개 테스트")
    void threeAndFour() {
        //given
        int purchaseMoney = 4000;
        List<Result> results = Arrays.asList(Result.THREE, Result.FOUR, Result.LOST, Result.LOST);
        //when
        WinningStatic winningStatic = new WinningStatic();
        winningStatic.compute(purchaseMoney, results);
        //then
        HashMap<Result, Integer> resultStatic = winningStatic.getResultStatic();
        assertThat(resultStatic.get(Result.THREE)).isEqualTo(1);
        assertThat(resultStatic.get(Result.FOUR)).isEqualTo(1);
        assertThat(resultStatic.get(Result.LOST)).isEqualTo(2);
    }

    @Test
    @DisplayName("[WinningStatic] 3개일치 3개")
    void threeThird() {
        //given
        int purchaseMoney = 4000;
        List<Result> results = Arrays.asList(Result.THREE, Result.THREE, Result.THREE, Result.LOST);
        //when
        WinningStatic winningStatic = new WinningStatic();
        winningStatic.compute(purchaseMoney, results);
        //then
        HashMap<Result, Integer> resultStatic = winningStatic.getResultStatic();
        assertThat(resultStatic.get(Result.THREE)).isEqualTo(3);
        assertThat(resultStatic.get(Result.LOST)).isEqualTo(1);
    }

    @Test
    @DisplayName("[WinningStatic] 수익률 계산(리드미 예제)")
    void readmeYield() {
        //given
        int purchaseMoney = 8000;
        List<Result> results = new ArrayList<>();
        results.add(Result.THREE);
        for (int count = 1; count <= 7; count++) {
            results.add(Result.LOST);
        }
        //when
        WinningStatic winningStatic = new WinningStatic();
        winningStatic.compute(purchaseMoney, results);
        //then
        String yield = String.format("%.1f", winningStatic.getYield());
        assertThat(yield).isEqualTo("62.5");
    }

    @Test
    @DisplayName("[WinningStatic] WinningStatic순서대로 출력(LOST)제외")
    void withoutLostGetList() {
        //given
        //when
        List<Result> resultsWithoutLost = Result.getResultsWithoutLost();
        //then
        assertThat(resultsWithoutLost.get(0)).isEqualTo(Result.THREE);
        assertThat(resultsWithoutLost.get(1)).isEqualTo(Result.FOUR);
        assertThat(resultsWithoutLost.get(2)).isEqualTo(Result.FIVE);
        assertThat(resultsWithoutLost.get(3)).isEqualTo(Result.FIVE_BONUS);
        assertThat(resultsWithoutLost.get(4)).isEqualTo(Result.SIX);
    }
}