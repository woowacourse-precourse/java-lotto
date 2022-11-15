package lotto.model;

import lotto.Enum.Rank;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class ProfitRateTest {
    @DisplayName("구입 금액과 당첨 결과를 바탕으로 수익률을 정확히 계산한다")
    @Nested
    class GetProfitRateTest {
        @Test
        void case1() {
            Map<Rank, Integer> ranks = Map.ofEntries(
                    Map.entry(Rank.FIRST, 1),
                    Map.entry(Rank.SECOND, 0),
                    Map.entry(Rank.THIRD, 0),
                    Map.entry(Rank.FOURTH, 0),
                    Map.entry(Rank.FIFTH, 0),
                    Map.entry(Rank.DEFAULT, 7)
            );
            int purchase = 8000;
            ProfitRate profitRate = new ProfitRate(ranks, purchase);
            assertEquals(profitRate.getProfitRate(),
                    Rank.FIRST.getRank().get(1) / (double) purchase * 100);
        }

    }
}
