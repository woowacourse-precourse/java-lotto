package lotto;

import lotto.domain.Purchase;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PurchaseTest {

    @Test
    void isValidTest() {
        int money = 14000;
        assertThat(new Purchase().isValid(money)).isTrue();
    }

    @Test
    void canBuyLottoTest() {
        int money = 14000;
        assertThat(new Purchase().canBuyLotto(money)).isEqualTo(14);
    }
}
