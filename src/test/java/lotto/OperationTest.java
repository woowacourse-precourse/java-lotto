package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class OperationTest {
    @DisplayName("수익과 수익률을 계산한다.")
    @Test
    void calculateEarning() {
        List<Integer> winning = List.of(1, 2, 3, 4, 5, 6);
        int bonus = 7;
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 8, 9)));
        lottos.add(new Lotto(List.of(1, 2, 3, 8, 9, 10)));
        Match match = new Match(lottos, winning, bonus);
        int earning=Operation.calculateEarning(match);
        double earningRate=Operation.calculateEarningRate(2000,earning);
        System.out.println(earningRate);
        assertThat(earningRate).isEqualTo(2750);
    }
}
