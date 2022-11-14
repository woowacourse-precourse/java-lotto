package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RankTest {
    @DisplayName("당첨 등수 구하기 - 2등")
    @Test
    void getRanking1(){
        int count = 4;
        boolean hasBonus = true;
        Rank resultRank = Rank.getRanking(count, hasBonus);
        assertEquals(resultRank, Rank.SECOND);
    }

    @DisplayName("당첨 등수 구하기 - 5등")
    @Test
    void getRanking2(){
        int count = 3;
        boolean hasBonus = false;
        Rank resultRank = Rank.getRanking(count, hasBonus);
        assertEquals(resultRank, Rank.FIFTH);
    }
}