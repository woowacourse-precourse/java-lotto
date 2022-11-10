package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;


class UserTest {
    @Test
    void setMoneyTest() {
        User testUser = new User();
        testUser.setMoney(10000);
        assertThat(testUser.getMoney()).isEqualTo(10000);
    }
    @Test
    void setWinningNumbersTest() {
        User testUser = new User();
        testUser.setWinningNumbers("1,2,3,4,5,6");
        assertThat(testUser.getWinningNumbers()).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }
}