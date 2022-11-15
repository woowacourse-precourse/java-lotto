package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class PurchasingPriceTest {

    @DisplayName("로또 구입 금액은 양의 정수이어야 한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    void purchase_money_over_zero(int money) {
        assertThatIllegalArgumentException().isThrownBy(() -> new PurchasingPrice(money))
                .withMessageContaining("[ERROR]");
    }

    @DisplayName("로또 구입 금액이 1000원으로 나누어 떨어지지 않으면 예외처리")
    @ParameterizedTest
    @ValueSource(ints = {100, 1001})
    void purchasing_money_divide_by_1000(int money) {
        assertThatIllegalArgumentException().isThrownBy(() -> new PurchasingPrice(money))
                .withMessageContaining("[ERROR]");
    }

    @DisplayName("입력 금액을 통해 구매 가능 로또 개수 계산")
    @Test
    void calculate_lotto_counts() {
        PurchasingPrice purchasingPrice = new PurchasingPrice(2000);

        assertThat(purchasingPrice.calculatePurchasableLottoCounts(1000)).isEqualTo(2);
    }
}
