package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class OperationTest {
    static final int MATCH3 = 3;
    static final int MATCH4 = 4;
    static final int MATCH5 = 5;
    static final int MATCH6 = 6;
    static final int MATCH5_BONUS = 0;

    @DisplayName("로또 번호와 당첨 번호를 비교한다.")
    @Test
    void compareWinning() {
        List<Integer> winning = List.of(1, 2, 3, 4, 5, 6);
        int bonus = 7;
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 8, 9)));
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 8)));
        HashMap<Integer, Integer> result = Operation.calculateMatches(lottos, winning, bonus);
        HashMap<Integer, Integer> answer = new HashMap<>();
        answer.put(MATCH3, 0);
        answer.put(MATCH4, 1);
        answer.put(MATCH5, 1);
        answer.put(MATCH6, 0);
        answer.put(MATCH5_BONUS, 0);
        assertThat(result).isEqualTo(answer);
    }

}
