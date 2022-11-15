package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class LottoStoreClerkTest {
    @Nested
    class SellTest {
        @DisplayName("5000원으로 로또 5개 구매")
        @Test
        void buy5Lottos() {
            LottoStoreClerk clerk = new LottoStoreClerk();
            List<Lotto> lottos = clerk.sellLotto(5000);
            assertThat(lottos.size()).isEqualTo(5);
        }

        @DisplayName("0원으로 로또 0개 구매")
        @Test
        void buy0Lotto() {
            LottoStoreClerk clerk = new LottoStoreClerk();
            List<Lotto> lottos = clerk.sellLotto(0);
            assertThat(lottos.size()).isEqualTo(0);
        }
    }
}