package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class PriceQuantityTest {

    @Test
    @DisplayName("구입 금액에 따라 로또개수 계산")
    void calculateQuantity() {
        //given
        PriceQuantity lottoQuantity = new PriceQuantity(8000);
        //when
        lottoQuantity.calculateQuantity();
        int quantity = lottoQuantity.getQuantity();
        //then
        Assertions.assertThat(quantity).isEqualTo(8);
    }
}