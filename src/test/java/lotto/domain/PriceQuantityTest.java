package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @Test
    @DisplayName("1000원 단위가 아닌 금액 입력시, 예외처리")
    void isValidateMoney() {
        //given
        PriceQuantity lottoQuantity = new PriceQuantity(8500);
        //when
        //then
        assertThatThrownBy(() -> {lottoQuantity.isValidateMoney();})
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(PriceQuantity.MONEY_ERROR_MESSAGE);
    }
}