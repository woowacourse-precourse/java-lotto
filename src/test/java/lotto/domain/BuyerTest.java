package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BuyerTest {
    @DisplayName("구매자가 로또 한 장 가격인 1,000원 미만의 금액으로 로또를 구매하려고 하면 예외가 발생한다.")
    @Test
    void createBuyerByUnderLottoPrice() {
        String won = "999";
        assertThatThrownBy(() -> new Buyer(won))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매자가 입력한 구매 금액에 맞춰 몇 장의 로또를 구매할 수 있는지 알 수 있다.")
    @Test
    void calculateNumberOfLottos() {
        String won = "12345";
        Buyer buyer = new Buyer(won);
        assertThat(buyer.getLottos().size()).isEqualTo(12);
    }
}
