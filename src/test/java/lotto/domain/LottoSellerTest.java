package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoSellerTest {
    @DisplayName("구매 금액만큼 발급 개수 반환한다.")
    @Test
    void 구매_금액만큼_로또_개수() {
        int money = 15_000;
        int pages = LottoSeller.getInstance.getSellPages(money);
        assertThat(pages).isEqualTo(15);
    }
}
