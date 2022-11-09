package lotto.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class WinningMoneyTest {
    private static final List<Integer> LOTTO_NUMBERS = Arrays.asList(1,2,3,4,5,7);
    private WinningMoney winningMoney;
    private List<Integer> myNumbers;
    private int money;
    @BeforeEach
    public void setUp() {
        winningMoney = new WinningMoney();
    }

    @Test
    public void 돈_반환1() {
        myNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        money = winningMoney.getMyMoney(LOTTO_NUMBERS, myNumbers, 6);
        Assertions.assertThat(money).isEqualTo(30000000);
    }

    @Test
    public void 돈_반환2() {
        myNumbers = Arrays.asList(1, 2, 3, 4, 5, 7);
        money = winningMoney.getMyMoney(LOTTO_NUMBERS, myNumbers, 6);
        Assertions.assertThat(money).isEqualTo(2000000000);
    }

    @Test
    public void 돈_반환3() {
        myNumbers = Arrays.asList(1, 2, 12, 32, 44, 11);
        money = winningMoney.getMyMoney(LOTTO_NUMBERS, myNumbers, 6);
        Assertions.assertThat(money).isEqualTo(0);
    }
}
