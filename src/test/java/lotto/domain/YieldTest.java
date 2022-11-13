package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class YieldTest {
    @Test
    void 수익률_테스트() {
        Statistics statistics = new Statistics(List.of(Rank.FIFTH, Rank.NONE, Rank.SECOND, Rank.THIRD, Rank.FIFTH));
        Yield yield = new Yield(5000);
        Assertions.assertEquals(630200, yield.getYield());
    }

    @Test
    void 반올림_테스트() {
        double totalRevenue = 3245;
        double totalPurchase = 10000;
        String yield = String.format("%.1f", totalRevenue / totalPurchase * 100);
        Assertions.assertEquals("32.5", yield);
    }
}