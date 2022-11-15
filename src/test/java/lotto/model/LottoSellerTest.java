package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoSellerTest {

    @DisplayName("5000으로 5장을 살 수 있다.")
    @Test
    void calculateQuantityTest() {
        LottoSeller lottoSeller = new LottoSeller(new LottoNumberGenerator());
        int quantity = lottoSeller.calculateQuantity(new PurchasePrice("5000"));
        assertThat(quantity).isEqualTo(5);
    }

    @DisplayName("5000원을 지불하면 로또 5장을 판다.")
    @Test
    void sellLotteriesToTest() {
        LottoSeller lottoSeller = new LottoSeller(new LottoNumberGenerator());
        Customer customer = new Customer(new PurchasePrice("5000"));
        lottoSeller.sellLotteriesTo(customer);
        assertThat(customer.getLotteries().size()).isEqualTo(5);
    }
}