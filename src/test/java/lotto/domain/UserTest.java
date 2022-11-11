package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UserTest {

    User user;

    @BeforeEach
    void beforeEach() {
        user = new User();
    }
    
    @Test
    void 수익률_정상_테스트() {
        double money = 9000.0;
        user.setMoney(money);
        double winningAmount = 3000.0;
        user.setWinningAmount(winningAmount);

        double result = user.calculateYield();
        double expect = 33.3;
        assertThat(result).isEqualTo(expect);
    }
}