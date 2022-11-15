package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class BuyerTest {
    @DisplayName("입력한 금액만큼 로또용지들이 생성되는지 확인")
    @Test
    void createLottoByLottoAmount() {
        Buyer buyer = new Buyer();
        String amount = "9000";
        buyer.buyLotto(amount);
        assertThat(buyer.getLottos().size()).isEqualTo(9);
    }


}
