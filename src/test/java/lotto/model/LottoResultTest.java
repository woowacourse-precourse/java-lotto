package lotto.model;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoResultTest {
    private static final List<Integer> WINNING_NUMBERS = List.of(1, 2, 3, 4, 5, 6);
    public static final int BONUS_NUMBER = 42;
    public static final List<List<Integer>> ALL_PLAYER_NUMBERS = List.of(List.of(1, 2, 3, 4, 5, 6),
            List.of(1, 2, 3, 4, 5, 7), List.of(1, 2, 3, 4, 7, 8),
            List.of(1, 2, 3, 7, 8, 9), List.of(1, 2, 3, 4, 5, 42));

    @Test
    void 로또_결과() {
        LottoResult result = new LottoResult(WINNING_NUMBERS, BONUS_NUMBER, ALL_PLAYER_NUMBERS);
        Assertions.assertEquals(List.of(6, 5, 4, 3, 5), result.getMatches());
        Assertions.assertEquals(List.of(false, false, false, false, true), result.getBonusMatches());
    }
}