package lotto.domain;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.EnumMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RankResultTest {
    @Test
    void getYield() {
        Map<Rank, Integer> rankResult = new EnumMap<>(Rank.class);
        rankResult.put(Rank.FIFTH, 1);
        rankResult.put(Rank.NONE, 7);
        BigDecimal yield = new RankResult().getYield(rankResult);
        BigDecimal bigDecimal = new BigDecimal("62.5");
        assertEquals(0,bigDecimal.compareTo(yield));
    }
}
