package lotto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class PrizeWinnerTest {

    private static final List<PrizeWinner> prizeWinners = Arrays.asList(PrizeWinner.values());

    @BeforeEach
    void setUp() {
        for(PrizeWinner prizeWinner : prizeWinners) {
            prizeWinner.setCount(0);
        }
    }

    @DisplayName("PrizeWinner의 count를 증가시킨다")
    @Test
    void addPrizeWinnerCount() {
        PrizeWinner prizeWinner = prizeWinners.get(prizeWinners.indexOf(PrizeWinner.FIRSTPLACE));
        Integer expectedCount = 1;

        prizeWinner.addCount();

        Assertions.assertEquals(prizeWinner.getCount(), expectedCount);
    }

}
