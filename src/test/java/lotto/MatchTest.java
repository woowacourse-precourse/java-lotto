package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MatchTest {
    @DisplayName("로또 번호와 당첨 번호를 비교한다.")
    @Test
    void compareWinning() {
        List<Integer> winning = List.of(1, 2, 3, 4, 5, 6);
        int bonus = 7;
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 8, 9)));
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 8)));
        Match result = new Match(lottos, winning, bonus);
        Match answer = new Match();
        answer.match4=1;
        answer.match5=1;
        assertThat(result.bundle()).isEqualTo(answer.bundle());
    }
}
