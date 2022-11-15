package lotto.model;


import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserTest {

    @Test
    @DisplayName("1,000원 단위의 구입 금액이 주어졌을 경우 로또의 개수를 구한다.")
    void getLottoCount() {
        User user = new User(10000);
        assertThat(user.getLottoCount()).isEqualTo(10);
    }

    @Test
    @DisplayName("로또의 개수만큼 로또를 발행한다.")
    void testName() {
        User user = new User(2000);
        int lottoCount = user.getLottoCount();
        List<Lotto> lottos = user.getLottos();
        assertThat(lottos.size()).isEqualTo(lottoCount);
    }
}