package lotto.model;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoResultTest {
    private static final List<Integer> WINNING_NUMBERS = List.of(1, 2, 3, 4, 5, 6);

    @Test
    void 로또_결과() {
        LottoResult sixMatches = new LottoResult(WINNING_NUMBERS, List.of(1, 2, 3, 4, 5, 6), 10);
        LottoResult fiveMatches = new LottoResult(WINNING_NUMBERS, List.of(1, 2, 3, 4, 5, 7), 10);
        LottoResult fourMatches = new LottoResult(WINNING_NUMBERS, List.of(1, 2, 3, 4, 7, 8), 10);
        LottoResult threeMatches = new LottoResult(WINNING_NUMBERS, List.of(1, 2, 3, 7, 8, 9), 10);
        LottoResult fiveMatchesAndBonus = new LottoResult(WINNING_NUMBERS, List.of(1, 2, 3, 4, 5, 7), 7);

        Assertions.assertEquals(6, sixMatches.getCountMatch());
        Assertions.assertEquals(5, fiveMatches.getCountMatch());
        Assertions.assertEquals(4, fourMatches.getCountMatch());
        Assertions.assertEquals(3, threeMatches.getCountMatch());
        Assertions.assertEquals(1, fiveMatchesAndBonus.getBonusMatch());

    }

}