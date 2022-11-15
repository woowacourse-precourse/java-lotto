package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static lotto.Result.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CalculatorTest {
    List<List<Integer>> purchasedLottos = new ArrayList<>(List.of(
            List.of(2, 5, 24, 29, 34, 45),
            List.of(2, 5, 26, 34, 44, 45),
            List.of(7, 14, 22, 27, 30, 37),
            List.of(15, 20, 34, 37, 41, 43),
            List.of(8, 11, 18, 29, 32, 42)
    ));
    List<Integer> winningNum = new ArrayList<>(List.of(2, 5, 24, 29, 34, 44));
    int bonusNum = 45;

    @DisplayName("각 로또 당 맞춘 숫자의 개수를 반환한다. 2등은 -1 을 반환한다.")
    @Test
    void calcCorrectNumCount() {
        List<Integer> calcResult = new ArrayList<>(List.of(-1, 4));
        Calculator calculator = new Calculator(purchasedLottos, winningNum, bonusNum);

        assertThat(calculator.calculateCorrectNum()).isEqualTo(calcResult);
    }

    @DisplayName("등수에 따른 당첨 개수를 반환한다.")
    @Test
    void calcResultRankCount() {
        LinkedHashMap<Result, Integer> calcResult = new LinkedHashMap<>(Map.of(
                FIFTH, 0,
                FOURTH, 1,
                THIRD, 0,
                SECOND, 1,
                FIRST, 0
        ));
        Calculator calculator = new Calculator(purchasedLottos, winningNum, bonusNum);
        assertThat(calculator.countResultRank(new ArrayList<>(List.of(-1, 4)))).isEqualTo(calcResult);
    }

    @DisplayName("총 수익률을 계산한다.")
    @Test
    void calcProfit() {
        Calculator calculator = new Calculator(purchasedLottos, winningNum, bonusNum);
        double calcResult = ((double)(FOURTH.prize() + SECOND.prize())) / ((double) (purchasedLottos.size() * Manager.COST)) * 100;
        assertThat(calculator.calcProfit(calculator.countResultRank(calculator.calculateCorrectNum())) == (calcResult)).isTrue();
    }
}
