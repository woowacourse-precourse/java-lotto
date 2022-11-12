package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RankTest {

    @Test
    void findRank() {

        assertEquals(Rank.FIRST, Rank.findRank(6));
    }
}