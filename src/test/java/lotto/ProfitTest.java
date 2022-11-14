package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static lotto.Game.RANK.*;
import static org.assertj.core.api.Assertions.assertThat;

public class ProfitTest {
    @DisplayName("당첨된 등수를 확인한다")
    @Test
    void checkBonusOfSameNumber(){
        Lotto playerLotto = new Lotto(List.of(1,2,3,4,5,6));
        Lotto winLotto = new Lotto(List.of(1,3,5,6,8,9));
        Game game = new Game();
        int bonus = 2;
        Game.RANK rank = game.countRank(playerLotto, winLotto.getNumbers(), bonus);
        assertThat(rank == TWO);
    }

    @DisplayName("당첨된 금액을 확인한다")
    @Test
    void checkPrize(){
        Lotto playerLotto1 = new Lotto(List.of(1,2,3,4,5,6));
        Lotto playerLotto2 = new Lotto(List.of(1,2,3,10,11,12));
        Lotto winLotto = new Lotto(List.of(1,3,5,6,8,9));
        Game game = new Game();
        int bonus = 2;
        Game.RANK rank1 = game.countRank(playerLotto1, winLotto.getNumbers(), bonus);
        Game.RANK rank2 = game.countRank(playerLotto2, winLotto.getNumbers(), bonus);

        List<Game.RANK> ranks = new ArrayList<>();
        ranks.add(rank1);
        ranks.add(rank2);
        int result = game.calculatePrize(ranks);

        assertThat(result == 30_005_000);
    }
}
