package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

public class LottoStoreTest {
    @Test
    @DisplayName("로또 구매 시 로또번호를 저장한 리스트를 반환하는 가?")
    void lotto_purchase_test() {
        LottoStore store = new LottoStore();
        int amount = 13000;
        store.purchaseLotto(amount);

        assertThat(store.getPurchasedLotto())
                .hasSize(amount / Policy.PRICE)
                .isInstanceOf(List.class);
    }
}
