package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DealerTest {

    private List<Lotto> lotteries;

    @BeforeEach
    void setUp() {
        lotteries = new ArrayList<Lotto>(
                Arrays.asList(new Lotto(List.of(8, 21, 23, 41, 42, 43)),
                        new Lotto(List.of(3, 5, 11, 16, 32, 38)),
                        new Lotto(List.of(7, 11, 16, 35, 36, 44)),
                        new Lotto(List.of(1, 8, 11, 31, 40, 43)),
                        new Lotto(List.of(13, 14, 16, 38, 40, 43)),
                        new Lotto(List.of(7, 11, 30, 40, 44, 45)),
                        new Lotto(List.of(2, 13, 22, 32, 38, 45)),
                        new Lotto(List.of(1, 3, 5, 14, 22, 45))));
    }

    @DisplayName("보너스 숫자가 맞지 않았을 때 결과 테스트")
    @Test
    void lottoMakeWithoutBonusTest() {
        List<Integer> MAKE_ANSWER = List.of(0, 0, 0, 0, 0, 1);
        Dealer dealer = new Dealer(lotteries, new Lotto(List.of(1, 2, 3, 4, 5, 6)), new Bonus(7));
        assertEquals(dealer.getResult(), MAKE_ANSWER);
    }

    @DisplayName("보너스 숫자가 맞았을 때 결과 테스트")
    @Test
    void lottoMakeWithBonusTest() {
        List<Integer> MAKE_ANSWER = List.of(0, 0, 1, 0, 0, 0);
        Dealer dealer = new Dealer(lotteries, new Lotto(List.of(8, 21, 23, 41, 42, 45)), new Bonus(43));
        assertEquals(dealer.getResult(), MAKE_ANSWER);
    }

    @Test
    void calculateEarningRateTest() {
        int PURCHASE_AMOUNT = 8000;
        float EARNING_RATE = 5000 / (float)8000 * 100;
        Dealer dealer = new Dealer(lotteries, new Lotto(List.of(1, 2, 3, 4, 5, 6)), new Bonus(7));
        assertEquals(dealer.calculateEarningRate(PURCHASE_AMOUNT), EARNING_RATE);
    }
}
