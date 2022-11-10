package lotto.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@DisplayName("[TEST] UserServiceTest")
class UserServiceTest {
    @Test
    @DisplayName("상금과 구입금액을 입력하면 수익률을 반환한다.")
    void calculateTheRateOfReturnTest() {
        int prizeMoney = 5000;
        int purchaseMoney = 8000;
        UserService userService = new UserService();
        assertThat(userService.calculateTheRateOfReturn(prizeMoney, purchaseMoney))
                .isNotEmpty()
                .isEqualTo("62.5");
    }

}