package lotto.domain;

import lotto.Validator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserLottosTest {

    @ParameterizedTest
    @ValueSource(ints = {0, -1, -150})
    void 로또_개수가_1보다_작으면(int ticketCount) {
        assertThatThrownBy(() -> new UserLottos(ticketCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 발행할 로또 개수는 적어도 하나 이상이여야 합니다.");
    }

    @Test
    void 로또_번호가_잘_생성되는지() {
        UserLottos userLottos = new UserLottos(1);
        Lotto lotto = userLottos.get().get(0);
        assertThat(Validator.isInRangeAll(lotto.get()) && Validator.isNotDuplicate(lotto.get())).isEqualTo(true);
    }
}