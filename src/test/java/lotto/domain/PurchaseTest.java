package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PurchaseTest {

    @DisplayName("금액에 맞는 로또를 구매할 수 있다.")
    @Test
    void buyLottoBySixThousand() {
        Purchase purchase = new Purchase(6000);
        List<Lotto> lottoes = purchase.getLottoes();

        assertThat(lottoes.size()).isEqualTo(6);
    }
}