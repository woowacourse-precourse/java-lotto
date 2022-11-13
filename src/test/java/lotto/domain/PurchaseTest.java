package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PurchaseTest {

    @DisplayName("0원으로는 살 수 없다.")
    @Test
    void buyLottoByZero() {
        assertThatThrownBy(() -> new Purchase("0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1000원으로 나누어 떨어지지 않으면 살 수 없다.")
    @Test
    void buyLottoByNotDividedThousand() {
        assertThatThrownBy(() -> new Purchase("1001"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("음수 역시 살 수 없다.")
    @Test
    void buyLottoByNegative() {
        assertThatThrownBy(() -> new Purchase("-1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("금액에 맞는 로또를 구매할 수 있다.")
    @Test
    void buyLottoBySixThousand() {
        Purchase purchase = new Purchase("6000");
        List<Lotto> lottoes = purchase.getLottoes();

        assertThat(lottoes.size()).isEqualTo(6);
    }
}