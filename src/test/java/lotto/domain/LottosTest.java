package lotto.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;


class LottosTest {
    @DisplayName("로또를 14000원으로 구매하면 14개 발행된다.")
    @Test
    void issueLottos_14_amount() {
        Lottos lottos = new Lottos();
        lottos.issueLottos(14000);

        assertThat(lottos.getLottos().size()).isEqualTo(14);
    }
}
