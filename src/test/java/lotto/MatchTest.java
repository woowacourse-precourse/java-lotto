package lotto;

import lotto.domain.Match;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
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
        answer.MATCH_FOUR =1;
        answer.MATCH_FIVE =1;
        assertThat(bundle(result)).isEqualTo(bundle(result));
    }

    @DisplayName("로또 번호와 당첨 번호+보너스 번호를 비교한다.")
    @Test
    void compareWinningBonus() {
        List<Integer> winning = List.of(1, 2, 3, 4, 5, 6);
        int bonus = 7;
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 8, 9)));
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 7)));
        Match result = new Match(lottos, winning, bonus);
        Match answer = new Match();
        answer.MATCH_FOUR =1;
        answer.MATCH_FIVE_BONUS =1;
        assertThat(bundle(result)).isEqualTo(bundle(result));
    }

    public HashMap<String, Integer> bundle(Match match) {
        HashMap<String, Integer> result = new HashMap<>();
        result.put("match3", match.MATCH_THREE);
        result.put("match4", match.MATCH_FOUR);
        result.put("match5", match.MATCH_FIVE);
        result.put("match6", match.MATCH_SIX);
        result.put("match5Bonus", match.MATCH_FIVE_BONUS);
        return result;
    }
}
