package lotto.service;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

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

    @Test
    @DisplayName("구입한 로또 하나가 몇개의 숫자를 맞췄는지 반환한다.")
    void checkTheNumberOfWinsTest() {
        UserService userService = new UserService();
        Lotto winningNumbers = new Lotto(Arrays.asList(1,2,3,4,5,6));
        Lotto checkingNumbers = new Lotto(Arrays.asList(1,11,3,4,5,6));
        assertThat(userService.checkTheNumberOfWinsInOne(winningNumbers,checkingNumbers))
                .isEqualTo(5);
    }

    @Test
    @DisplayName("입력된 금액으로 몇 개의 로또를 구입하는지 반환한다.")
    void findTheNumberOfLotteryTicketsPurchasedTest() {
        UserService userService = new UserService();
        String purchaseAmount = "8000";
        assertThat(userService.findTheNumberOfLotteryTicketsPurchased(purchaseAmount))
                .isEqualTo(8);
    }

}