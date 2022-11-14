package lotto.Model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BuyerTest {
    @DisplayName("금액만큼 로또를 산다.")
    @Test
    void buyLotto() {
        String input = "6000";
        Buyer buyer = new Buyer(input);
        int result = buyer.getLottoWallet().size();
        assertThat(result).isEqualTo(6);
    }


}
