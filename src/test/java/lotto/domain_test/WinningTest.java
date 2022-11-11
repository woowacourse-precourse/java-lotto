package lotto.domain_test;
import lotto.Ranking;
import lotto.domain.Winning;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static lotto.Ranking.*;
import static org.assertj.core.api.Assertions.*;
public class WinningTest {

    Winning winning;

    @BeforeEach
    void initializeClass(){
        this.winning = new Winning();
    }

    @Test
    @DisplayName("리스트에 넣은 순위들은 해시맵으로 해당 등수를 몇번 달성했는지 리턴해준다. ")
    void createMapWithRankings(){
        addCases();
        assertThat(winning.figureSameRanking()).isEqualTo(makeExampleMap());
    }

    private void addCases(){
        winning.addRankingOfPlayer(THREE_MATCH);
        winning.addRankingOfPlayer(THREE_MATCH);
        winning.addRankingOfPlayer(THREE_MATCH);
        winning.addRankingOfPlayer(Ranking.FIVE_MATCH_WITH_BONUS);
        winning.addRankingOfPlayer(Ranking.FIVE_MATCH);
    }

    private HashMap<Ranking, Integer> makeExampleMap(){
        HashMap<Ranking, Integer> exampleMap = new HashMap<>();
        exampleMap.put(THREE_MATCH, 3);
        exampleMap.put(FOUR_MATCH, 0);
        exampleMap.put(FIVE_MATCH, 1);
        exampleMap.put(FIVE_MATCH_WITH_BONUS, 1);
        exampleMap.put(SIX_MATCH, 0);
        return exampleMap;
    }
}
