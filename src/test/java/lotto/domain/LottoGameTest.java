package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.*;

class LottoGameTest {

    @Test
    void calculateTotalEarning() {
        List<Lotto> lotteries = new ArrayList<>();
        List<Integer> matchCounts = new ArrayList<>(asList(0, 0, 0, 1, 0, 1, 1, 0));
        LottoGame lottoGame = new LottoGame(lotteries, matchCounts);
        float result = lottoGame.calculateTotalEarning();
        assertEquals(result, 2001505000);
    }
}