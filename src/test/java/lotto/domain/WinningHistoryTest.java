package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WinningHistoryTest {
    @Test
    @DisplayName("results를 주면 WinningHistory객체를 생성 해야 한다.")
    void createWinningHistoryObject() {
        // given
        ArrayList<Map<String, Object>> results = new ArrayList<>();
        results.add(Map.of("count", 6, "bonus", false));
        results.add(Map.of("count", 5, "bonus", true));
        results.add(Map.of("count", 5, "bonus", false));
        results.add(Map.of("count", 4, "bonus", false));
        results.add(Map.of("count", 3, "bonus", false));
        results.add(Map.of("count", 0, "bonus", false));

        // when
        WinningHistory winningHistory = new WinningHistory(results);

        // then
        assertEquals(1, winningHistory.getFirstCount());
        assertEquals(1, winningHistory.getSecondCount());
        assertEquals(1, winningHistory.getThirdCount());
        assertEquals(1, winningHistory.getFourthCount());
        assertEquals(1, winningHistory.getFifthCount());
        assertEquals(2_031_555_000, winningHistory.getWinningAmount());
        assertEquals(6771850.0, winningHistory.getYield());
    }
}