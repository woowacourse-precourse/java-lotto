package lotto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class PrizeWinnerTest {

    @DisplayName("PrizeWinner의 count를 증가시킨다")
    @Test
    void addPrizeWinnerCount() {
        List<PrizeWinner> p = Arrays.asList(PrizeWinner.values());

        p.get(p.indexOf(PrizeWinner.FIRSTPLACE)).addCount();
        Integer expected = 1;

        Assertions.assertEquals(p.get(p.indexOf(PrizeWinner.FIRSTPLACE)).getCount(), expected);

    }
}
