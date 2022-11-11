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
}