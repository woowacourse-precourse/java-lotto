package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;


class LottoPileTest {
    @DisplayName("로또를 14000원으로 구매하면 14개 발행된다.")
    @Test
    void issueLottos_14_amount() {
        LottoPile lottoPile = new LottoPile();
        lottoPile.issueLottos(14000);

        assertThat(lottoPile.getLottos().size()).isEqualTo(14);
    }
}
