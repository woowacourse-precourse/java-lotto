package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BuyLottoTest {
    @DisplayName("구매한 액수가 1000원 단위가 아닐 때 예외가 발생한다.")
    @Test
    void notPaid1000unit() {
        assertThatThrownBy(() -> new BuyLotto(12345))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매한 액수에 따라 올바른 로또 구매 횟수를 반환한다.")
    @Test
    void countNumberToBuyLotto() {
        BuyLotto myBuyLotto = new BuyLotto(10000000);
        assertThat(myBuyLotto.lottoCount).isEqualTo(10000);
    }
}
