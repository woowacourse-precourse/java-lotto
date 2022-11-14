package lotto.domain;

import lotto.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UserTest {

    User user;
    UserService userService;

    @BeforeEach
    void beforeEach() {
        user = new User();
        userService = new UserService();
    }
    
    @Test
    void 수익률_정상_테스트() {
        double money = 9000.0;
        user.setMoney(money);
        double winningAmount = 3000.0;
        user.setTotalPrize(winningAmount);

        userService.calculateYield(user);
        double expect = 33.3;
        assertThat(user.getYield()).isEqualTo(expect);
    }
}