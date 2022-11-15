package lotto.domain;

import static lotto.domain.Ranking.FIFTH;
import static lotto.domain.Ranking.FIRST;
import static lotto.domain.Ranking.SECOND;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class GameResultTest {

    private GameResult gameResult;

    @Test
    void getRankMoney() {
        List<Ranking> rankings = Arrays.asList(FIFTH, FIFTH, SECOND, FIRST);
        long expected = FIFTH.getMoney() * 2 + SECOND.getMoney() * 1
                + FIRST.getMoney() * 1;

        gameResult = new GameResult(rankings);
        long actual = gameResult.getRankMoney();
        Assertions.assertThat(actual).isEqualTo(expected);
    }
}