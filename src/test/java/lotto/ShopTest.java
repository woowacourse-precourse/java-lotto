package lotto;

import lotto.model.Lotto;
import lotto.model.Shop;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ShopTest {
    @DisplayName("Shop이 생성되고 lottoPayed의 수가 정확한지 확인")
    @Test
    void getLottoPayed() {
        // given
        final int price = 8000;
        final int size = price / Constant.lottoAmount;
        final Shop shop = new Shop(price);

        // when
        final List<Lotto> lottoPayed = shop.getLottoPayed();

        // then
        assertThat(lottoPayed.size() == size).isTrue();
    }

    @DisplayName("Shop에 제시된 price가 1000원 단위로 떨어지지 않으면 예외가 발생한다.")
    @Test
    void createShopByInvalidPrice() {
        assertThatThrownBy(() -> new Shop(1200))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
