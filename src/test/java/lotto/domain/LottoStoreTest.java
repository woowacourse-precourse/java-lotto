package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LottoStoreTest {
    @Test
    @DisplayName("로또를 구매하는 기능 테스트")
    void purchase_lotto_test() {
        LottoStore store = new LottoStore();
        int amount = 13000;
        store.purchaseLotto(amount);

        assertThat(store.getPurchasedLotto())
                .hasSize(amount/store.getPrice())
                .isInstanceOf(List.class);
    }
}
