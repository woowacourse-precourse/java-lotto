package lotto.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    @Test
    void 유저_게임_횟수_출력_테스트() {
        User user = new User();
        user.setUserPrice(4000);

        assertThat(user.getUserGameCnt()).isEqualTo(4);
    }
}