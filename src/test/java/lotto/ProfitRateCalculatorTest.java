package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ProfitRateCalculatorTest {

    @DisplayName("수익률을 올바르게 계산하는지 확인한다.")
    @Test
    void 수익률_계산() {
        //given
        int money = 8000;
        List<Integer> winningNumber = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(8, 21, 23, 41, 42, 43)));
        lottos.add(new Lotto(List.of(3, 5, 11, 16, 32, 38)));
        lottos.add(new Lotto(List.of(7, 11, 16, 35, 36, 44)));
        lottos.add(new Lotto(List.of(1, 8, 11, 31, 41, 42)));
        lottos.add(new Lotto(List.of(13, 14, 16, 38, 42, 45)));
        lottos.add(new Lotto(List.of(7, 11, 30, 40, 42, 43)));
        lottos.add(new Lotto(List.of(2, 13, 22, 32, 38, 45)));
        lottos.add(new Lotto(List.of(1, 3, 5, 14, 22, 45)));
        ProfitRateCalculator profitRateCalculator = new ProfitRateCalculator();
        //when
        double profitRate = profitRateCalculator.calculate(lottos, money, winningNumber, bonusNumber);
        //then
        assertThat(profitRate).isEqualTo(62.5);
    }
}
