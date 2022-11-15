package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UserLottosTest {

    @Test
    void 랜덤_로또_발행_테스트() {
        UserLottos userLottos = new UserLottos(12000);
        userLottos.getUserLottos().stream().forEach(lotto -> {
            assertThat(6).isEqualTo(lotto.getNumbers().size());
        });
    }


}