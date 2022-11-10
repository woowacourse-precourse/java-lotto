package lotto.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class MyTotalMoneyTest {
    private MyTotalMoney myTotalMoney;
    private List<Integer> winningNumber;
    private int bonusNumber;

    @BeforeEach
    public void setUp() {
        myTotalMoney = new MyTotalMoney();
        winningNumber = Arrays.asList(1,2,3,4,5,6);
        bonusNumber = 7;
    }

    @Test
    public void howMuch() {
        int total = myTotalMoney.totalMoney(5000, winningNumber, bonusNumber);
        Assertions.assertThat(total).isGreaterThanOrEqualTo(0);
        //동작만 확인
    }
}
