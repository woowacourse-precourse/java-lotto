package lotto.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

@DisplayName("[TEST] UserServiceTest")
class UserServiceTest {
    @Test
    @DisplayName("상금과 구입금액을 입력하면 수익률을 반환한다.")
    void calculateTheRateOfReturnTest() {
        int prizeMoney = 30000;
        int purchaseMoney = 20000;
        UserService userService = new UserService();
        assertThat(userService.calculateTheRateOfReturn(prizeMoney, purchaseMoney))
                .isNotEmpty()
                .isEqualTo("150.0");
    }

    @Test
    @DisplayName("당첨된 복권을 입력하면 상금을 반환한다.")
    void calculateUserPrizeTest() {
        ArrayList<Integer> numberOfWins = new ArrayList<>(Arrays.asList(0,0,1,1,1));
        UserService userService = new UserService();
        assertThat(userService.calculateUserPrize(numberOfWins))
                .isPositive()
                .isGreaterThan(-1)
                .isEqualTo(1555000);
    }

}