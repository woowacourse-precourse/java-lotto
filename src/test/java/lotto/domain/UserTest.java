package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void 구입금액_횟수_테스트() {
        List<List<Integer>> numbers = User.randomLotto(8000);
        assertThat(numbers.size()).isEqualTo(8);
    }

    @Test
    void 보너스_번호_테스트() {
        User user = new User();
        user.setBonusNum(1);
        assertThat(user.getBonusNum()).isEqualTo(1);
    }
}