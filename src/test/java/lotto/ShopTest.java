package lotto;

import lotto.model.Shop;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ShopTest {
    @DisplayName("Shop에 제시된 price가 1000원 단위로 떨어지지 않으면 예외가 발생한다.")
    @Test
    void createShopByInvalidPrice() {
        assertThatThrownBy(() -> new Shop(1200))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
