package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottosTest {
    @DisplayName("구매한 개수만큼 로또를 발행한다.")
    @Test
    void getQuantity() {
        int quantity = 5;
        Lottos lottos = new Lottos(quantity);

        assertThat(lottos.getQuantity()).isEqualTo(quantity);
    }
}