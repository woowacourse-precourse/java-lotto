package lotto.domain;

import lotto.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UserServiceTest {

    User user;
    UserService userService;

    @BeforeEach
    void beforeEach() {
        user = new User();
        userService = new UserService();
    }

    @DisplayName("수익률 계산 함수 테스트")
    @Test
    void calculateYieldTest() {
        double money = 9000.0;
        user.setMoney(money);
        double winningAmount = 3000.0;
        user.setTotalPrize(winningAmount);

        userService.calculateYield(user);
        double expect = 33.3;
        assertThat(user.getYield()).isEqualTo(expect);
    }
}