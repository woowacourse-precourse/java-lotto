package domain;

import org.junit.jupiter.api.DisplayName;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class PurchaseMoneyTest {
    @DisplayName("구입 금액이 1000원 단위가 아닌 경우")
    void incorrectUnit() {
        String input = "1500";

        assertThatThrownBy(() -> new PurchaseMoney(input))
                .hasMessage("[ERROR] 구입 금액은 1000원 단위로 가능합니다");
    }
}