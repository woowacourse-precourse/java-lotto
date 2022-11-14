package lotto;

import lotto.domain.BuyLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BuyLottoTest {
    @DisplayName("로또 구매 수량이 1000원 미만인 경우")
    @Test
    void case1() {
        int price = 984;
        assertThatThrownBy(() -> BuyLotto.getQuantity(price))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR]Lotto purchase price must be more than 1000 won.");
    }

    @DisplayName("로또 구매 금액이 1000원으로 나누어 떨어지지 않는 경우")
    @Test
    void case2() {
        int price = 2500;
        assertThatThrownBy(() -> BuyLotto.getQuantity(price))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR]Buy the lotto by 1000 won.");
    }
}
