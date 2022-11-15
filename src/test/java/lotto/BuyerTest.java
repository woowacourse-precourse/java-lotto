package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BuyerTest {

    @DisplayName("구입 금액은 1000의 배수여야 한다.")
    @Test
    void creatBuyerByWrongPurchase() {
        assertThatThrownBy(() -> new Buyer(1001))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
