package lotto.service;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class MyTotalMoneyTest extends NsTest {
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
    void getMoney() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("1000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "3개 일치 (5,000원) - 1개"
                    );
                },
                List.of(1,2,3,7,8,9)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
