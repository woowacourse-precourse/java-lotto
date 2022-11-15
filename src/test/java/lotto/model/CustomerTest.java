package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CustomerTest {

    @DisplayName("구매 금액 5000을 입력하면 소비자는 5000원을 가지고 있어야 한다.")
    @Test
    void getPurchasePriceTest() {
        Customer customer = new Customer(new PurchasePrice("5000"));
        Assertions.assertThat(customer.getPurchasePrice().getPurchasePrice()).isEqualTo(5000);
    }
}