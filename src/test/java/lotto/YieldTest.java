package lotto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class YieldTest {
    @Test
    void calculateYield() {
        int myLottoCnt = 8;
        int totalPrize = Win.FIFTH.prize();
        Yield yield = new Yield(myLottoCnt, totalPrize);
        assertEquals(62.5, yield.yield);
    }
}