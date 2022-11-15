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
        double[] moneys = {8000.0, 9000.0, 10000.0, 10000.0, 13000.0};
        double[] totalPrizes = {5000.0, 3000.0, 10000.0, 100000.0, 39000.0};
        double[] expects = {62.5, 33.3, 100.0, 1000.0, 300.0};

        for (int index = 0; index < moneys.length; index++) {
            user.setMoney(moneys[index]);
            user.setTotalPrize(totalPrizes[index]);
            userService.calculateYield(user);

            assertThat(user.getYield()).isEqualTo(expects[index]);
        }
    }
}